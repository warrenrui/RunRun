package designPattern.future;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ExceptionConcurrentInvoke {
    public static void main(String[] args) {

        final int taskNum = 10;
        final long exeTime = 3000;
        final int exceptionNum = 3;
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        final ArrayList<String> resultList = new ArrayList<>();
        final List<String> synchronizedStockDetails = Collections.synchronizedList(resultList);
        final CountDownLatch doInvokeStock = new CountDownLatch(taskNum);

        long begin = System.currentTimeMillis();

        for (int i = 0; i < taskNum; i++) {
            /**
             *  Variable 'i' is accessed from within inner class, needs to be final or effectively final
             *  finalI 在run方法中不会变化，是 effectively final
             */
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " task" + finalI + " running.");
                    try {
                        Thread.sleep(exeTime);
                    } catch (InterruptedException e) {
                        System.out.println("中断异常");
                    }
                    try {
                        /**
                         * 某个线程中出现的运行时异常，如果不做处理，不会返回给主线程。不影响其他线程执行。
                         */
                        if (finalI == exceptionNum) {
                            System.out.println("此时会出现异常！");
                        }
                        synchronizedStockDetails.add(String.valueOf(10 / (exceptionNum - finalI)));
                    } finally {
                        doInvokeStock.countDown();
                    }
                }
            });
        }


        try {
            System.out.println("线程调用已全部发起。耗时：" + (System.currentTimeMillis() - begin) + " ms");
            doInvokeStock.await();
            long end = System.currentTimeMillis();
            System.out.println("串行调用最低耗时：" + taskNum * exeTime + " ms，并发请求总耗时: " + (end - begin) + " ms ，并发节省时间：" + (taskNum * exeTime - (end - begin)) + " ms");
        } catch (InterruptedException e) {
            System.out.println("await出现异常：" + e.getMessage());
        }
        System.out.println("结果个数：" + resultList.size());
        System.out.println("结果集：" + JSON.toJSONString(resultList));
        executorService.shutdownNow();
    }
}

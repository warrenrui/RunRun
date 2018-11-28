package designPattern.future;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ExceptionFutureTask {
    public static void main(String[] args) {

        final int taskNum = 10;
        final long exeTime = 3000;
        final int exceptionNum = 3;
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        final ArrayList<String> resultList = new ArrayList<>();
        final ArrayList<Future> futureList = new ArrayList<>();
        long begin = System.currentTimeMillis();

        for (int i = 0; i < taskNum; i++) {
            int finalI = i;
            final Future<String> futureTask = executorService.submit(new Callable<String>() {
                @Override
                public String call() {
                    System.out.println(Thread.currentThread().getName() + " task" + finalI + " running.");
                    try {
                        Thread.sleep(exeTime);
                    } catch (InterruptedException e) {
                        System.out.println("中断异常");
                    }
                    if (finalI == exceptionNum) {
                        System.out.println("此时会出现异常！");
                    }
                    return String.valueOf(10 / (exceptionNum - finalI));
                }
            });
            futureList.add(futureTask);
        }

        System.out.println("线程调用已全部发起。耗时：" + (System.currentTimeMillis() - begin) + " ms");
        for (int i = 0; i < futureList.size(); i++) {
//            resultList.add(futureList.get(i).get().toString());
//            System.out.println("获取第 " + i + " 个结果。");
            try {
                resultList.add(futureList.get(i).get().toString());
                System.out.println("获取第 " + i + " 个结果。");
            } catch (InterruptedException | ExecutionException e) {
                /**
                 * 多个线程调用，某个线程出现异常后，不处理异常，会跳出循环。其他未执行完线程还会继续执行。
                 */
                System.out.println("获取第 " + i + " 个结果出现异常：" + e.getMessage());
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("串行调用最低耗时：" + taskNum * exeTime + " ms，并发请求总耗时: " + (end - begin) + " ms ，并发节省时间：" + (taskNum * exeTime - (end - begin)) + " ms");
        System.out.println("结果个数：" + resultList.size());
        System.out.println("结果集：" + JSON.toJSONString(resultList));
        executorService.shutdownNow();
    }
}

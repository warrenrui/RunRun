package designPattern.future;

import java.util.concurrent.*;

public class FutureTaskTest {

    public static void main(String[] args) {
        Callable<String> task = new Callable<String>() {
            public String call() {
                System.out.println(Thread.currentThread() + " Sleep start.");
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " Sleep end.");
                return "time=" + System.currentTimeMillis();
            }
        };

        // 直接使用Thread的方式执行
        FutureTask<String> ft = new FutureTask<>(task);
        Thread t = new Thread(ft);
        t.start();
        try {
            System.out.println(Thread.currentThread() + " waiting execute result");
            System.out.println(Thread.currentThread() + " result = " + ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 使用Executors来执行
        System.out.println(Thread.currentThread() + " =========");
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Future<?> future = executorService.submit(task);
        try {
            System.out.println(Thread.currentThread() + " waiting execute result");
            System.out.println(Thread.currentThread() + " result = " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }
}
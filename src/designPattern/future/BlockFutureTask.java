package designPattern.future;

import java.util.concurrent.*;

public class BlockFutureTask {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask<String> futureTask1 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    while (true) {
                        System.out.println(Thread.currentThread().getName() + "--task1 running.");
                        Thread.sleep(20000);
                    }
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "--Interrupted task1.");
                }
                return "end";
            }
        });
        executorService.submit(futureTask1);

//        new Thread(futureTask1).start();
//        try {
//            System.out.println(futureTask1.get(2, TimeUnit.SECONDS));
//            System.out.println(futureTask1.cancel(Boolean.TRUE));
//        } catch (InterruptedException | TimeoutException | ExecutionException e) {
//            e.printStackTrace();
//        }

        /**
         * 两个线程同时get一个 执行缓慢的task ，都被阻塞。加入到 {@link FutureTask#waiters} 中。
         * 第三个线程取消了任务执行，并停止了任务。
         * 前两个线程解除阻塞，抛出取消异常。
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("1");
                    System.out.println(Thread.currentThread().getName() + " 1 result:" + futureTask1.get());
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println(Thread.currentThread().getName() + " 中断异常 " + e.getMessage());
                    e.printStackTrace();
                } catch (CancellationException e) {
                    System.out.println(Thread.currentThread().getName() + " 取消异常 " + e.getMessage());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("2");
                    System.out.println(Thread.currentThread().getName() + " 2 result:" + futureTask1.get());
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println(Thread.currentThread().getName() + " 中断异常 " + e.getMessage());
                    e.printStackTrace();
                } catch (CancellationException e) {
                    System.out.println(Thread.currentThread().getName() + " 取消异常 " + e.getMessage());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("3");
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 3 result:" + futureTask1.cancel(Boolean.TRUE));
            }
        }).start();


//        try {
//            System.out.println(futureTask1.cancel(Boolean.TRUE));
//            System.out.println(futureTask1.isDone());
//            System.out.println(futureTask1.isCancelled());
//            System.out.println("task1 result:" + futureTask1.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        try {
            System.out.println("main 阻塞中");
            Thread.sleep(9999999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }
}

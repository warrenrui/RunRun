package concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchRun {

    public static void main(String[] args) {

        final CountDownLatch countDown = new CountDownLatch(2);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("发令枪响！go！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDown.countDown();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("倒计时 2 秒");
                    Thread.sleep(1000);
                    System.out.println("倒计时 1 秒，ready");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDown.countDown();
                }
            }
        });

        /**
         * 一个或多个线程执行完成后，等待的一个或多个线程同时开始。
         */
        final List<String> runner = Arrays.asList("博尔特", "罗伯斯", "刘易斯", "刘翔", "曹操", "杜跑跑", "兔宝宝", "美羊羊", "灰太狼", "猪猪");
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("运动员 " + runner.get(finalI) + " 就位，" + "等待发令枪");
                    try {
                        countDown.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(runner.get(finalI) + " 开溜！" + System.currentTimeMillis());
                }
            }, "t1").start();
        }

        t2.start();
        t3.start();

    }
}

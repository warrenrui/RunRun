package thread.syn.printAbcInOrder;

import java.util.concurrent.Semaphore;

/**
 * 按照顺序循环打印ABC。
 */
public class PrintAbcInOrderSemaphore {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final int times = 50000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    try {
                        semaphoreA.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--A");
                    semaphoreB.release();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    try {
                        semaphoreB.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "----B");
                    semaphoreC.release();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    try {
                        semaphoreC.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "------C");
                    semaphoreA.release();
                }
            }
        }).start();

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(System.currentTimeMillis() - startTime);
        // 4777,4447,4364
    }
}

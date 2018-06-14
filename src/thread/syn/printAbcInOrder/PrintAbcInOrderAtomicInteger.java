package thread.syn.printAbcInOrder;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 按照顺序循环打印ABC。循环太多，这种实现方式无意义。
 */
public class PrintAbcInOrderAtomicInteger {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final int times = 15;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    System.out.println("a times is " + i);
                    if ((count.get() % 3) == 0) {
                        System.out.println(Thread.currentThread().getName() + "--A");
                        count.getAndIncrement();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    System.out.println("b times is " + i);
                    if ((count.get() % 3) == 1) {
                        System.out.println(Thread.currentThread().getName() + "--B");
                        count.getAndIncrement();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    System.out.println("c times is " + i);
                    if ((count.get() % 3) == 2) {
                        System.out.println(Thread.currentThread().getName() + "--C");
                        count.getAndIncrement();
                    }
                }
            }
        }).start();

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(System.currentTimeMillis() - startTime);
        // 3274,3225,3050
    }
}

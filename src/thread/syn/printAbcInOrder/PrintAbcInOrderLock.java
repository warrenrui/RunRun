package thread.syn.printAbcInOrder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 按照顺序循环打印ABC。
 */
public class PrintAbcInOrderLock {
    static boolean isATurn = true;
    static boolean isBTurn = false;
    static boolean isCTurn = false;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        final int times = 50000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    lock.lock();
                    try {
                        while (!isATurn) {
                            condition.await();
                        }
                        System.out.println(Thread.currentThread().getName() + "--A");
                        isATurn = false;
                        isBTurn = true;
                        isCTurn = false;
                        condition.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    lock.lock();
                    try {
                        while (!isBTurn) {
                            condition.await();
                        }
                        System.out.println(Thread.currentThread().getName() + "----B");
                        isATurn = false;
                        isBTurn = false;
                        isCTurn = true;
                        condition.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    lock.lock();
                    try {
                        while (!isCTurn) {
                            condition.await();
                        }
                        System.out.println(Thread.currentThread().getName() + "------C");
                        isATurn = true;
                        isBTurn = false;
                        isCTurn = false;
                        condition.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
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

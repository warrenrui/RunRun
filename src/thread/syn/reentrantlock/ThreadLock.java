package thread.syn.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadLock {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // final Object lock = new Object();
        final ReentrantLock lock = new ReentrantLock();
        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        LockRunner1 lockRunner1 = new LockRunner1(lock);
        LockRunner2 lockRunner2 = new LockRunner2(lock);
        LockRunner3 lockRunner31 = new LockRunner3(lock);
        LockRunner3 lockRunner32 = new LockRunner3(lock);
        LockRunner4 lockRunner41 = new LockRunner4(readWriteLock);
        LockRunner4 lockRunner42 = new LockRunner4(readWriteLock);

        // lockRunner1.start();
        // lockRunner2.start();
        lockRunner31.start();
        lockRunner32.start();
        // lockRunner5.start();
        // lockRunner6.start();

        // ------- 测试可中断-----
        try {
            System.out.println(Thread.currentThread().getName() + " starts to wait-------等待 x 秒如果获取不到，中断锁-----");
            Thread.sleep(4999);
        } catch (InterruptedException e) {
            System.out.println("中断异常");
            e.printStackTrace();
        }
        lockRunner32.interrupt();
        // ------------------------
    }
}

class LockRunner3 extends Thread {
    private ReentrantLock lock;

    LockRunner3(ReentrantLock lock) {
        this.lock = lock;
    }

    public void run() {

        // tryLockFuc();

        try {
            lockInterruptiblyFuc();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + "---被中断，不等了");
        }
    }

    /**
     * 测试：lockInterruptibly()方法比较特殊，当通过这个方法去获取锁时，如果线程正在等待获取锁，则这个线程能够响应中断， 即中断线程的等待状态。
     * 也就使说，当两个线程同时通过lock.lockInterruptibly()想获取某个锁时，假若此时线程A获取到了锁，而线程B只有在等待， 那么对线程B调用threadB.interrupt()方法能够中断线程B的等待过程。
     *
     * @throws InterruptedException
     */
    public void lockInterruptiblyFuc() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "---等待获取锁");
        lock.lockInterruptibly();
        try {
            System.out.println(Thread.currentThread().getName() + "---得到了锁，执行五秒");
            sleep(5000);
        } finally {
            System.out.println(Thread.currentThread().getName() + "---执行完毕，释放锁");
            lock.unlock();
        }
    }

    /**
     * 测试：tryLock()方法是有返回值的，它表示用来尝试获取锁，如果获取成功，则返回true， 如果获取失败（即锁已被其他线程获取），则返回false，也就说这个方法无论如何都会立即返回。在拿不到锁时不会一直在那等待。
     */
    public void tryLockFuc() {
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + "---得到了锁");
            } finally {
                System.out.println(Thread.currentThread().getName() + "---释放锁");
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "---获取锁失败");
        }
    }
}

class LockRunner4 extends Thread {
    private ReentrantReadWriteLock lock;

    LockRunner4(ReentrantReadWriteLock lock) {
        this.lock = lock;
    }

    /**
     * 将文件的读写操作分开，分成2个锁来分配给线程，从而使得多个线程可以同时进行读操作
     */
    public void run() {
        lock.readLock().lock();
        try {
            long startDate = System.currentTimeMillis();
            while (System.currentTimeMillis() - startDate <= 1) {
                System.out.println(Thread.currentThread().getName() + "---正在读取操作");
            }
            System.out.println(Thread.currentThread().getName() + "---读取操作完毕");
        } finally {
            lock.readLock().unlock();
        }
    }
}

class LockRunner1 extends Thread {
    private ReentrantLock lock;

    LockRunner1(ReentrantLock lock) {
        this.lock = lock;
    }

    public void run() {
        long startDate = System.currentTimeMillis();
        for (int i = 1; i <= 52; i++) {
            try {
                lock.lock();
                System.out.println("LockRunner1 ----- " + i++);
                System.out.println("LockRunner1 ----- " + i);
            } finally {
                lock.unlock();
                try {
                    sleep(90);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long endDate = System.currentTimeMillis();
        System.out.println("runner1 用时：" + (endDate - startDate));
    }
}

class LockRunner2 extends Thread {
    private ReentrantLock lock;

    LockRunner2(ReentrantLock lock) {
        this.lock = lock;
    }

    public void run() {
        long startDate = System.currentTimeMillis();
        for (int i = 65; i <= 90; i++) {
            try {
                lock.lock();
                // lock.lockInterruptibly();
                System.out.println("LockRunner2 ----- " + (char) i);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                try {
                    sleep(90);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long endDate = System.currentTimeMillis();
        System.out.println("runner2 用时：" + (endDate - startDate));
    }
}

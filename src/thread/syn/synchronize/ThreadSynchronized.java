package thread.syn.synchronize;

/**
 * 两个线程按顺序轮流执行
 */
public class ThreadSynchronized {
    public static void main(String[] args) {
        final Object lock = new Object();
        Runner1 runner1 = new Runner1(lock);
        // Runner1 runner2 = new Runner1(lock);
        Runner2 runner2 = new Runner2(lock);

        runner1.start();
        runner2.start();
    }
}

class Runner1 extends Thread {
    private Object lock;

    Runner1(Object lock) {
        this.lock = lock;
    }

    public void run() {
        long startDate = System.currentTimeMillis();
        synchronized (lock) {
            for (int i = 1; i <= 52; i++) {
                /*
                 * notify():
                 * 该方法会唤醒因为调用对象的wait()而等待的线程，其实就是对对象锁的唤醒，从而使得wait()的线程可以有机会获取对象锁
                 * 。
                 * 调用notify()后，并不会立即释放锁，而是继续执行当前代码，直到synchronized中的代码全部执行完毕，才会释放对象锁
                 * 。JVM则会在等待的线程中调度一个线程去获得对象锁，执行代码。需要注意的是，wait()和notify()
                 * 必须在synchronized代码块中调用。
                 */
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Runner1 ----- " + i++);
                System.out.println("Runner1 ----- " + i);
                System.out.println("=============1");
            }
            lock.notifyAll();
            long endDate = System.currentTimeMillis();
            System.out.println("runner1 用时：" + (endDate - startDate));
        }
    }
}

class Runner2 extends Thread {
    private Object lock;

    Runner2(Object lock) {
        this.lock = lock;
    }

    public void run() {
        long startDate = System.currentTimeMillis();
        synchronized (lock) {
            for (int i = 65; i <= 90; i++) {
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Runner2 ----- " + (char) i);
                System.out.println("=============2==============");
            }
            lock.notifyAll();
            long endDate = System.currentTimeMillis();
            System.out.println("runner2 用时：" + (endDate - startDate));
        }
    }
}

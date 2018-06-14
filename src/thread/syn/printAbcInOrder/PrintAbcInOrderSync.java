package thread.syn.printAbcInOrder;

/**
 * 按照顺序循环打印ABC。
 */
public class PrintAbcInOrderSync {
    static boolean isATurn = true;
    static boolean isBTurn = false;
    static boolean isCTurn = false;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final Object lock = new Object();
        final int times = 50000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    synchronized (lock) {
                        while (!isATurn) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + "--A");
                        isATurn = false;
                        isBTurn = true;
                        isCTurn = false;
                        lock.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    synchronized (lock) {
                        while (!isBTurn) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + "----B");
                        isATurn = false;
                        isBTurn = false;
                        isCTurn = true;
                        lock.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    synchronized (lock) {
                        while (!isCTurn) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + "-------C");
                        isATurn = true;
                        isBTurn = false;
                        isCTurn = false;
                        lock.notifyAll();
                    }
                }
            }
        }).start();

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(System.currentTimeMillis() - startTime);
        //3401,3345,3454
    }
}

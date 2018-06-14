package thread.syn.synchronize;

public class ThreadDeadLock implements Runnable {
    public int flag = 1;
    static Object o1 = new Object(), o2 = new Object();

    public void run() {
        System.out.println("flag= " + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDeadLock threadDeadLock1 = new ThreadDeadLock();
        ThreadDeadLock threadDeadLock2 = new ThreadDeadLock();
        threadDeadLock1.flag = 1;
        threadDeadLock2.flag = 0;
        Thread thread1 = new Thread(threadDeadLock1);
        Thread thread2 = new Thread(threadDeadLock2);
        thread1.start();
        thread2.start();
    }
}

package thread.syn.synchronize;

public class ThreadSynchronism implements Runnable {
    Timer timer = new Timer();

    public void run() {
        timer.add(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadSynchronism threadSynchronism = new ThreadSynchronism();
        Thread thread1 = new Thread(threadSynchronism);
        Thread thread2 = new Thread(threadSynchronism);
        thread1.setName("t1");
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }
}

class Timer {
    private static int num = 0;

    public synchronized void add(String name) {
        num++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + ",你是第" + num + "个使用timer的线程");
    }
}
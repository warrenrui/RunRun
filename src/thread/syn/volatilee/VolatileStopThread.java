package thread.syn.volatilee;

public class VolatileStopThread extends Thread {
    private static volatile boolean stop = false;

    public void stopMe() {
        stop = true;
    }

    public void run() {
        int i = 0;
        System.out.println("当前线程——" + this.currentThread().toString());
        // 使用该变量的时候，
        while (!stop) {
            i++;
            System.out.println("stop = " + stop + "，i = " + i);
        }
        System.out.println("Stop thread");
    }

    public static void main(String args[]) throws InterruptedException {
        VolatileStopThread t = new VolatileStopThread();
        VolatileStopThread t2 = new VolatileStopThread();
        t.start();
        Thread.sleep(100);
        t2.stopMe();
        Thread.sleep(100);
    }
}

package thread.syn.synchronize;

import java.util.Date;


public class ThreadInterrupt {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.interrupt();
    }
}

class MyThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("====" + new Date(System.currentTimeMillis()) + "====");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
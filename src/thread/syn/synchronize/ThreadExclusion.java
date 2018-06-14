package thread.syn.synchronize;

public class ThreadExclusion implements Runnable {
    int b = 99;

    public void run() {
        try {
//			m1();
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void m1() throws Exception {
        b = 1000;
//		Thread.sleep(5000);
        System.out.println("m1-----  b = " + b);
    }

    public synchronized void m2() throws Exception {
        b = 2000;
        Thread.sleep(5000);

        System.out.println("m2------ b = " + b);
    }

    public static void main(String[] args) {
        ThreadExclusion threadExclusion = new ThreadExclusion();
        Thread thread = new Thread(threadExclusion);
        thread.start();
//		System.out.println("2");
//		threadExclusion.run();
//		System.out.println("3");

        try {
//			threadExclusion.m1();
            threadExclusion.m2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("main-----" + threadExclusion.b);

    }
}

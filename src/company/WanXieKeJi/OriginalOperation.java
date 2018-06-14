package company.WanXieKeJi;

public class OriginalOperation {
    public static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        Thread t0 = new Thread(mt);
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);
        Thread t4 = new Thread(mt);
        Thread t5 = new Thread(mt);
        Thread t6 = new Thread(mt);
        Thread t7 = new Thread(mt);
        Thread t8 = new Thread(mt);
        Thread t9 = new Thread(mt);
        Thread t10 = new Thread(mt);
        Thread t11 = new Thread(mt);
        Thread t12 = new Thread(mt);
        Thread t13 = new Thread(mt);
        Thread t14 = new Thread(mt);
        Thread t15 = new Thread(mt);
        Thread t16 = new Thread(mt);
        Thread t17 = new Thread(mt);
        Thread t18 = new Thread(mt);
        Thread t19 = new Thread(mt);
        Thread t20 = new Thread(mt);
//		t0.start();
//		t0.sleep(100000);
        // t1.start();
        // t2.start();
        // t3.start();
        // t4.start();
        // t5.start();
        // t6.start();
        // t7.start();
        // t8.start();
        // t9.start();
        // t10.start();
        // t11.start();
        // t12.start();
        // t13.start();
        // t14.start();
        // t15.start();
        // t16.start();
        // t17.start();
        // t18.start();
        // t19.start();
        // t20.start();

    }
}

class MyThread implements Runnable {

    public void run() {
        while (true) {
            // synchronized(this){
            System.out.println(OriginalOperation.i++);

            // }
        }
    }
}

package thread.syn.synchronize;

/**
 * static的方法属于类方法，它属于这个Class（注意：这里的Class不是指Class的某个具体对象），那么static获取到的锁，是属于类的锁。
 * 而非static方法获取到的锁，是属于当前对象的锁。所以，他们之间不会产生互斥。
 */
public class FuctionStaticOrNot {
    public synchronized void notStatic() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "---  notStatic  running");
        }
    }

    public static synchronized void staticc() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "---  static  running");
        }
    }

    public static void main(String[] args) {
        // Immutable

        final FuctionStaticOrNot staticOrNot = new FuctionStaticOrNot();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("1");
                    staticc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("2");
                    staticc();
                    // staticOrNot.notStatic();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}

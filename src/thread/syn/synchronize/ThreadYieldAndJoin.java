package thread.syn.synchronize;

public class ThreadYieldAndJoin {
    public static void main(String[] args) {
        MyThread1 myThread2 = new MyThread1("mt2");
        MyThread1 myThread3 = new MyThread1("mt3-------");
        MyThread1 myThread4 = new MyThread1("mt4");
        myThread3.setPriority(Thread.MAX_PRIORITY);
        myThread4.setPriority(Thread.MIN_PRIORITY);
        myThread2.start();
        try {
            // 子线程调用了join()方法，后面的代码，只有等到子线程结束了才能执行
            // 执行中虽然调用了yield，但是join的作用依然有效。
            myThread2.join();
            System.out.println("子线程执行完毕之后，才打印出   join");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 没有使用join的其他线程，执行之间有交叉
        myThread3.start();
        // 线程3设置了最高优先级10，而且先启动，其他线程被阻塞，使用yield后，
        // 线程3从执行状态变成就绪状态，线程3、线程4、主线程重新竞争获取CPU资源。
        // 线程3虽然优先级最高，但是也不一定就能稳定的获取资源
        Thread.yield();
        myThread4.start();
        System.out.println("主线程已执行完毕，也可能在其他线程之后执行--------" + Thread.currentThread().getName() + "====" + Thread.currentThread().isAlive());
    }
}

class MyThread1 extends Thread {
    MyThread1(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "---线程开始执行-------------------" + Thread.currentThread().isAlive());
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ":" + i);
            //			yield();
            if (i % 10 == 0) {
                yield();
            }
        }
    }
}
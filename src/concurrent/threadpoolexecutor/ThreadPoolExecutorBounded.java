package concurrent.threadpoolexecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorBounded {

    public static void main(String[] args) {
        /**
         * 在使用有界队列时，若有新的任务需要执行，如果线程池实际线程数小于corePoolSize，则优先创建线程，
         * 若大于corePoolSize，则会将任务加入队列， 若队列已满，则在总线程数不大于maximumPoolSize的前提下，创建新的线程，
         * 若线程数大于maximumPoolSize，则执行拒绝策略。或其他自定义方式。
         *
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, // coreSize
                2, // MaxSize
                60, // 60
                // 指定一种队列 （有界队列）
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3)
                // new LinkedBlockingQueue<Runnable>()
                , new MyRejected()
                // , new DiscardOldestPolicy()
        );

        MyTask mt1 = new MyTask(1, "任务1");
        MyTask mt2 = new MyTask(2, "任务2");
        MyTask mt3 = new MyTask(3, "任务3");
        MyTask mt4 = new MyTask(4, "任务4");
        MyTask mt5 = new MyTask(5, "任务5");
        MyTask mt6 = new MyTask(6, "任务6");
        MyTask mt7 = new MyTask(7, "任务7");
        MyTask mt8 = new MyTask(8, "任务8");

        pool.execute(mt1);
        pool.execute(mt2);
        pool.execute(mt3);
        pool.execute(mt4);
        pool.execute(mt5);
        // 阻塞主程序，等待已进入等待队列和正在执行的执行完才关闭。如果超时时间内还没有进入到等待队列中，直接拒绝执行。
        // try {
        // System.out.println(pool.awaitTermination(2, TimeUnit.SECONDS));
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        pool.execute(mt6);
        // pool.shutdownNow();
        pool.execute(mt7);
        pool.execute(mt8);

        System.out.println(Thread.currentThread().getName() + " is over!");
        //
        pool.shutdown();
    }
}

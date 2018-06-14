package concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsEg {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Temp command = new Temp();

        int nThreads = 1;
        // 固定线程数，
        // new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
        // new LinkedBlockingQueue<Runnable>());
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(nThreads);
        newFixedThreadPool.execute(command);

        // new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
        // new SynchronousQueue<Runnable>());
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        newCachedThreadPool.execute(command);

        // new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new
        // LinkedBlockingQueue<Runnable>());
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(command);

        int corePoolSize = 1;
        // new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE, 0,
        // NANOSECONDS, new DelayedWorkQueue());
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(corePoolSize);
        newScheduledThreadPool.scheduleWithFixedDelay(new Temp(), 2, 2, TimeUnit.SECONDS);
    }
}

class Temp extends Thread {
    public void run() {
        System.out.println(new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()) + "-------run-------" + Thread.currentThread().getName());
    }
}

package shortcut.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * 线程池工具类
 * 保证全局使用一个相同的线程池，方便控制线程的创建和销毁
 */
public class ThreadPoolUtil {

    @SuppressWarnings("ConstantConditions")
    private static final ExecutorService INVOKE_STOCK_THREAD_POOL = new ThreadPoolExecutor(
            10,
            100,
            30L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(10000));

    public static void submit(Runnable runnable) {
        INVOKE_STOCK_THREAD_POOL.submit(runnable);
    }

}
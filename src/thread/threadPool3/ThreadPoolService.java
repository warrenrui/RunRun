package thread.threadPool3;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolService {
    private static ThreadPoolService instance = null;

    public static synchronized ThreadPoolService getInstance() {
        if (instance == null) {
            instance = new ThreadPoolService();
        }
        return instance;
    }

    // 初始化线程池
    public ThreadPoolService() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread t = new TaskThread(this);
            pool.add(t);
        }
    }

    // 线程数
    public static final int THREAD_COUNT = 5;
    private List<Thread> pool = new ArrayList<Thread>();

    public enum Status {
        NEW, RUNNING, TERMINATED,
    }

    // 线程池状态
    private Status status = Status.NEW;
    private TaskQueue queue = new TaskQueue();

    // 启动服务
    public void start() {
        this.status = Status.RUNNING;
        for (int i = 0; i < pool.size(); i++) {
            pool.get(i).start();
        }
    }

    // 停止服务
    public void stop() {
        this.status = Status.TERMINATED;
    }

    // 是否正在运行
    public boolean isRunning() {
        return status == Status.RUNNING;
    }

    // 执行任务
    public void runTask(Task task) {
        queue.addTask(task);
    }

    protected TaskQueue getTaskQueue() {
        return queue;
    }
}

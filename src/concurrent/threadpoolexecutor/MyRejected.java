package concurrent.threadpoolexecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler {

    public MyRejected() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(Thread.currentThread().getName() + "-----自定义拒绝处理，当前被拒绝任务为：" + r.toString());

    }

}

package thread.threadPool3;

public class SimpleTaskTest extends Task {
    @Override
    public void deal() {
        System.out.println("doing sth");
        // do something
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolService service = ThreadPoolService.getInstance();
        service.start();
        // 执行十次任务
        for (int i = 0; i < 100; i++) {
            service.runTask(new SimpleTaskTest());
        }
        // 睡眠1秒钟，等待所有任务执行完毕
        Thread.sleep(1000);
        service.stop();
    }
}

package concurrent.threadpoolexecutor;

public class MyTask implements Runnable {

    private int taskId;
    private String taskName;

    public MyTask(int taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "--run taskId =" + this.taskId + "---execute 5 seconds");
            Thread.sleep(5 * 1000);
            // System.out.println("end taskId =" + this.taskId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return Integer.toString(this.taskId);
    }

}

package company.ZhongKeDaYang;

public class RunningOrWait implements Runnable {

    public void run() {
        System.out.println("running a ");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new RunningOrWait());
        t.run();
        t.run();
        t.start();
    }
}

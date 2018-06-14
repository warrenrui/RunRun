package company.ZhongKeDaYang;

public class OutputSth {
    public static void main(String[] args) {
        Atest a = new Atest();
        new Thread(a).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int j = a.i;
        System.out.println("j = " + j);
    }
}

class Atest implements Runnable {
    public int i = 1;

    public void run() {
        System.out.println("do");
        this.i = 10;
        System.out.println("i = " + i);
        System.out.println("done");
    }
}

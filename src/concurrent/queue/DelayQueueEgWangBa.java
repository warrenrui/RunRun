package concurrent.queue;

import java.util.concurrent.DelayQueue;

public class DelayQueueEgWangBa implements Runnable {

    private DelayQueue<DelayedWangmin> delayQueue = new DelayQueue<DelayedWangmin>();

    public boolean open = true;

    public void shangji(String name, String id, int money) {
        DelayedWangmin man = new DelayedWangmin(name, id, 1000 * money + System.currentTimeMillis());
        System.out.println("网名" + man.getName() + " 身份证" + man.getId() + "交钱" + money + "块,开始上机...");
        this.delayQueue.add(man);
    }

    public void xiaji(DelayedWangmin man) {
        System.out.println("网名" + man.getName() + " 身份证" + man.getId() + "时间到下机...");
    }

    @Override
    public void run() {
        while (open) {
            try {
                DelayedWangmin man = delayQueue.take();
                xiaji(man);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        try {
            System.out.println("网吧开始营业");
            DelayQueueEgWangBa eBar = new DelayQueueEgWangBa();
            Thread shangwang = new Thread(eBar);
            shangwang.start();

            eBar.shangji("路人甲", "123", 1);
            eBar.shangji("路人乙", "234", 10);
            eBar.shangji("路人丙", "345", 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
package thread.producerConsumer;

/**
 * Java线程：并发协作-生产者消费者模型
 * <p>
 * 对于多线程程序来说，不管任何编程语言，生产者和消费者模型都是最经典的。就像学习每一门编程语言一样，Hello World！都是最经典的例子。
 * <p>
 * 实际上，准确说应该是“生产者-消费者-仓储”模型，离开了仓储，生产者消费者模型就显得没有说服力了。 对于此模型，应该明确一下几点：
 * 1、生产者仅仅在仓储未满时候生产，仓满则停止生产。 2、消费者仅仅在仓储有产品时候才能消费，仓空则等待。
 * 3、当消费者发现仓储没产品可消费时候会通知生产者生产。 4、生产者在生产出可消费产品时候，应该通知等待的消费者去消费。
 * <p>
 * 此模型将要结合java.lang.Object的wait与notify、notifyAll方法来实现以上的需求。这是非常重要的。
 */

public class ProducerConsumerModel {
    public static void main(String[] args) {
        Godown godown = new Godown(1);
        ConsumerModel c1 = new ConsumerModel("1", 1, godown);
        ConsumerModel c2 = new ConsumerModel("2", 2, godown);
        ConsumerModel c3 = new ConsumerModel("3", 3, godown);
        ProducerModel p1 = new ProducerModel("1", 1, godown);
        ProducerModel p2 = new ProducerModel("2", 1, godown);
        ProducerModel p3 = new ProducerModel("3", 1, godown);

        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
    }
}

/**
 * 仓库
 */
class Godown {
    public static final int max_size = 100; // 最大库存量
    public int curnum; // 当前库存量
    public int holdNum;// 保持库存保有量

    Godown() {
    }

    Godown(int holdNum) {
        this.holdNum = holdNum;
    }

    /**
     * 生产指定数量的产品
     *
     * @param producerId
     * @param neednum
     */
    public synchronized void produce(String producerId, int neednum) {
        // 测试是否需要生产
        while (neednum + curnum > max_size) {
            System.out.println(System.currentTimeMillis() + "   生产者   <" + producerId + ">   要生产的产品数量   " + neednum + "   超过剩余库容量   " + (max_size - curnum) + "   ，暂时不能执行生产任务!");
            try {
                // 当前的生产线程等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 满足生产条件，则进行生产，这里简单的更改当前库存量
        curnum += neednum;
        System.out.println(System.currentTimeMillis() + "   生产者   <" + producerId + ">   已经生产了   " + neednum + "   个产品，现仓储量为   " + curnum);
        // 唤醒在此对象监视器上等待的所有线程
        // notifyAll();
        notify();
    }

    /**
     * 消费指定数量的产品
     *
     * @param consumerId
     * @param neednum
     */
    public synchronized void consume(String consumerId, int neednum) {
        // 测试是否可消费
        while (curnum < neednum) {
            System.out.println(System.currentTimeMillis() + "   消费者   " + consumerId + "   需要消费   " + neednum + "   个产品，现仓储量只有   " + curnum);
            try {
                // 当前的生产线程等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 满足消费条件，则进行消费，这里简单的更改当前库存量
        curnum -= neednum;
        System.out.println(System.currentTimeMillis() + "   消费者   " + consumerId + "   已经消费了   " + neednum + "   个产品，现仓储量为   " + curnum);
        // 唤醒在此对象监视器上等待的所有线程
        // notifyAll();
        notify();
    }
}

/**
 * 生产者
 */
class ProducerModel extends Thread {
    private int neednum; // 生产产品的数量
    private Godown godown; // 仓库
    private String producerId;

    ProducerModel(String producerId, int neednum, Godown godown) {
        this.producerId = producerId;
        this.neednum = neednum;
        this.godown = godown;
    }

    @Override
    public void run() {
        // 生产指定数量的产品
        try {
            while (true) {
                if (godown.curnum <= godown.holdNum) {
                    godown.produce(producerId, neednum);
                    sleep(1000);
                } else {
                    sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者
 */
class ConsumerModel extends Thread {
    private int neednum; // 生产产品的数量
    private Godown godown; // 仓库
    private String consumerId;

    ConsumerModel(String consumerId, int neednum, Godown godown) {
        this.consumerId = consumerId;
        this.neednum = neednum;
        this.godown = godown;
    }

    @Override
    public void run() {
        // 消费指定数量的产品
        try {
            while (true) {
                if (godown.curnum > godown.holdNum) {
                    godown.consume(consumerId, neednum);
                    sleep(1000);
                } else {
                    sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

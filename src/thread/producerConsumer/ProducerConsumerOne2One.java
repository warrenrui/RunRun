package thread.producerConsumer;

public class ProducerConsumerOne2One {
    public static void main(String[] args) {
        SyncStack syncStack = new SyncStack();
        Producer producer = new Producer(syncStack);
        Consumer consumer = new Consumer(syncStack);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Wotou {
    int id;

    public Wotou(int id) {
        this.id = id;
    }

    public String toString() {
        return "Wotou: " + id;
    }
}

class SyncStack {
    int index = 0;
    Wotou[] arrWotou = new Wotou[6];

    public synchronized void push(Wotou wt) {
        while (index == arrWotou.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        arrWotou[index] = wt;
        index++;
    }

    public synchronized Wotou pop() {
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // this.notify();
        index--;
        return arrWotou[index];
    }
}

class Producer implements Runnable {
    SyncStack ss = null;

    Producer(SyncStack ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            Wotou wt = new Wotou(i);
            ss.push(wt);
            System.out.println("生产了----" + wt);
            try {
                Thread.sleep((long) Math.random() * 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    SyncStack ss = null;

    public Consumer(SyncStack ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            Wotou wt = ss.pop();
            System.out.println("消费了==" + wt);
            try {
                System.out.println("休息一下");
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

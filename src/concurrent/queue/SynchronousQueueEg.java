package concurrent.queue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueEg {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // 队列中没有数据，则取队列操作阻塞。放入队列时候，需要先有个取队列的操作，否则报错"Queue full"
        final SynchronousQueue<String> q = new SynchronousQueue<String>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 3; i++) {
                        System.out.println(Thread.currentThread().getName() + " --1- " + q.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    for (int i = 0; i < 3; i++) {
                        System.out.println(Thread.currentThread().getName() + " add to SynchronousQueue");
//						q.put("asdasd " + i);
                        q.add("asdasd " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }
}

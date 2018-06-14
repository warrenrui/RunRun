package thread.producerConsumer;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 最简单的生产者-消费者模式
 *
 * @author Administrator
 */
public class ProducerConsumerLock {
    final private int queueSize = 10;
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        ProducerConsumerLock test = new ProducerConsumerLock();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();
        producer.start();
        consumer.start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        System.out.println("队列已满，等待有空余空间");
                        notFull.await();
                    }
                    queue.offer(1);
                    notEmpty.signal();
                    System.out.println("向队列中插入一个元素，剩余空间：" + (queueSize - queue.size()));
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("队列空，等待数据");
                        notEmpty.await();
                    }
                    queue.poll();
                    notFull.signal();
                    System.out.println("从队列中取走一个元素，队列剩余元素：" + queue.size());
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    lock.unlock();
                }
            }
        }

    }

}

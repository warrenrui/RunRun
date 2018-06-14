package concurrent.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantReadWriteLockEg {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static WriteLock writeLock = lock.writeLock();
    private static ReadLock readLock = lock.readLock();
    private static Map<String, String> maps = new HashMap<String, String>();
    private static CountDownLatch latch = new CountDownLatch(102);
    private static CyclicBarrier barrier = new CyclicBarrier(102);

    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            new Thread(new WriteThread()).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(new ReadThread()).start();
        }
        latch.await();
        // 等待所有累加线程都结束
        // while (Thread.activeCount() > 1)
        // Thread.yield();
        System.out.println("用时：" + (System.currentTimeMillis() - beginTime) + "ms");
    }

    static class WriteThread implements Runnable {

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            writeLock.lock();
            try {
                maps.put("1", Thread.currentThread().getName());
                System.out.println("threadName  ----" + Thread.currentThread().getName());
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
            latch.countDown();
        }
    }

    static class ReadThread implements Runnable {

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            readLock.lock();
            try {
                System.out.println("threadName  ----" + maps.get("1"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
            latch.countDown();
        }

    }
}

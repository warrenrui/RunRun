package concurrent.queue;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueEg {
    public static void main(String[] args) {
        try {
            final ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(4);
            arrayBlockingQueue.add("c");
            arrayBlockingQueue.add("d");
            arrayBlockingQueue.take();
            arrayBlockingQueue.put("a");
            arrayBlockingQueue.put("a1");
            arrayBlockingQueue.put("a2");// 已满会阻塞

            System.out.println("------iterator----数组中元素取出后，会循环使用数组位置---");
            for (Iterator iterator = arrayBlockingQueue.iterator(); iterator.hasNext(); ) {
                String string = (String) iterator.next();
                System.out.println(string);
            }

            arrayBlockingQueue.add("e");// 调用offer，已满不阻塞，抛出异常
            arrayBlockingQueue.offer("b");// 已满不阻塞，返回false

            System.out.println(Thread.currentThread().getName() + "----1");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "----2");
                        Thread.sleep(4000);
                        System.out.println("3秒后从队列中取数据，使后面的offer成功----" + arrayBlockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            // 已满倒计时等待，到期后还是已满，返回false
            System.out.println("offer " + arrayBlockingQueue.offer("a", 3, TimeUnit.SECONDS));
            // array.add("f");
            System.out.println("------iterator-------");
            for (Iterator iterator = arrayBlockingQueue.iterator(); iterator.hasNext(); ) {
                String string = (String) iterator.next();
                System.out.println(string);
            }
            System.out.println("------peek----------");
            for (int i = 0, j = arrayBlockingQueue.size(); i < j; i++) {
                System.out.println("element :" + arrayBlockingQueue.peek());
            }
            System.out.println("------take----------");// 如果队列空了，一直阻塞，直到数组不为空或者线程被中断-->阻塞
            for (int i = 0, j = arrayBlockingQueue.size(); i < j; i++) {
                System.out.println("element :" + arrayBlockingQueue.take());
            }
            System.out.println("------poll----------");// 如果没有元素，直接返回null；如果有元素，出队
            System.out.println("element poll :" + arrayBlockingQueue.poll());
            for (int i = 0, j = arrayBlockingQueue.size(); i < j; i++) {
                System.out.println("element :" + arrayBlockingQueue.poll());
            }
            System.out.println("------poll,wait----------");
            // 如果数组不空，出队；如果数组已空且已经超时，返回null；如果数组已空且时间未超时，则进入等待，直到出现以下三种情况：
            // 被唤醒
            // 等待时间超时
            // 当前线程被中断
            System.out.println("element poll,wait :" + arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
            for (int i = 0, j = arrayBlockingQueue.size(); i < j; i++) {
                System.out.println("element :" + arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

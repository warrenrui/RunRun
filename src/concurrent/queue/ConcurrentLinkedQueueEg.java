package concurrent.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueEg {
    public static void main(String[] args) {
        // 高性能无阻塞无界队列：ConcurrentLinkedQueue
        ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
        q.offer("a");
        q.offer("b");
        q.offer("c");
        q.offer("d");
        q.add("e");// 调用offer

        System.out.println(q.poll()); // a 从头部取出元素，并从队列里删除
        System.out.println(q.size()); // 4
        System.out.println(q.peek()); // b
        System.out.println(q.size()); // 4
    }
}

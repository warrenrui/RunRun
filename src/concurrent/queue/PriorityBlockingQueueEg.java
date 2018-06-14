package concurrent.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 通过二叉小顶堆实现，可以用一棵完全二叉树表示 http://www.cnblogs.com/CarpenterLee/p/5488070.html
 */
public class PriorityBlockingQueueEg {

    public static void main(String[] args) throws Exception {

        PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<Task>();

        Task t1 = new Task();
        t1.setId(3);
        t1.setName("id为3");
        Task t2 = new Task();
        t2.setId(4);
        t2.setName("id为4");
        Task t3 = new Task();
        t3.setId(1);
        t3.setName("id为1");

        // return this.id > task.id ? 1 : 0;
        q.add(t1); // 3
        q.add(t2); // 4
        q.add(t3); // 1

        // 1 3 4
        System.out.println("容器：" + q);
        System.out.println(q.take().getId());
        System.out.println("容器：" + q);
        // System.out.println(q.take().getId());
        // System.out.println(q.take().getId());

    }
}

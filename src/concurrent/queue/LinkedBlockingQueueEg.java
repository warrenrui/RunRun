package concurrent.queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueEg {

    public static void main(String[] args) throws Exception {

        // 阻塞队列。如果指定容量，则为有界队列
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>(5);
        // LinkedBlockingQueue<String> linkedBlockingQueue = new
        // LinkedBlockingQueue<String>();
//		linkedBlockingQueue.take();
        System.out.println(linkedBlockingQueue.offer("a"));
        System.out.println(linkedBlockingQueue.offer("b"));
        System.out.println(linkedBlockingQueue.offer("c"));
        System.out.println(linkedBlockingQueue.offer("d"));
        System.out.println(linkedBlockingQueue.offer("e"));
        linkedBlockingQueue.put("e1");
        System.out.println(linkedBlockingQueue.add("f"));
        System.out.println(linkedBlockingQueue.size());

        for (Iterator iterator = linkedBlockingQueue.iterator(); iterator.hasNext(); ) {
            String string = (String) iterator.next();
            System.out.println(string);
        }

        List<String> list = new ArrayList<String>();
        System.out.println(linkedBlockingQueue.drainTo(list, 3));
        System.out.println(list.size());
        for (String string : list) {
            System.out.println(string);
        }
    }
}

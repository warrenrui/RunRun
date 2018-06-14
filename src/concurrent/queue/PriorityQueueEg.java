package concurrent.queue;

import java.util.Iterator;

/**
 * 通过二叉小顶堆实现，可以用一棵完全二叉树表示 http://www.cnblogs.com/CarpenterLee/p/5488070.html
 */
public class PriorityQueueEg {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        java.util.PriorityQueue<String> priorityQueue = new java.util.PriorityQueue<String>(4);
        // 默认的优先级，什么规则？ output: 1,2,5,4,3
        priorityQueue.add("1");
        priorityQueue.add("4");
        priorityQueue.add("5");
        priorityQueue.add("2");
        priorityQueue.offer("3");
        // priorityQueue.add(null);//元素不能为空
        for (Iterator iterator = priorityQueue.iterator(); iterator.hasNext(); ) {
            System.out.println((String) iterator.next());
        }
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.element());

        priorityQueue.remove("2");
        priorityQueue.poll();
        priorityQueue.clear();
        System.out.println("---------------");

        java.util.PriorityQueue<Integer> priorityQueue2 = new java.util.PriorityQueue<Integer>();
        priorityQueue2.offer(4);
        priorityQueue2.offer(3);
        priorityQueue2.offer(2);
        priorityQueue2.offer(5);
        priorityQueue2.offer(1);
        System.out.println();
        System.out.println("-------乱序插入，迭代器逐行输出小顶堆结构");
        for (Iterator iterator = priorityQueue2.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + ",");
        }
        System.out.println();
        System.out.println("-------乱序插入，poll 每次输出堆顶数据，调整小顶堆");
        for (int i = 0, size = priorityQueue2.size(); i < size; i++) {
            System.out.print(priorityQueue2.poll() + ",");
        }
        priorityQueue2.clear();
        System.out.println();
        priorityQueue2.offer(5);
        priorityQueue2.offer(4);
        priorityQueue2.offer(3);
        priorityQueue2.offer(2);
        priorityQueue2.offer(1);
        System.out.println("-------逆序插入，迭代器逐行输出小顶堆结构");
        for (Iterator iterator = priorityQueue2.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + ",");
        }
        System.out.println();
        System.out.println("-------逆序插入，poll 每次输出堆顶数据，调整小顶堆");
        for (int i = 0, size = priorityQueue2.size(); i < size; i++) {
            System.out.print(priorityQueue2.poll() + ",");
        }
        System.out.println();
        System.out.println("-------顺序插入，同样的数据，插入顺序不同，小顶堆结构不同，用迭代器遍历和poll的结果可能不同");
        priorityQueue2.clear();
        priorityQueue2.offer(1);
        priorityQueue2.offer(2);
        priorityQueue2.offer(3);
        priorityQueue2.offer(4);
        priorityQueue2.offer(5);
        for (Iterator iterator = priorityQueue2.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + ",");
        }
        System.out.println();
        for (int i = 0, size = priorityQueue2.size(); i < size; i++) {
            System.out.print(priorityQueue2.poll() + ",");
        }

    }
}

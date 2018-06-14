package others;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 implements Runnable {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws Exception {
        Test2.testRetry();
        System.out.println(-1 << 29);

        System.out.println(Runtime.getRuntime().maxMemory());

        Test2 test2 = new Test2();
        test2.finalRefSameObjTest();

        // 创建ArrayList
        ArrayList list = new ArrayList();

        // 将“”
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        // 将下面的元素添加到第1个位置
        list.add(0, "5");

        // 获取第1个元素
        System.out.println("the first element is: " + list.get(0));
        // 删除“3”
        list.remove("3");
        // 获取ArrayList的大小
        System.out.println("Arraylist size=: " + list.size());
        // 判断list中是否包含"3"
        System.out.println("ArrayList contains 3 is: " + list.contains(3));
        // 设置第2个元素为10
        list.set(1, "10");

        // 通过Iterator遍历ArrayList
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            System.out.println("next is: " + iter.next());
        }

        // 将ArrayList转换为数组
        String[] arr = (String[]) list.toArray(new String[0]);
        for (String str : arr)
            System.out.println("str: " + str);

        // 清空ArrayList
        list.clear();
        // 判断ArrayList是否为空
        System.out.println("ArrayList is empty: " + list.isEmpty());

        System.out.println("ab,c,d".split(","));
        /**
         * 测试Integer的取值范围
         */
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);
        i1 = 126;
        i2 = 126;
        System.out.println(i1 == i2);
        i1 = 128;
        i2 = 128;
        System.out.println(i1 == i2);

        /**
         * 测试强制类型转换
         */
        long temp = (int) 3.9;
        System.out.println(temp);
        temp %= 2;
        System.out.println(temp);
    }

    public static void testRetry() {
        th:
        for (int i = 0; i < 10; i++) {
            System.out.println("for i = " + i);

            while (i == 5) {
                System.out.println("i = " + i);
                continue th;
            }
            System.out.println(i + " ");
        }
    }

    final ReentrantLock takeLock = new ReentrantLock();

    public void finalRefSameObjTest() {
        final ReentrantLock takeLock = this.takeLock;
        System.out.println(takeLock);
        System.out.println(this.takeLock);

    }

    public void objectMethod() {
        try {
            this.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Class<? extends Test2> class1 = this.getClass();
        try {
            this.wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.notify();
        this.notifyAll();
        this.toString();
        try {
            this.finalize();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.equals(this);
        this.hashCode();
    }

    public static String lpad(String str, int num, String pad) {
        String n_str = str;
        if (str == null)
            n_str = " ";
        for (int i = str.length(); i < num; i++) {
            n_str = pad + n_str;
        }
        return n_str;
    }

    @Override
    public void run() {
        System.out.println("r1");
        System.out.println("r2");
    }
}

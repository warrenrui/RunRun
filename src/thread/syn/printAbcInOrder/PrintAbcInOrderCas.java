package thread.syn.printAbcInOrder;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 按照顺序循环打印ABC【不能实现】。只能保证CAS操作是原子性的，不能保证多线程中的有序性。
 *
 * @author xxr
 */
public class PrintAbcInOrderCas {
    private static Unsafe unsafe;
    private static long stateOffset;

    static {
        try {
            // 通过反射获取rt.jar下的Unsafe类
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println("Get Unsafe instance occur error" + e);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final int times = 5;
        final Target target = new Target();
        try {
            stateOffset = unsafe.objectFieldOffset(Target.class.getDeclaredField("state"));
            System.out.println(stateOffset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    while (true) {
                        if (unsafe.compareAndSwapInt(target, stateOffset, 1, 2)) {
                            System.out.println(Thread.currentThread().getName() + "--A");
                            break;
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    while (true) {
                        if (unsafe.compareAndSwapInt(target, stateOffset, 2, 3)) {
                            System.out.println(Thread.currentThread().getName() + "----B");
                            break;
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < times; i++) {
                    while (true) {
                        if (unsafe.compareAndSwapInt(target, stateOffset, 3, 1)) {
                            System.out.println(Thread.currentThread().getName() + "------C");
                            break;
                        }
                    }
                }
            }
        }).start();

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(System.currentTimeMillis() - startTime);
        // 3401,3345,3454
    }
}

class Target {
    volatile int state = 1;
}

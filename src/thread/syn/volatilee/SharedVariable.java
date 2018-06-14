package thread.syn.volatilee;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedVariable {
    public static AtomicInteger atomicCount = new AtomicInteger(0);
    public static volatile int volatileCount = 0;
    private static int staticCount;
    private int count;

    public static void atomicInc() {
        // 这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        // 原子性自增操作
        atomicCount.incrementAndGet();
    }

    public static void volatileInc() {
        // 这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        // 自增不具备原子性
        volatileCount++;
    }

    public static void staticInc() {
        // 这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        // 自增不具备原子性
        staticCount++;
    }

    public void inc() {
        // 这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        // 自增不具备原子性
        count++;
    }

    public static void main(String[] args) {
        final int time = 10000;

        // 同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < time; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SharedVariable.volatileInc();
                }
            }).start();
        }
        for (int i = 0; i < time; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SharedVariable.atomicInc();
                }
            }).start();
        }
        for (int i = 0; i < time; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SharedVariable.staticInc();
                }
            }).start();
        }
        final SharedVariable sharedVariable = new SharedVariable();
        for (int i = 0; i < time; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sharedVariable.inc();
                }
            }).start();
        }

        // 等待所有累加线程都结束
        while (Thread.activeCount() > 1)
            Thread.yield();
        // 这里每次运行的值都有可能不同,可能为1000
        System.out.println("自增不具备原子性——运行结果:Counter.count=" + SharedVariable.volatileCount);
        // CAS操作实现了非阻塞同步
        System.out.println("CAS操作实现了非阻塞同步——运行结果:Counter.atomicCount=" + SharedVariable.atomicCount);
        System.out.println("静态变量——运行结果:Counter.staticCount=" + SharedVariable.staticCount);
        System.out.println("非静态变量——运行结果:Counter.staticCount=" + sharedVariable.count);
    }
}
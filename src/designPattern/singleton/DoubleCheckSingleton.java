package designPattern.singleton;

public class DoubleCheckSingleton {
    // java5.0 修改了内存模型, 可以保证使用volatile 声明的变量对于double checked locking是正确的
    private volatile static DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {// check if it is created.
            // 只在第一次的时候会使用到synchronized
            synchronized (DoubleCheckSingleton.class) {// synchronize create
                // block
                if (instance == null) {// double check if it is created.
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}

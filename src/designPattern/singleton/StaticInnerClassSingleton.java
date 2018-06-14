package designPattern.singleton;

/**
 * 登记式/静态内部类
 */
public class StaticInnerClassSingleton {

    /**
     * 当JVM加载LazyLoadedSingleton类时，由于该类没有static属性，所以加载完成后即可返回。
     * 只有第一次调用getInstance
     * ()方法时，JVM才会加载SingletonHolder类，由于它包含一个static属性singletonInstance，
     * 所以会首先初始化这个变量，该过程不会出现并发问题，这样就实现了一个既线程安全又支持延迟加载的单例模式
     */

    private StaticInnerClassSingleton() {
    }

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton singleton1 = StaticInnerClassSingleton.getInstance();
        if (singleton == singleton1) {
            System.out.println("same");
        } else {
            System.out.println();
        }
    }
}
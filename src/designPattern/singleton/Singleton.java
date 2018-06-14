package designPattern.singleton;

public class Singleton {
    private static Singleton instance = null;

    // 私有构造方法，防止被实例化
    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        // 这个方法比上面有所改进，不用每次都进行生成对象，只是第一次使用时生成实例，提高了效率！
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}

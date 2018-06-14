package designPattern.singleton;

import designPattern.filterPattern.Target;

/**
 * 单元素的枚举类型已经成为实现Singleton的最佳方法。
 */
public enum EnumSingleton {
    INSTANCE;
    private Target instance;

    private EnumSingleton() {
        instance = new Target();
    }

    public Target getInstance() {
        return instance;
    }
}

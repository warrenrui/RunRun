package designPattern.singleton;

import designPattern.filterPattern.Target;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {
    public static void main(String[] args) throws Exception {
        StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton singleton1 = StaticInnerClassSingleton.getInstance();
        System.out.println(singleton == singleton1);

        Target target = EnumSingleton.INSTANCE.getInstance();
        Target target2 = EnumSingleton.INSTANCE.getInstance();
        System.out.println(target == target2);
        testReflex();
    }

    /**
     * 写法存在缺陷，可以利用反射的方式来实例化多个不同的实例
     */
    public static void testReflex() throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        HungryManSingleton hungryManSingleton = HungryManSingleton.getInstance();
        Class<HungryManSingleton> cls = HungryManSingleton.class;
        Constructor<HungryManSingleton> constructor = cls.getDeclaredConstructor(new Class[]{});
        constructor.setAccessible(true);
        HungryManSingleton hungryManSingleton2 = constructor.newInstance(new Object[]{});
        System.out.println(hungryManSingleton == hungryManSingleton2);

        Target target = EnumSingleton.INSTANCE.getInstance();
        Class<Target> cls1 = Target.class;
        Constructor<Target> constructor1 = cls1.getDeclaredConstructor(new Class[]{});
        constructor.setAccessible(true);
        Target target2 = constructor1.newInstance(new Object[]{});
        System.out.println(target == target2);
    }
}

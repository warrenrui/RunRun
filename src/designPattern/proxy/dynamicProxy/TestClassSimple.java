package designPattern.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class TestClassSimple {
    public static void main(String[] args) {
        // 目标类，实现多个接口
        Target target = new Target();

        // 织入器，织入器使用接口反射机制生成一个目标对象的代理类实例，将横切逻辑代码织入代理类。
        TargetInterface1 targetProxy1 = (TargetInterface1) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new TargetInvocationHandler(target));

        // 使用代理类的实例来调用实现的接口的方法。
        targetProxy1.Interface1DoSth();
    }
}

package designPattern.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class TestClass {
    public static void main(String[] args) {
        // InvocationHandler实际处理目标类
        // 构建AOP的Advice和Pointcut，这里需要传入业务类的实例。
        // InvocationHandler是切面Aspect，它包含了Advice和Pointcut。
        TargetInvocationHandler targetInvocationHandler = new TargetInvocationHandler();

        // 目标类，实现多个接口
        Target target = new Target();
        // InvocationHandler调用目标类
        targetInvocationHandler.setTarget(target);

        // 生成代理类的字节码加载器
        ClassLoader loader = target.getClass().getClassLoader();
        // 需要代理的接口，被代理类实现的多个接口
        Class[] interfaces = target.getClass().getInterfaces();

        // 织入器，织入器使用接口反射机制生成一个目标对象的代理类实例，将横切逻辑代码织入代理类。
        TargetInterface1 targetProxy1 = (TargetInterface1) Proxy.newProxyInstance(loader, interfaces, targetInvocationHandler);
        TargetInterface2 targetProxy2 = (TargetInterface2) Proxy.newProxyInstance(loader, interfaces, targetInvocationHandler);
        Object object = Proxy.newProxyInstance(loader, interfaces, targetInvocationHandler);


        // 使用代理类的实例来调用实现的接口的方法。
        targetProxy1.Interface1DoSth();
        targetProxy2.Interface2DoSth();
    }
}

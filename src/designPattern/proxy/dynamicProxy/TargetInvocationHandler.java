package designPattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TargetInvocationHandler implements InvocationHandler {
    private Object target;

    public TargetInvocationHandler() {
    }

    public TargetInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public void beforeMethod(Method method) {
        System.out.println(method.getName() + " method execute before!");
    }

    public void afterMethod(Method method) {
        System.out.println(method.getName() + " method execute after!");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod(method);
        Object object = method.invoke(target, args);
        afterMethod(method);
        return object;
    }
}

package designPattern.proxy.dynamicProxy;

public class Target implements TargetInterface1, TargetInterface2 {

    @Override
    public void Interface2DoSth() {
        System.out.println("Target dosomthing 222222222");
    }

    @Override
    public void Interface1DoSth() {
        System.out.println("Target dosomthing 11111111");
    }

    public void doSth() {
        System.out.println("Target dosomthing");
    }

}

package designPattern.adapter.clazz;

public class AdapterClass extends SourceClass implements Targetable {

    @Override
    public void method2() {
        System.out.println("目标接口方法2");
    }

}

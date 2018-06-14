package designPattern.adapter.object;

import designPattern.adapter.clazz.SourceClass;
import designPattern.adapter.clazz.Targetable;

public class AdapterObject implements Targetable {
    private SourceClass sourceClass;

    public AdapterObject(SourceClass sourceClass) {
        super();
        this.sourceClass = sourceClass;
    }

    @Override
    public void method1() {
        sourceClass.method1();
    }

    @Override
    public void method2() {
        System.out.println("目标接口方法2");
    }

}

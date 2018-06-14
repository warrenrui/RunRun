package designPattern.adapter;

import designPattern.adapter.clazz.AdapterClass;
import designPattern.adapter.clazz.SourceClass;
import designPattern.adapter.clazz.Targetable;
import designPattern.adapter.interfacee.SourceInterface;
import designPattern.adapter.interfacee.SourceSub1;
import designPattern.adapter.interfacee.SourceSub2;
import designPattern.adapter.object.AdapterObject;

public class TestAdapter {
    /**
     * 最初的Source类，拥有一个方法method1。现在需要一个类，具有接口Targetable的特性。
     * 在不改变Source类的前提下，通过AdapterClass类，将Source适配成Targetable特性。
     * <p>
     * 现有的220v电压，但是手机充电需要的是5v的电压。在不改变原有电压的前提下，加入一个电源适配器，让220v电压成为了可用的5v电压。
     */
    public static void main(String[] args) {
        // 1、类的适配器模式。当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
        Targetable targetable = new AdapterClass();
        targetable.method1();
        targetable.method2();
        System.out.println("-----------------------------");
        // 2、对象的适配器模式。当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
        // 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题。
        SourceClass sourceClass = new SourceClass();
        Targetable targetable2 = new AdapterObject(sourceClass);
        targetable2.method1();
        targetable2.method2();
        System.out.println("-----------------------------");

        // /3、接口的适配器模式。当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
        // 有时我们写的一个接口中有多个抽象方法，当我们写该接口的实现类时，必须实现该接口的所有方法，这明显有时比较浪费，
        // 因为并不是所有的方法都是我们需要的，有时只需要某一些，此处为了解决这个问题，我们引入了接口的适配器模式，
        // 借助于一个抽象类，该抽象类实现了该接口，实现了所有的方法，而我们不和原始的接口打交道，只和该抽象类取得联系，所以我们写一个类，继承该抽象类，重写我们需要的方法就行。
        SourceInterface sourceSub1 = new SourceSub1();
        SourceInterface sourceSub2 = new SourceSub2();
        sourceSub1.method1();
        sourceSub1.method2();
        sourceSub2.method1();
        sourceSub2.method2();
    }
}

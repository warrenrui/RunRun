/*
 * 1、父类中的private变量，只能通过父类的set、get函数设置
 * 2、子类可以随意调用父类方法，不必先强制转换成父类
 * */


package testInterface;

abstract class Animal {
    private String nameString;

    void setName(String nameString) {
        this.nameString = nameString;
    }

    String getName() {
        return nameString;
    }

    abstract void enjoy();
}

interface Protectable {
    void beProtected();
}

interface Valuable {
    void value();
}

class GoldenMonkey extends Animal implements Protectable, Valuable {
    void enjoy() {
        System.out.println("i'm happy");
    }

    public void beProtected() {
        System.out.println("live in the room");
    }

    public void value() {
        System.out.println(10000);
    }
}

public class TestInterface {
    public static void main(String[] args) {
        GoldenMonkey goldenMonkey = new GoldenMonkey();
        goldenMonkey.setName("goldenMonkey");
        System.out.println(goldenMonkey.getName());
        goldenMonkey.enjoy();
        goldenMonkey.beProtected();
        goldenMonkey.value();
    }
}

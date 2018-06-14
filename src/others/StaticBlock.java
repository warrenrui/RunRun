package others;

class Parent {
    public static String p_StaticField = "父类--静态变量";
    public String p_Field = "父类--变量";

    // 代码块
    {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
    }

    // 构造函数
    public Parent() {
        System.out.println("父类--构造器");
    }

    // 静态初始化块
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态初始化块");
    }
}

public class StaticBlock extends Parent {
    public static String s_StaticField = "子类--静态变量";
    public String s_Field = "子类--变量";

    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }

    // 静态初始化块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }

    public StaticBlock() {
        System.out.println("子类--构造器");
    }

    public static void main(String[] args) {
        System.out.println("----------1---------");
        new Parent();
        System.out.println("----------2---------");
        new StaticBlock();
        System.out.println("----------3---------");
        new StaticBlock();
    }
}
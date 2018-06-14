package company.Igt;

public class test_5 extends Base {
    {
        System.out.print("5");
    }

    static {
        System.out.print("2");
    }

    public test_5() {
        System.out.print("6");
    }

    public static void main(String[] args) {
        new test_5();
    }
}

class Base {
    static {
        System.out.print("1");
    }

    {
        System.out.print("3");
    }

    public Base() {
        System.out.print("4");
    }
}

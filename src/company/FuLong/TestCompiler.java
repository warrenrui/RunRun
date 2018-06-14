package company.FuLong;

class FatherClass {
    static {
        System.out.println("FatherClass static.");
    }

    public FatherClass() {
        System.out.println("FatherClass Create.");
    }
}

class ChildClass extends FatherClass {
    static {
        System.out.println("ChildClass static");
    }

    public ChildClass() {
        System.out.println("ChildClass Create");
    }
}

public class TestCompiler {
    public static void main(String[] args) {
        FatherClass fc = new FatherClass();
        ChildClass cc = new ChildClass();
    }
}

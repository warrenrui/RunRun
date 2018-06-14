package others;

public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("i am B class");
    }

    static {
        System.out.println("static B");
    }

    @SuppressWarnings("unused")
    private void HelloAa() {
        System.out.println("这不是重写，属于新的方法");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}

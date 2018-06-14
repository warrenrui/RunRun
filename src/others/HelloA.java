package others;

public class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }

    @SuppressWarnings("unused")
    private void HelloAa() {
        System.out.println("HelloA");
    }

    {
        System.out.println("i am A class");
    }

    static {
        System.out.println("static A");
    }

}

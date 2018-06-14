package company.Igt;

public class test_4 {
    static class A {
        public int x = 10;
        public int y = 20;

        int f() {
            return y;
        }
    }

    static class B extends A {
        public int x = 1;
        public int y = 30;

        int f() {
            return y;
        }
    }

    public static void main(String[] args) {
        A a = new B();
        System.out.print(a.x + ",");
        System.out.println(a.f());
    }

}
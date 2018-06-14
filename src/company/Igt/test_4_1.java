package company.Igt;

public class test_4_1 {

    class A {
        public int x = 10;
        public int y = 20;

        int f() {
            return y;
        }
    }

    class B extends A {
        public int x = 1;
        public int y = 30;

        int f() {
            return y;
        }
    }

    public static void main(String[] args) {
//		A a = new B();
//		System.out.print(a.x + ",");
//		System.out.println(a.f());
        String bString = "as.df.ag";
        char[] a = bString.toCharArray();
        bString.length();
        String[] s = bString.split(".");


        ClassA aClassA = new ClassB();
        System.out.println(aClassA.x);
        System.out.println(aClassA.f());
    }


}

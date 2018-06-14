package others;

public class TestSwap {
    int i, j;

    public TestSwap(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static void main(String[] args) {
//		此方法无法实现交换===================================================== 
        // Integer a, b;
        // a = new Integer(10);
        // b = new Integer(20);
        // swap(a, b);
        // System.out.println("a is " + a);
        // System.out.println("b is " + b);

//		外部内联方法实现交换===================================================== 
//		TestSwap sw = new TestSwap(1, 2);
//		System.out.println("i is" + sw.i);
//		System.out.println("j is" + sw.j);
//		sw.swap();
//		System.out.println("i is" + sw.i);
//		System.out.println("j is" + sw.j);
    }

    //	函数重载可以只有函数名相同
    private int swap(int a) {
        return 4;
    }

    public void swap() {
        int temp;
        temp = i;
        i = j;
        j = temp;
    }

    // public static void swap(Integer a, Integer b) {
    // Integer temp = a;
    // a = b;
    // b = temp;
    // }
}

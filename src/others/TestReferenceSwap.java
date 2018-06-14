package others;

public class TestReferenceSwap {
    public static void main(String[] args) {
        String b = new String("hi");
        String a = "hello";
        a = b;
        b = "love";
        System.out.println("a: " + a);
//        String类型与其他类型不同，它初始化后不会改变，只能重新生成一个新的String变量
//        ==========================================================
        TestTemp test = new TestTemp();
        test.setId(1);
        TestTemp test2 = new TestTemp();
        test2.setId(2);

        System.out.println("before swap");
        System.out.println(test);
        System.out.println(test2);

//        swap(test, test2); //此方法无法实现交换

//        最原始方法实现交换===================================================== 
        TestTemp test3 = null;
        test3 = test;
        test = test2;
        test2 = test3;

        System.out.println("after swap");
        System.out.println(test);
        System.out.println(test2);

    }

    public static void swap(TestTemp a, TestTemp b) {
        TestTemp temp;
        temp = a;
        a = b;
        b = temp;
    }
}

class TestTemp {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
//	public String toString(){
//		return id + "";
//	}
}
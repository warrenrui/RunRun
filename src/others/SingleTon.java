package others;//public class SingleTon {
//	private SingleTon() {
//	}
//
//	// 在自己内部定义自己一个实例，是不是很奇怪？
//	// 注意这是private 只供内部调用
//	private static SingleTon instance = new SingleTon();
//
//	// 这里提供了一个供外部访问本class的静态方法，可以直接访问
//	public static SingleTon getInstance() {
//		return instance;
//	}
//}

// public class SingleTon {
// private static SingleTon instance = null;
//
// public static synchronized SingleTon getInstance() {
// // 这个方法比上面有所改进，不用每次都进行生成对象，只是第一次
// // 使用时生成实例，提高了效率！
// if (instance == null)
// instance = new SingleTon();
// return instance;
// }
// }

public class SingleTon {
    private static SingleTon instance = null;

    public static SingleTon getInstance() {
        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        SingleTon singleTon1 = SingleTon.getInstance();
        System.out.println(singleTon);
        System.out.println(singleTon1);
    }
}
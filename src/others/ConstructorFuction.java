package others;

class ConstructorParent {
    public ConstructorParent() {
        System.out.println("父类-构造函数");
    }

    public ConstructorParent(int a) {
        System.out.println("父类-构造函数");
    }
}

public class ConstructorFuction extends ConstructorParent {
    static String name;

    public static void main(String[] args) {
        new ConstructorFuction();

    }

    public ConstructorFuction() {
        System.out.println("子类-构造函数");
    }
	/*public static String getName() {
		return this.name;//can't use this in a static context
	}*/
}

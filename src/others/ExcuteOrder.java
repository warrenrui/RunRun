package others;

class Father {
    public Father(int a) {
        super();
        System.out.println(3);
        this.print();
    }

    public void print() {
        System.out.println(5);
    }
}

class Child extends Father {
    public Child(int a) {
        super(a);
        super.print();
        System.out.println(a);
    }

    public void print() {
        System.out.println(7);
    }
}

public class ExcuteOrder {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Child(9);
    }
}

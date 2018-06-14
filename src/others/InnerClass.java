package others;

public class InnerClass {

    public static void main(String[] args) {
        InnerClass a = new InnerClass();

        Inclass2 b = new Inclass2();
        InnerClass.Inclass2 bb = new InnerClass.Inclass2();

        InClass c = a.new InClass();
    }

    class InClass {

    }

    static class Inclass2 {

    }
}

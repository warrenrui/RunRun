package testDataType;

public class BaseDateType {
    /**
     * 八种基本数据类型 int short float double long boolean byte char
     */
    int i;
    short s;
    float f;
    double d;
    long l;
    boolean bo;
    byte bt;
    char c;

    public void printMember() {
        System.out.println("int->" + i);
        System.out.println("short->" + s);
        System.out.println("float->" + f);
        System.out.println("double->" + d);
        System.out.println("long->" + l);
        System.out.println("boolean->" + bo);
        System.out.println("byte->" + bt);
        System.out.println("char->" + c);
    }

    public static void main(String[] args) {
        BaseDateType baseDateType = new BaseDateType();
        baseDateType.printMember();
    }
}

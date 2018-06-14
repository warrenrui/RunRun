package testDataType;

public class ReferenceDateType {
    /*八种引用类型 */
    Integer integer;
    Short short1;
    Float float1;
    Double double1;
    Long long1;
    Boolean boolean1;
    Byte byte1;
    Character character;
    String string;

    public void printMember() {
        System.out.println("Integer->" + integer);
        System.out.println("Short->" + short1);
        System.out.println("Float->" + float1);
        System.out.println("Double->" + double1);
        System.out.println("Long->" + long1);
        System.out.println("Boolean->" + boolean1);
        System.out.println("Byte->" + byte1);
        System.out.println("Character->" + character);
        System.out.println("String->" + string);
    }

    public static void main(String[] args) {
        ReferenceDateType referenceDateType = new ReferenceDateType();
        referenceDateType.printMember();
    }
}

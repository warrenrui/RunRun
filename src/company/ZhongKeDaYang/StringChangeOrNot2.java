package company.ZhongKeDaYang;

public class StringChangeOrNot2 {
    public static void stringReplace(String input) {
        input = input.replace("j", "c");
    }

    public static void stringBufferReplace(StringBuffer input) {
        input = input.append("c");
    }

    public static void main(String[] args) {
        String testString = "java";
        StringBuffer testStringBuffer = new StringBuffer("java");
        stringReplace(testString);
        stringBufferReplace(testStringBuffer);
        System.out.println(testString + testStringBuffer);
    }
}

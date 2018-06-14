package others;

public class TestFinal {
    final public static StringBuffer sb = new StringBuffer();
    final public static String str = "aaabb";
    final public static int i = 0;

    public static void main(String[] args) {
        sb.append("123");
//		str = str.replace("a", "c");
        System.out.println(str);
        System.out.println(sb);
    }
}

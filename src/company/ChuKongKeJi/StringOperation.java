package company.ChuKongKeJi;

public class StringOperation {
    public static String fun(String s) {
        return s.length() > 0 ? fun(s.substring(1)) + s.charAt(0) : "";
    }

    public static void main(String[] args) {
        String string = "CocoaChina";
        System.out.println(fun(string));
    }
}

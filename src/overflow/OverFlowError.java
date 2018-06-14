package overflow;


public class OverFlowError {
    private static String str = "ab";

    public static void main(String[] args) throws Exception {
        String s1 = "a";
        String s2 = "b";
        String s = s1 + s2;
        System.out.println(s);
        System.out.println(s.intern());
        System.out.println(s.hashCode());
        System.out.println(str.hashCode());
        System.out.println(s == str);
        System.out.println(s.intern() == str);
        System.out.println(s == str);
        "".equals(s);
//		OverFlowError overFlowError = new OverFlowError();
//		overFlowError.stackOverFlowMethod();
    }

    /**
     * 栈溢出(StackOverflowError):方法运行的时候栈的深度超过了虚拟机容许的最大深度所致。
     */
    public void stackOverFlowMethod() {
        stackOverFlowMethod();
    }

}

package company.ZhongKeDaYang;

public class CatchExceptionOrNot {
    static StringBuffer s = new StringBuffer("");

    static void test(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
            s.append("1");
        } catch (Exception e) {
            s.append("2");
            return;
        } finally {
            s.append("3");
        }
        s.append("4");
    }

    public static void main(String[] args) {
        test(0);
        System.out.println(s);
        test(1);
        System.out.println(s);
    }
}

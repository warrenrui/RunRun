package company.ZhongKeDaYang;

public class OrAnd {
    int x;

    boolean check() {
        x++;
        return true;
    }

    void zzz() {
        x = 0;
        if ((check() | check()) || check()) {
            x++;
        }
        System.out.println("x =" + x);
    }

    public static void main(String[] args) {
        new OrAnd().zzz();
    }
}

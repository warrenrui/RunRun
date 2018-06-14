package company.ZhongKeDaYang;

public class StringChangeOrNot {
    String str = new String("good");
    char ch[] = {'a', 'b', 'c'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        StringChangeOrNot s = new StringChangeOrNot();
        s.change(s.str, s.ch);
        System.out.println(s.str + " and " + String.valueOf(s.ch));
    }
}

package others;

public class SwitchTest {
    public static void main(String[] args) {
        System.out.println(switchIt(2));
    }

    public static int switchIt(int x) {
        int j = 1;
        switch (x) {
            case 1:
                j++;
            case 2:
                j++;
            case 3:
                j++;
            default:
                j++;
        }
        return j + x;
    }
}

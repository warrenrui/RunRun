package others;

/**
 * 数字的ascll码范围
 *
 * @author Administrator
 */
public class FindNumFromString {
    public static void main(String[] args) {
        String string = "ab7c8de4fjh2";
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if ((int) charArray[i] >= 48 && (int) charArray[i] <= 57) {
                System.out.println(charArray[i]);
            }
        }
    }
}

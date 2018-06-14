//比较两个字符串的不同，返回不同点的位置（相对第二字符串而言）
package company.Qunar;

public class DiffPosition {

    public static String findDiffPosition(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int len = aLen < bLen ? aLen : bLen;
        int j = 0;
        String position = "";
        for (int i = 0; i < len; i++) {
            if (aArray[i] != bArray[i]) {
                position = position + i + ",";
            }
        }
        if (bLen > len) {
            int k = bLen - len;
            for (int i = 0; i < k; i++) {
                position = position + (len + i + 1) + ",";
            }
        }
        return position;
    }

    public static void main(String[] args) {
        String a = "asdf";
        String b = "aecfeasdf";
        System.out.println(DiffPosition.findDiffPosition(a, b));
    }
}

//将绝对路径转换成相对路径。例如， input: /home/news/../tmp/game/../; ouptut: /home/tmp/
//　　思路：利用栈的思想。每次遇到".."时，将退栈至上一个'/'位置。
package company.Qunar;

public class AbsolutePath {

    public String relativeToAbsolutePath(String str) {
        String mark = "/../";
        String[] subStr = str.split(mark);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < subStr.length; i++) {
            sb.append(subStr[i].substring(0, subStr[i].lastIndexOf("/")) + "/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "/home/news/../tmp/game/../";
        String output = "/home/tmp/";

        AbsolutePath absolutePath = new AbsolutePath();
        System.out.println(absolutePath.relativeToAbsolutePath(input));
    }
}

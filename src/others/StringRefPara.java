package others;

import java.util.HashSet;

public final class StringRefPara {
    public static int finala = 0;
    public int finala2 = 0;

    public static String appendStr(String s) {
        s += "bbb";
        return s;
    }

    public static StringBuilder appendSb(StringBuilder sb) {
        return sb.append("bbb");
    }

    public static void main(String[] args) {
        String s = new String("aaa");
        String ns = StringRefPara.appendStr(s);
        System.out.println("String aaa >>>" + s.toString());
        System.out.println("String aaa >>>" + ns.toString());

        StringBuilder sb = new StringBuilder("aaa");
        StringBuilder nsb = StringRefPara.appendSb(sb);
        System.out.println("StringBuilder aaa >>> " + sb.toString());
        System.out.println("StringBuilder aaa >>> " + nsb.toString());

        /**
         * 不要用可变类型做HashMap和HashSet的键值 eg：HashSet出现了两个相等的键值，破坏了唯一性的特点
         */
        HashSet<StringBuilder> hs = new HashSet<StringBuilder>();
        StringBuilder sb1 = new StringBuilder("ddd");
        StringBuilder sb2 = new StringBuilder("dddeee");
        hs.add(sb1);
        hs.add(sb2);
        StringBuilder sb3 = sb1;
        sb3.append("eee");
        System.out.println(hs);

        String string = null;
        System.out.println(string);
        string = new String();
        System.out.println(string);

        StringRefPara.finala += 1;
        System.out.println(StringRefPara.finala);
        StringRefPara stringRefPara = new StringRefPara();
        stringRefPara.finala2 += 2;
        System.out.println(stringRefPara.finala2);
    }
}

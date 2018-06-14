package others;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TempTest {
    public static String lpad(String str, int num, String pad) {
        String n_str = str;
        if (str == null)
            n_str = " ";
        for (int i = str.length(); i < num; i++) {
            n_str = pad + n_str;
        }
        return n_str;
    }

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        // PropertiesLoaderUtils
        String a = "abc";
        System.out.println(a.replace("b", "1111"));
        System.out.println(a);
    }
}

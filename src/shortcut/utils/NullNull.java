package shortcut.utils;


import java.util.HashMap;

public class NullNull {
    public static void main(String[] args) {
        final HashMap<String, Object> map = new HashMap<>();
        /**
         * 用equals方法比较字符串时，可能为null的放后面
         */
        System.out.println("abc".equals(map.get("abc")));
        // NullPointerException
//        System.out.println(map.get("abc").equals("abc"));
        // null
        System.out.println(map.get("abc"));
        // null
        System.out.println(String.valueOf(map.get("abc")));
        String abc = null;
        // null
        System.out.println(abc);
        // NullPointerException
        System.out.println(String.valueOf(null));


    }
}

package shortcut.utils;



import java.util.HashMap;

public class NullNull {
    public static void main(String[] args) {
        final HashMap<String, Object> map = new HashMap<>();
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

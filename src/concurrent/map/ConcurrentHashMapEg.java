package concurrent.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEg {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>(4);
        concurrentHashMap.put("a", "a");
        concurrentHashMap.put("b", "b");
        concurrentHashMap.put("aa", "aa");
        concurrentHashMap.put("aaa", "aaa");
        concurrentHashMap.put("aaaa", "aaaa");
        concurrentHashMap.put("aaaaa", "aaaaa");
        concurrentHashMap.put("bb", "a");
        concurrentHashMap.put("e", "a");
        concurrentHashMap.put("f", "a");
        concurrentHashMap.put("g", "a");
        concurrentHashMap.put("h", "a");
        concurrentHashMap.put("i", "a");
        concurrentHashMap.put("j", "a");
        concurrentHashMap.put("k", "a");
        concurrentHashMap.put("l", "a");
        System.out.println(concurrentHashMap.remove("aaa"));

        System.out.println(concurrentHashMap.contains("abc"));

        System.out.println(concurrentHashMap.get("a"));
        System.out.println(concurrentHashMap.get("aaa"));
        System.out.println(concurrentHashMap.size());

    }
}

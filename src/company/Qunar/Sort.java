package company.Qunar;

import java.util.HashMap;

public class Sort {
    public HashMap sortStandard(char[] seq) {
        int count = 0;
        HashMap map = new HashMap();
        for (int i = 0; i < seq.length; i++) {
            map.put(seq[i], count++);
        }
        return map;
    }

    public int compareChar(char a, char b, HashMap map) {
        if (map.containsKey(a) && map.containsKey(b)) {
            if ((Integer) map.get(a) > (Integer) map.get(b)) {
                return 1;
            } else if ((Integer) map.get(a) == (Integer) map.get(b)) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return String.valueOf(a).compareTo(String.valueOf(b));
        }
    }

    public int compareString(String a, String b, HashMap map) {
        int aLen = a.length();
        int bLen = b.length();
        int len = aLen > bLen ? aLen : bLen;
        int i = 0;
        int result = 0;
        while (i < len) {
            result = compareChar(a.charAt(i), b.charAt(i), map);
            if (result == 0) {
                i++;
                continue;
            } else {
                return result;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        String seq = "dgecfboa";
        HashMap map = sort.sortStandard(seq.toCharArray());
//		System.out.println(map);
//		System.out.println(sort.compareString("bed", "bed", map));
        String arrstr[] = {"bed", "dog", "dear", "eye"};
        int min = 0;
        String temp;
        for (int i = 0; i < arrstr.length; i++) {
            min = i;
            for (int j = min + 1; j < arrstr.length; j++) {
                if (sort.compareString(arrstr[min], arrstr[j], map) > 0) {
                    min = j;
                }
            }
            if (min != i) {
                temp = arrstr[i];
                arrstr[i] = arrstr[min];
                arrstr[min] = temp;
            }
        }

        for (int i = 0; i < arrstr.length; i++) {
            System.out.println(arrstr[i]);
        }
    }
}

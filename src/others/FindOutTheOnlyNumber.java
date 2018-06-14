package others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"rawtypes", "unchecked"})
public class FindOutTheOnlyNumber {

    /**
     * map中相同的元素计数
     */

    public static void main(String[] args) {
        String numList = "1、2、1、3、48、32、2、2、48、32";
        String num[] = numList.split("、");
        Map matchMap = new HashMap();
        for (int i = 0; i < num.length; i++) {
            if (matchMap.containsKey(num[i])) {
                matchMap.put(num[i], (Integer) matchMap.get(num[i]) + 1);
            } else {
                matchMap.put(num[i], 1);
            }
        }

        Set keyset = matchMap.keySet();
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if ((Integer) matchMap.get(key) == 3) {
                System.out.println(key);
            }
        }

    }
}

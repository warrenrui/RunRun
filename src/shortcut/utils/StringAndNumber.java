package shortcut.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.math.BigDecimal;

public class StringAndNumber {
    public static void main(String[] args) {
        String str = "123.324";
        // null
        System.out.println(Integer.getInteger(str));
        // exception
        // System.out.println((Integer)str);
        // ok
        System.out.println(new BigDecimal(str));

        DBObject query = new BasicDBObject();
        query.put("abc", "0.0");
        // 准确
        System.out.println(BigDecimal.ZERO.compareTo(new BigDecimal((String) query.get("abc"))));
        // false 坑
        System.out.println(BigDecimal.ZERO.equals(new BigDecimal((String) query.get("abc"))));



    }
}

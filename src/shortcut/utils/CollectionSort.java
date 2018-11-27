package shortcut.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionSort {
    public static void main(String[] args) {
        final ObjectToJson objectToJson = new ObjectToJson();
        objectToJson.setAge(18);
        objectToJson.setName("Jackson");

        final ObjectToJson objectToJson2 = new ObjectToJson();
        objectToJson2.setAge(12);
        objectToJson2.setName("Tom");

        final ObjectToJson objectToJson3 = new ObjectToJson();
        objectToJson3.setAge(24);
        objectToJson3.setName("Carl");

        final ArrayList<ObjectToJson> objectToJsons = new ArrayList<>();
        objectToJsons.add(objectToJson);
        objectToJsons.add(objectToJson2);
        objectToJsons.add(objectToJson3);

        System.out.println("原始排序：" + JSON.toJSONString(objectToJsons));

        /*
        1.6版本
         */
        Collections.sort(objectToJsons, new Comparator<ObjectToJson>() {
            @Override
            public int compare(ObjectToJson o1, ObjectToJson o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        System.out.println("逆序排序：" + JSON.toJSONString(objectToJsons));
        /*
        1.8版本
         */
        objectToJsons.sort(new Comparator<ObjectToJson>() {
            @Override
            public int compare(ObjectToJson o1, ObjectToJson o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("正序排序：" + JSON.toJSONString(objectToJsons));
        /*
        1.8版本，Lambda表达式
         */
        objectToJsons.sort((o1, o2) -> o2.getAge() - o1.getAge());
        System.out.println("逆序排序：" + JSON.toJSONString(objectToJsons));
        objectToJsons.sort(Comparator.comparingInt(ObjectToJson::getAge));
        System.out.println("正序排序：" + JSON.toJSONString(objectToJsons));

    }
}

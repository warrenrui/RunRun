package shortcut.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class FastJsonEg {
    public static void main(String[] args) {
        final ObjectToJson objectToJson = new ObjectToJson();
        objectToJson.setAge(18);
        objectToJson.setName("Jackson");
        final ArrayList<String> usedNameList = new ArrayList<>();
        usedNameList.add("Jim");
        usedNameList.add("Doge");
        objectToJson.setUsedName(usedNameList);

        final ObjectToJson objectToJson2 = new ObjectToJson();
        objectToJson2.setAge(22);
        objectToJson2.setName("John");
        final ArrayList<String> usedNameList2 = new ArrayList<>();
        usedNameList2.add("Tom");
        usedNameList2.add("Ruby");
        objectToJson2.setUsedName(usedNameList2);

        final ArrayList<ObjectToJson> objectToJsons = new ArrayList<>();
        objectToJsons.add(objectToJson);
        objectToJsons.add(objectToJson2);

        /*
         * 实体类转换成json字符串
         */
        String jsonString = JSON.toJSONString(objectToJsons);
        System.out.println("json字符串：" + jsonString);

        jsonString = "[{\"age\":18,\"name\":\"Jackson\",\"usedName\":[\"Jim\",\"Doge\"]},{\"age\":22,\"name\":\"John\",\"usedName\":[\"Tom\",\"Ruby\"]}]";

        /*
         * json字符串转换成实体对象
         * 如果json格式有问题，会抛异常
         */
        final List<ObjectToJson> objectToJsonList = JSON.parseObject(jsonString, new TypeReference<List<ObjectToJson>>() {
        });


        for (ObjectToJson jsonObject : objectToJsonList) {
            System.out.println("实体属性：" + jsonObject.getAge() + "," + jsonObject.getName());
        }


    }
}

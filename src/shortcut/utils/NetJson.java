package shortcut.utils;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NetJson {


    public static void main(String[] args) {
        String json = "{\"skuId\":\"EMG4418057095224\",\"typeCode\":0}";
        Map<String, String> map = (Map<String, String>) JSONObject.toBean(JSONObject.fromObject(json), Map.class);
        Map<String, String> maps = com.alibaba.fastjson.JSONObject.parseObject(json, Map.class);
//        maps = new HashMap<String, Object>();
        // json中的非字符串值，转换成map后，并不是字符串，直接获取有异常。map中的限定类型应该用Object
        final String abcd = maps.get("typeCode");
        final String abc = map.get("typeCode");


        final HashMap<String, String> map1 = new HashMap<>();
//        map1.put("we",new Integer(1));
    }
}

package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonParsed {
    // 创建JsonObject对象
    private static JsonObject createJsonObject() {
        JsonObject JsonObject = new JsonObject();
        JsonObject.addProperty("ret", new Integer(0));
        JsonObject.addProperty("msg", "query");
        JsonObject dataelem1 = new JsonObject();
        // {"deviceid":"SH01H20130002","latitude":"32.140","longitude":"118.640","speed":"","orientation":""}
        dataelem1.addProperty("deviceid", "SH01H20130002");
        dataelem1.addProperty("latitude", "32.140");
        dataelem1.addProperty("longitude", "118.640");

        JsonObject dataelem2 = new JsonObject();
        // {"deviceid":"SH01H20130002","latitude":"32.140","longitude":"118.640","speed":"","orientation":""}
        dataelem2.addProperty("deviceid", "SH01H20130002");
        dataelem2.addProperty("latitude", "32.140");
        dataelem2.addProperty("longitude", "118.640");

        // 返回一个JSONArray对象
        JsonArray jsonArray = new JsonArray();

        jsonArray.add(dataelem1);
        jsonArray.add(dataelem2);
        JsonObject.add("data", jsonArray);

        return JsonObject;
    }

    public static void main(String[] args) {
        JsonObject JsonObject = JsonParsed.createJsonObject();
        System.out.println("JsonObject：" + JsonObject);

        JsonElement data = JsonObject.get("data");
        JsonArray jsonArray = data.getAsJsonArray();
        JsonElement tempElement = null;
        for (int i = 0; i < jsonArray.size(); i++) {
            tempElement = jsonArray.get(i);
            JsonObject asJsonObject = tempElement.getAsJsonObject();
            System.out.println(asJsonObject.get("deviceid"));
            System.out.println(asJsonObject.get("latitude"));
            System.out.println(asJsonObject.get("longitude"));
        }
    }
}

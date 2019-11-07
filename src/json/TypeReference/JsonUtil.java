package json.TypeReference;


import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * JSON工具类
 */
@SuppressWarnings("unchecked")
public final class JsonUtil {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = Logger.getLogger(JsonUtil.class);

    private static ObjectMapper MAPPER;

    static {
        MAPPER = generateMapper(JsonSerialize.Inclusion.ALWAYS);
    }

    private JsonUtil() {
    }

    /**
     * 将json通过类型转换成对象
     *
     * @param json  json字符串
     * @param clazz 泛型类型
     * @return 返回对象
     * @throws IOException
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        try {
            if (null == json || "".equals(json)) return null;
            return clazz.equals(String.class) ? (T) json : MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 将对象转换成json
     *
     * @param src 对象
     * @return 返回json字符串
     * @throws IOException
     */
    public static <T> String toJson(T src) {
        try {
            return src instanceof String ? (String) src : MAPPER.writeValueAsString(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将对象转换成json, 可以设置输出属性
     *
     * @param src       对象
     * @param inclusion 传入一个枚举值, 设置输出属性
     * @return 返回json字符串
     * @throws IOException
     */
    public static <T> String toJson(T src, JsonSerialize.Inclusion inclusion) throws IOException {
        if (src instanceof String) {
            return (String) src;
        } else {
            ObjectMapper customMapper = generateMapper(inclusion);
            return customMapper.writeValueAsString(src);
        }
    }

    /**
     * 将对象转换成json, 传入配置对象
     *
     * @param src    对象
     * @param mapper 配置对象
     * @return 返回json字符串
     * @throws IOException
     * @see org.codehaus.jackson.map.ObjectMapper
     */
    public static <T> String toJson(T src, ObjectMapper mapper) throws IOException {
        if (null != mapper) {
            if (src instanceof String) {
                return (String) src;
            } else {
                return mapper.writeValueAsString(src);
            }
        } else {
            return null;
        }
    }

    /**
     * 返回{@link org.codehaus.jackson.map.ObjectMapper ObjectMapper}对象, 用于定制性的操作
     */
    public static ObjectMapper mapper() {
        return MAPPER;
    }

    /**
     * 通过Inclusion创建ObjectMapper对象
     *
     * @return 返回ObjectMapper对象
     */
    private static ObjectMapper generateMapper(JsonSerialize.Inclusion inclusion) {

        ObjectMapper customMapper = new ObjectMapper();

        // 设置输出时包含属性的风格
        customMapper.setSerializationInclusion(inclusion);

        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        customMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 禁止使用int代表Enum的order()來反序列化Enum,非常危險
        customMapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);

        // 所有日期格式都统一为以下样式
        customMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        return customMapper;
    }

    /**
     * 默认的ObjectMapper
     *
     * @return ObjectMapper
     * @author zhaotianming@360buy.com
     */
    public static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        //取消毫秒显示日期
        //objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    /**
     * 将json通过类型转换成集合对象
     *
     * @param json  json字符串
     * @param clazz 引用类型
     * @return 返回集合
     * @throws IOException
     */
    public static <T> List<T> fromJsonToList(String json, Class<T> clazz) throws IOException {
        if (null == json || "".equals(json)) return null;
        JavaType javaType = getCollectionType(List.class, clazz);
        return (List<T>) MAPPER.readValue(json, javaType);
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * 将json通过类型转换成对象
     *
     * @param json          json字符串
     * @param typeReference 引用类型
     * @return 返回对象
     * @throws IOException
     */
    public static <T> T fromJson(String json, TypeReference<?> typeReference) throws IOException {
        if (null == json || "".equals(json)) return null;
        return (T) (typeReference.getType().equals(String.class) ? json : MAPPER.readValue(json, typeReference));
    }

    public static void main(String[] args) throws IOException {
        String jsonParam = "{\"books\":[{\"address\":\"北京市朝阳区金盏乡沙皮路黎各庄7号，预约电话：4006225686-01009\",\"adoptNo\":\"S19111600054\",\"beyondBookFlag\":null,\"bookDate\":\"2019-11-16\",\"bookDetails\":[{\"addNo\":null,\"addNoType\":null,\"arriveDate\":null,\"batchNo\":null,\"batchSign\":0,\"bookDate\":null,\"bookID\":1750874,\"bookNo\":null,\"bookQty\":20,\"bookSource\":0,\"bookTimePeriod\":null,\"boxQty\":0,\"buyer\":\"bjjdz\",\"buyerErpCode\":null,\"cancelTime\":null,\"cancelUserID\":null,\"categoryMap\":{},\"channelType\":null,\"createTime\":\"2019-11-06 17:15:54\",\"createUser\":\"BJADMIN\",\"dcNo\":null,\"deptID\":null,\"eclpDeptNo\":null,\"groupID\":null,\"handSign\":2,\"id\":3698845,\"newBookFlag\":0,\"occupyQuotaFlag\":1,\"oldBookID\":0,\"oldBookQty\":20,\"oneLevelOrgCode\":null,\"orgCodePath\":null,\"poInsureMoney\":null,\"poNo\":\"458396660\",\"preStatus\":0,\"purchaseQty\":60,\"purchaseType\":0,\"queuingDate\":null,\"queuingMode\":null,\"quotaDeptId\":null,\"quotaNo\":\"A00007_2019-11-13_1;A00007_2019-11-14_10;A00007_2019-11-15_9;\",\"reason\":null,\"reasonName\":null,\"receiveBeginTime\":null,\"receiveEndTime\":null,\"receiveQty\":0,\"receiver\":null,\"registerTel\":null,\"remark\":null,\"skuQty\":0,\"status\":1,\"supName\":\"北京燕轮供销公司\",\"supNo\":\"bjylgxgs\",\"threeLevelOrgCode\":null,\"twoLevleOrgCode\":null,\"updateTime\":\"2019-11-06 17:15:54\",\"updateUser\":null,\"useCommonQuota\":0,\"version\":0,\"whAreaNo\":0,\"whNo\":null,\"yn\":0}],\"bookNo\":null,\"bookQty\":20,\"bookQuantity\":20,\"bookSource\":0,\"bookTime\":null,\"bookTimePeriod\":\"14:00-15:00\",\"bookedMap\":null,\"carrier\":\"奥克斯\",\"carrierTel\":\"11111111111\",\"cateoryQtyCurMapped\":{\"794_823\":20},\"createTime\":null,\"createUser\":\"BJADMIN\",\"createUserName\":null,\"dcName\":\"北京\",\"dcNo\":6,\"defConfig\":null,\"deptCancelBookMap\":null,\"deptIds\":null,\"deptType\":null,\"driverTel\":null,\"eclp\":false,\"failureReason\":null,\"firstQueueTime\":null,\"giftSkuList\":null,\"handSign\":1,\"id\":1750874,\"instoreDate\":null,\"isFromTc\":false,\"isUrgent\":0,\"manageTypeMap\":null,\"occupyDeptID\":null,\"occupyGroupID\":null,\"operator\":null,\"orgName\":\"总公司\",\"orgNo\":6,\"ownerName\":\"京东\",\"ownerNo\":\"JD\",\"phone\":null,\"poDeptLockerMap\":null,\"poList\":[\"458396660\"],\"poNo\":null,\"preStatus\":1,\"purchaseQty\":null,\"queue\":false,\"queueNo\":null,\"reasonName\":null,\"registerTel\":null,\"remark\":null,\"restBookQty\":19,\"self\":0,\"shippingListUrl\":null,\"source\":null,\"status\":99,\"supName\":null,\"tcCode\":null,\"tcName\":null,\"updateTime\":null,\"updateUser\":\"BJADMIN\",\"version\":0,\"whName\":\"大件运营中心\",\"whNo\":2,\"yn\":0}],\"lockers\":[{\"bookDateString\":\"2019-11-14\",\"bookTimeString\":\"05:00-06:00\",\"bookedQty\":0,\"bookedQuantity\":0,\"createTime\":null,\"createUser\":\"BJADMIN\",\"dcNo\":6,\"decrementEclpQty\":0,\"decrementQty\":0,\"decrementQueueQty\":0,\"decrementSelfQty\":0,\"deptId\":null,\"eclp\":false,\"eclpBookedQty\":0,\"eclpCapacityInPeriod\":0,\"eclpWillBookQty\":0,\"id\":0,\"lockTime\":null,\"maxQty\":0,\"produceCapacityInPeriod\":1,\"queueBookedQty\":0,\"queueCapacityInPeriod\":0,\"queueFlag\":null,\"queueWillBookQty\":0,\"quotaNo\":\"A00007\",\"quotaType\":5,\"selfBookedQty\":0,\"selfCapacityInPeriod\":0,\"selfWillBookQty\":0,\"status\":1,\"updateTime\":null,\"updateUser\":\"BJADMIN\",\"version\":0,\"whNo\":2,\"willBookQty\":1,\"yn\":0},{\"bookDateString\":\"2019-11-15\",\"bookTimeString\":\"05:00-06:00\",\"bookedQty\":0,\"bookedQuantity\":0,\"createTime\":null,\"createUser\":\"BJADMIN\",\"dcNo\":6,\"decrementEclpQty\":0,\"decrementQty\":0,\"decrementQueueQty\":0,\"decrementSelfQty\":0,\"deptId\":null,\"eclp\":false,\"eclpBookedQty\":0,\"eclpCapacityInPeriod\":0,\"eclpWillBookQty\":0,\"id\":0,\"lockTime\":null,\"maxQty\":0,\"produceCapacityInPeriod\":1,\"queueBookedQty\":0,\"queueCapacityInPeriod\":0,\"queueFlag\":null,\"queueWillBookQty\":0,\"quotaNo\":\"A00007\",\"quotaType\":5,\"selfBookedQty\":0,\"selfCapacityInPeriod\":0,\"selfWillBookQty\":0,\"status\":1,\"updateTime\":null,\"updateUser\":\"BJADMIN\",\"version\":0,\"whNo\":2,\"willBookQty\":1,\"yn\":0},{\"bookDateString\":\"2019-11-14\",\"bookTimeString\":\"14:00-15:00\",\"bookedQty\":0,\"bookedQuantity\":0,\"createTime\":null,\"createUser\":\"BJADMIN\",\"dcNo\":6,\"decrementEclpQty\":0,\"decrementQty\":0,\"decrementQueueQty\":0,\"decrementSelfQty\":0,\"deptId\":null,\"eclp\":false,\"eclpBookedQty\":0,\"eclpCapacityInPeriod\":0,\"eclpWillBookQty\":0,\"id\":0,\"lockTime\":null,\"maxQty\":0,\"produceCapacityInPeriod\":1,\"queueBookedQty\":0,\"queueCapacityInPeriod\":0,\"queueFlag\":null,\"queueWillBookQty\":0,\"quotaNo\":\"A00007\",\"quotaType\":5,\"selfBookedQty\":0,\"selfCapacityInPeriod\":0,\"selfWillBookQty\":0,\"status\":1,\"updateTime\":null,\"updateUser\":\"BJADMIN\",\"version\":0,\"whNo\":2,\"willBookQty\":1,\"yn\":0}],\"pid\":null,\"poNoBookNoMap\":null,\"sendGateWay\":false}";
        final Object json = JsonUtil.fromJson(jsonParam, new TypeReference<BookSubmitParam<BigBook>>() {
        });

        System.out.println(JSON.toJSONString(json));

        final BigBook bigBook = new BigBook();
        final List<BigBookSkuDetail> bigBookSkuDetails = bigBook.getBigBookSkuDetails();

    }
}

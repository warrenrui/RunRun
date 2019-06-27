package shortcut.utils;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shortcut.beanEg.Suit;
import shortcut.beanEg.SuitProduct;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MapToBeanUtil {

    private static Logger logger = LoggerFactory.getLogger(MapToBeanUtil.class);


    /**
     * HashMap->Object
     *
     * @param map json转换的map，可能包含实体类list
     * @param obj 要解析的实体类
     */
    public static void setBeanField(Map<String, Object> map, Object obj) {
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    setFieldValue(entry.getKey(), obj, entry.getValue());
                } catch (Exception e) {
                    logger.error("hash to object fail", e);
                }
            }
        }
    }

    /**
     * 反映获取指定字段值
     *
     * @param fieldName
     * @param obj
     * @return
     */
    public static String getFieldValue(String fieldName, Object obj) throws Exception {
        try {
            String methodName = getMethodName("get", fieldName);
            Method method = getDeclaredMethod(obj, methodName, new Class[0]);
            if (method != null) {
                method.setAccessible(true);
                return defaultObject(method.invoke(obj, new Object[0]));
            }
        } catch (Exception ex) {
            logger.error("获取对象值失败:", ex);
            throw new Exception("获取对象值失败!");
        }
        return "";
    }


    /**
     * 反映设置指定字段值
     *
     * @param fieldName  map中的key，对应实体中的field
     * @param obj        实体
     * @param fieldValue map中的value，对应实体中的field值
     */
    private static void setFieldValue(String fieldName, Object obj, Object fieldValue) throws Exception {
        try {
            String methodName = getMethodName("set", fieldName);
            Method method = getDeclaredMethod(obj, methodName, fieldValue.getClass());
            if (method != null) {
                method.setAccessible(true);
                method.invoke(obj, new Object[]{fieldValue});
            }
        } catch (Exception ex) {
            logger.error("设置对象值失败:", ex);
            throw new Exception("设置对象值失败!");
        }
    }

    /**
     * 获取方法名称
     *
     * @param prefix
     * @param fieldName
     * @return
     */
    private static String getMethodName(String prefix, String fieldName) {
        return prefix + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }


    /**
     * 查找方法：子类中无方法声明，查找父类
     *
     * @param object
     * @param methodName
     * @param parameterTypes
     * @return
     */
    private static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
        Method method;
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Exception e) {
                logger.debug("获取方法声明失败:", e);
            }
        }
        return null;
    }

    /**
     * 设置默认值
     *
     * @param obj
     * @return
     */
    private static String defaultObject(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return String.valueOf(obj);
        }
    }

    public static void main(String[] args) {
        String message = "{\"created\":1539765944387,\"id\":18541,\"modified\":1539770671680,\"name\":\"附件绑定\",\"newBpm\":false,\"operateInfo\":{\"id\":567673277,\"operateId\":520558,\"operateName\":\"赵歆卓\",\"operateType\":6,\"operator\":\"zhaoxinzhuo\",\"opinion\":\"同意\",\"promoId\":18541,\"promoType\":5},\"operateName\":\"李斌\",\"operator\":\"zhaoxinzhuo\",\"promoId\":238254402,\"skuId\":\"100000306989\",\"status\":1,\"suitProductList\":[{\"created\":1539765944390,\"id\":21806,\"modified\":1539765944390,\"num\":1,\"showState\":0,\"skuId\":\"8316192\",\"splitPrice\":1000.0000,\"suitId\":18541},{\"created\":1539765944393,\"id\":21807,\"modified\":1539765944393,\"num\":1,\"showState\":0,\"skuId\":\"100000669598\",\"splitPrice\":2400.0000,\"suitId\":18541}],\"suitSkuList\":[],\"type\":1,\"yn\":0}";
        Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(message), Map.class);
        Suit suit = new Suit();
        suit.setId(String.valueOf(map.get("id")));
        setBeanField(map, suit);
        final List<Object> suitProductList = (List<Object>) map.get("suitProductList");
        if (CollectionUtils.isNotEmpty(suitProductList)) {
            final ArrayList<SuitProduct> suitProducts = new ArrayList<SuitProduct>();
            suit.setSuitProductList(suitProducts);
            for (Object o : suitProductList) {
                Map<String, Object> suitProductMap = (Map<String, Object>) JSONObject.toBean(JSONObject.fromObject(o), Map.class);
                final SuitProduct suitProduct = new SuitProduct();
                setBeanField(suitProductMap, suitProduct);
                suitProduct.setId(Long.valueOf((Integer) suitProductMap.get("id")));
                suitProduct.setSuitId(String.valueOf(suitProductMap.get("suitId")));
                suitProduct.setSplitPrice(BigDecimal.valueOf((Double) suitProductMap.get("splitPrice")));
                suitProducts.add(suitProduct);
            }
        }

        System.out.println(JSON.toJSONString(suit));
    }
}
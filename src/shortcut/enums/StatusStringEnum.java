package shortcut.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 枚举类
 */
public enum StatusStringEnum {
    Init("0", "初始"),
    Located("1", "已定位"),
    LocateFailed("2", "定位失败"),
    Occupied("3", "已预占"),

    NoMatch(null, "未知的状态类型");

    private static final Map<String, StatusStringEnum> MAP = new HashMap<String, StatusStringEnum>();

    static {
        for (StatusStringEnum e : EnumSet.allOf(StatusStringEnum.class)) {
            MAP.put(e.getKey(), e);
        }
    }

    public static StatusStringEnum getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return NoMatch;
        }
        return MAP.get(code) == null ? NoMatch : MAP.get(code);
    }

    private String key;
    private String text;

    StatusStringEnum(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public static void main(String[] args) {
        System.out.println(StatusStringEnum.getByCode("30").getText());
    }
}
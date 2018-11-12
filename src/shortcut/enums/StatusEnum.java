package shortcut.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 枚举类
 */
public enum StatusEnum {
    Init(0, "初始"),
    Located(1, "已定位"),
    LocateFailed(2, "定位失败"),
    Occupied(3, "已预占"),
    OccupyFailed(4, "预占失败"),
    Canceled(5, "已取消"),
    CancelFailed(6, "取消失败"),
    Deducted(7, "已扣减"),
    DeductFailed(8, "扣减失败"),

    NoMatch(null, "未知的状态类型");

    private static final Map<Integer, StatusEnum> MAP = new HashMap<Integer, StatusEnum>();

    static {
        for (StatusEnum e : EnumSet.allOf(StatusEnum.class)) {
            MAP.put(e.getKey(), e);
        }
    }

    public static StatusEnum getByCode(Integer code) {
        return MAP.get(code) == null ? StatusEnum.getByCode(null) : MAP.get(code);
    }

    private Integer key;
    private String text;

    StatusEnum(Integer key, String text) {
        this.key = key;
        this.text = text;
    }

    public Integer getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public static void main(String[] args) {
        System.out.println(StatusEnum.getByCode(30).getText());
    }
}
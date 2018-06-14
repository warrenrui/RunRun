package others;

public class ConvertMethodName {

    /**
     * 转换一组字符串
     *
     * @param str
     * @return
     */
    public static String convertMethods(String str) {
        StringBuilder sb = new StringBuilder();
        String[] strings = str.split(",");
        for (String string : strings) {
            sb.append(convertMethod(string) + ",");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    /**
     * 转换单个字符串
     *
     * @param str
     * @return
     */
    public static String convertMethod(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.trim() + " as ");
        if (str.indexOf("_") > -1) {
            String[] strArr = str.split("_");
            for (int i = 0; i < strArr.length; i++) {
                if (i == 0) {
                    sb.append(strArr[i].trim().toLowerCase());
                } else {
                    sb.append(strArr[i].trim().substring(0, 1));
                    sb.append(strArr[i].trim().substring(1, strArr[i].trim().length()).toLowerCase());
                }
            }
        } else {
            sb.append(str.toLowerCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "IM_GOODS_ENTRY_ID,    CUSTOMS_CODE,     DP_APPR_MAN_3";
        System.out.println(convertMethods(a));
    }
}

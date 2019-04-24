package shortcut.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 字符串时间转换成时间戳
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public static long toTimestamp(String time) throws ParseException {
        return stringToDate(time).getTime();
    }

    /**
     * 字符串时间转换成日期格式
     *
     * @param value
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String value) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
    }

    /**
     * 时间戳转换成字符串格式
     *
     * @param timestamp
     * @return
     */
    public static String timestampToString(long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
    }


    public static void main(String[] args) throws ParseException {
        final long timeMillis = 1555668137133L;
        System.out.println(timestampToString(timeMillis));
        String time = "2019-4-19 01:43:23";
        System.out.println(toTimestamp(time));

        final Date date = new Date(toTimestamp(time));
        System.out.println(new SimpleDateFormat("HH").format(date));
    }

}

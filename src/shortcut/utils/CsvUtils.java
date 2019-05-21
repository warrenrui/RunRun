package shortcut.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * CSV文件帮助类
 */
public class CsvUtils {
    private static Logger logger = LoggerFactory.getLogger(CsvUtils.class);

    /**
     * 导出csv文件
     *
     * @param headers      内容标题
     *                     注意：headers类型是LinkedHashMap，保证遍历输出顺序和添加顺序一致。
     *                     而HashMap的话不保证添加数据的顺序和遍历出来的数据顺序一致，这样就出现
     *                     数据的标题不搭的情况的
     * @param exportData   要导出的数据集合
     * @param outputStream
     * @return
     */
    public static void exportCSV(LinkedHashMap<String, String> headers, List<LinkedHashMap<String, Object>> exportData, OutputStream outputStream) {
        BufferedWriter buffCvsWriter = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            // 编码gb2312，处理excel打开csv的时候会出现的标题中文乱码
            outputStreamWriter = new OutputStreamWriter(outputStream, "gb2312");
            buffCvsWriter = new BufferedWriter(outputStreamWriter);
            logger.error("start export to outputStream");
            long start = System.currentTimeMillis();
            // 写入cvs文件的头部
            Map.Entry propertyEntry = null;
            for (Iterator<Map.Entry<String, String>> propertyIterator = headers.entrySet().iterator(); propertyIterator.hasNext(); ) {
                propertyEntry = propertyIterator.next();
                buffCvsWriter.write("\"" + (propertyEntry.getValue() == null ? "" : propertyEntry.getValue().toString()) + "\"");
                if (propertyIterator.hasNext()) {
                    buffCvsWriter.write(",");
                }
            }
            buffCvsWriter.newLine();
            // 写入文件内容
            LinkedHashMap row = null;
            for (Iterator<LinkedHashMap<String, Object>> iterator = exportData.iterator(); iterator.hasNext(); ) {
                row = iterator.next();
                for (Iterator<Map.Entry> propertyIterator = row.entrySet().iterator(); propertyIterator.hasNext(); ) {
                    propertyEntry = propertyIterator.next();
                    buffCvsWriter.write("\"" + (propertyEntry.getValue() == null ? "" : propertyEntry.getValue().toString()) + "\"");
                    if (propertyIterator.hasNext()) {
                        buffCvsWriter.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    buffCvsWriter.newLine();
                }
            }
            // 记得刷新缓冲区，不然数可能会不全的，当然close的话也会flush的，不加也没问题
            buffCvsWriter.flush();
            logger.error("export to outputStream is done,elapse {} ms", System.currentTimeMillis() - start);
        } catch (IOException e) {
            logger.error("write outputStream error", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.error("关闭outputStream异常：{}", e.getMessage(), e);
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    logger.error("关闭outputStreamWriter异常：{}", e.getMessage(), e);
                }
            }
            if (buffCvsWriter != null) {
                try {
                    buffCvsWriter.close();
                } catch (IOException e) {
                    logger.error("关闭buffCvsWriter异常：{}", e.getMessage(), e);
                }
            }
        }
    }
}
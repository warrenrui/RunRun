package shortcut.sharding;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class shardingAlgorithm {
    /**
     * 切分2个库
     */
    private static final int DB_SHARDING_NUM = 2;
    /**
     * 每个库分64个表
     */
    private static final int TABLE_SHARDING_NUM = 64;

    public static void main(String[] args) {
        final HashMap<Long, Integer> dbMap = new HashMap<>();
        final HashMap<Long, Integer> tableMap = new HashMap<>();
//        long shardingValueNum = 4398059881082L;
//        sharding(dbMap, tableMap, shardingValueNum);

        final List<Long> longs = Arrays.asList(4398059881083L, 4398059881081L, 4398059881086L, 4398059881085L, 4398059881088L, 4398059881080L, 4398059881082L, 4398059881089L);
        for (Long l : longs) {
            sharding(dbMap, tableMap, l);
        }

//        for (int i = 0; i < 1000; i++) {
//            shardingValueNum = i;
//            sharding(dbMap, tableMap, shardingValueNum);
//        }


        System.out.println(JSON.toJSONString(dbMap));
        System.out.println(JSON.toJSONString(tableMap));
    }

    /**
     * 分库分表取模算法
     *
     * @param dbMap
     * @param tableMap
     * @param shardingValueNum
     */
    private static void sharding(HashMap<Long, Integer> dbMap, HashMap<Long, Integer> tableMap, long shardingValueNum) {
        final long temp = shardingValueNum % (DB_SHARDING_NUM * TABLE_SHARDING_NUM);
        final long dbId = temp / TABLE_SHARDING_NUM;
        final long tableId = temp % TABLE_SHARDING_NUM;
        System.out.println(shardingValueNum + " db:" + dbId + " table:" + tableId + " temp: " + temp);

        if (dbMap.containsKey(dbId)) {
            dbMap.put(dbId, dbMap.get(dbId) + 1);
        } else {
            dbMap.put(dbId, 1);
        }

        if (tableMap.containsKey(tableId)) {
            tableMap.put(tableId, tableMap.get(tableId) + 1);
        } else {
            tableMap.put(tableId, 1);
        }
    }
}

package shortcut.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class RegionMod {
    private static AtomicLong region_id = new AtomicLong(0);
    private static final int MaxRegionCount = 64;

    public static void main(String[] args) {
        // region分布
        for (int i = 0; i < 10000; i++) {
            System.out.println(getRegionNo());
        }
        // 服务实例覆盖region范围
        regionCover();
    }

    private static void regionCover() {
        for (int serverCount = 1; serverCount <= 10; serverCount++) {
            for (int curServer = 0; curServer < serverCount; curServer++) {
                modRegion(serverCount, curServer);
            }
            System.out.println("===========");
        }
    }

    private static void modRegion(int serverCount, int curServer) {
        List<Integer> regionList = new ArrayList<>();
        for (int i = 0; i < RegionMod.MaxRegionCount; i++) {
            if (isMyTask(i, serverCount, curServer)) {
                regionList.add(i);
            }
        }
        System.out.println("serverCount:" + serverCount + ",curServer:" + curServer + ",cover:" + JSON.toJSONString(regionList));
    }

    public static boolean isMyTask(int id, int queueCount, Integer curQueue) {
        int mod = Math.abs(id % queueCount);
        return mod == curQueue;
    }

    public static int getRegionNo() {
        int regionNo = 0;
        long id = RegionMod.region_id.addAndGet(1);
        regionNo = (int) id % RegionMod.MaxRegionCount;
        if (id > Long.MAX_VALUE - 100) {
            RegionMod.region_id.set(0);
        }
        return regionNo;
    }
}

package shortcut.concurrent;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ConcurrentInvoke {

    /**
     * 串行调用 + 并发调用
     *
     * @return
     */
    private Object serialInvoke() throws InterruptedException {
        final ArrayList<String> waitLocateXmlList = new ArrayList<>();
        final List<Object> Objects = new ArrayList<Object>();
        // 要调用的参数列表，切分成多个列表，每次进入并发的数量固定
        final List<List<String>> partition = Lists.partition(waitLocateXmlList, 100);
        long begin = System.currentTimeMillis();
        for (List<String> partitionWaitLocateXmlList : partition) {
            Objects.addAll(concurrentInvokeStock(partitionWaitLocateXmlList));
        }
//        logger.error("波次{}有{}次请求库存，总耗时: {} ms", waitLocateWave.getWaveNo(), waitLocateXmlList.size(), System.currentTimeMillis() - begin);
        return Objects;
    }

    /**
     * 多线程并发调用库存
     * <p>
     *
     * @param waitLocateXmlList
     * @return
     * @throws InterruptedException
     */
    private List<Object> concurrentInvokeStock(List<String> waitLocateXmlList) throws InterruptedException {
        List<Object> stockDetails = new ArrayList<Object>();
        final List<Object> synchronizedStockDetails = Collections.synchronizedList(stockDetails);
        final CountDownLatch doInvokeStock = new CountDownLatch(waitLocateXmlList.size());
        // 获取异常信息
        final String[] invokeStockErrorMsg = new String[1];
        for (final String waitLocateXml : waitLocateXmlList) {
            if (StringUtils.isBlank(waitLocateXml)) {
                doInvokeStock.countDown();
                continue;
            }
            ThreadPoolUtil.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        long begin = System.currentTimeMillis();
                        // webservice调用
//                        com.jd.wms.rpc.wms3message.clientbean.Result result = RequestStockWebService(LOCATEBIZTYPE, waitLocateXml);
//                        logger.error("线程：{}，波次{}其中一组请求库存耗时: {} ms", Thread.currentThread(), waitLocateWave.getWaveNo(), System.currentTimeMillis() - begin);
//                        OBOrder serviceResult = JSON.parseObject(result.getResultValue(), OBOrder.class);
//                        if (serviceResult == null) {
//                            throw new RuntimeException("库存服务返回NULL");
//                        }
//                        synchronizedStockDetails.addAll(serviceResult.getDetailMap().get(WMS3Constants.NO));
                    } catch (Exception e) {
//                        logger.error("线程" + Thread.currentThread() + "，波次" + waitLocateWave.getWaveNo() + "调用库存异常：" + e.getMessage(), e);
                        invokeStockErrorMsg[0] = e.getMessage();
                    } finally {
                        doInvokeStock.countDown();
                    }
                }
            });
        }
        try {
            doInvokeStock.await();
        } catch (InterruptedException e) {
//            logger.error(waitLocateWave.getWaveNo() + "调用库存多线程中断异常：" + e.getMessage(), e);
            throw e;
        }
        if (StringUtils.isNotBlank(invokeStockErrorMsg[0])) {
//            throw new RuntimeException(waitLocateWave.getWaveNo() + "调用库存异常：" + invokeStockErrorMsg[0]);
        }
        return stockDetails;
    }
}

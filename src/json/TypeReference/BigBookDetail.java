package json.TypeReference;


import java.util.Map;

/**
 * 大件预约--采购单明细档持久化对象
 * Created by nianguowei on 2015/8/14.
 */
public class BigBookDetail extends BookDetail{

    private Integer oldBookQty;


    /**
     * 是否装卸
     * */
    private Integer handSign;

    /**
     * eclp的事业部编号(目前暂时取sellerid)
     * */
    private String eclpDeptNo;

    /**
     * 占用配额的编码
     */
    private String quotaNo;

    /**
     * 声明价值
     * */
    private String poInsureMoney;

    /**
     * 商家类型
     * @see PurchaseTypeEnum
     * */
    private Integer purchaseType = 0;

    /**
     * 采购单维度下的品类预约数量集合
     * 主要在生成Locker时使用：按照采购单依次生成Locker数据
     */
    private Map<String, Integer> categoryMap;

    ///////////////////////////////////

    public Integer getOldBookQty() {
        return oldBookQty;
    }

    public void setOldBookQty(Integer oldBookQty) {
        this.oldBookQty = oldBookQty;
    }

    public Integer getHandSign() {
        return handSign;
    }

    public void setHandSign(Integer handSign) {
        this.handSign = handSign;
    }

    public String getEclpDeptNo() {
        return eclpDeptNo;
    }

    public void setEclpDeptNo(String eclpDeptNo) {
        this.eclpDeptNo = eclpDeptNo;
    }

    public String getQuotaNo() {
        return quotaNo;
    }

    public void setQuotaNo(String quotaNo) {
        if ( quotaNo == null || quotaNo == "" ) {
            quotaNo = "0";
        }
        this.quotaNo = quotaNo;
    }

    public String getPoInsureMoney() {
        return poInsureMoney;
    }

    public void setPoInsureMoney(String poInsureMoney) {
        this.poInsureMoney = poInsureMoney;
    }

    public Integer getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(Integer purchaseType) {
        this.purchaseType = purchaseType;
    }

    public Map<String, Integer> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<String, Integer> categoryMap) {
        this.categoryMap = categoryMap;
    }
}

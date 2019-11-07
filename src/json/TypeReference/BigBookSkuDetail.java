package json.TypeReference;


/**
 * @author nianguowei
 * @date 2015/8/14
 */
public class BigBookSkuDetail extends BookSkuDetail {

    /**
     * 预约单号
     */
    private String bookNo;

    /**
     * 确认前sku预约数量
     */
    private Integer oldBookQty;

    /**
     * 预约数量
     */
    private Integer bookQty;

    /**
     * 排队数量
     */
    private Integer queueQty;

    /**
     * 已经预约数量
     */
    private Integer bookedQty;

    /**
     * 实收数量
     */
    private Integer receiveQty;

    /**
     * 一级分类
     */
    private Integer categoryId1;

    /**
     * 二级分类
     */
    private Integer categoryId2;

    /**
     * 三级分类
     */
    private Integer categoryId3;

    /**
     * 入库分类Id
     */
    private String inWhCategoryId;

    /**
     * 标准预约量
     */
    private Integer categoryQty;

    /**
     * 历史
     */
    private Integer categoryBookedQty;

    /**
     * 标准预约量
     */
    private String standAppointmentQty;

    /**
     * 某品类最大预约量
     */
    private Integer maxGoodsQty;

    /**
     * 供应商编码
     */
    private String supNo;

    /**
     * 供应商名称
     */
    private String supName;

    /**
     * 预约的日期
     */
    private String bookDate;

    /**
     * 预约的时段
     */
    private String bookTimePeriod;

    /**
     * 采购单状态
     */
    private int status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 取消原因
     */
    private String reasonName;

    /**
     * 分批次标识(1:是 0:否)
     */
    private int batchSign;

    /**
     * 剩余可预约数量
     */
    private Integer canBookQty;

    private Integer checkScale;

    /**
     * 配送中心编码
     */
    private Integer dcNo;

    /**
     * 库房编码
     */
    private Integer whNo;

    /**
     * 是否紧急预约
     */
    private Integer isUrgent;

    private Integer autioQty;

    /**
     * 商家类型
     *
     * @see PurchaseTypeEnum
     */
    private Integer purchaseType = 0;


    //////////////////////////////////////////////////////////////////////////////////

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public Integer getOldBookQty() {
        return oldBookQty;
    }

    public void setOldBookQty(Integer oldBookQty) {
        this.oldBookQty = oldBookQty;
    }

    public Integer getBookQty() {
        return bookQty;
    }

    public void setBookQty(Integer bookQty) {
        this.bookQty = bookQty;
    }

    public Integer getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(Integer receiveQty) {
        this.receiveQty = receiveQty;
    }

    public Integer getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Integer categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Integer getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Integer categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Integer getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Integer categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public String getInWhCategoryId() {
        return inWhCategoryId;
    }

    public void setInWhCategoryId(String inWhCategoryId) {
        this.inWhCategoryId = inWhCategoryId;
    }

    public Integer getCategoryQty() {
        return categoryQty;
    }

    public void setCategoryQty(Integer categoryQty) {
        this.categoryQty = categoryQty;
    }

    public String getStandAppointmentQty() {
        return standAppointmentQty;
    }

    public void setStandAppointmentQty(String standAppointmentQty) {
        this.standAppointmentQty = standAppointmentQty;
    }

    public Integer getMaxGoodsQty() {
        return maxGoodsQty;
    }

    public void setMaxGoodsQty(Integer maxGoodsQty) {
        this.maxGoodsQty = maxGoodsQty;
    }

    public Integer getCategoryBookedQty() {
        return categoryBookedQty;
    }

    public void setCategoryBookedQty(Integer categoryBookedQty) {
        this.categoryBookedQty = categoryBookedQty;
    }

    public String getSupNo() {
        return supNo;
    }

    public void setSupNo(String supNo) {
        this.supNo = supNo;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getBookTimePeriod() {
        return bookTimePeriod;
    }

    public void setBookTimePeriod(String bookTimePeriod) {
        this.bookTimePeriod = bookTimePeriod;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public int getBatchSign() {
        return batchSign;
    }

    public void setBatchSign(int batchSign) {
        this.batchSign = batchSign;
    }

    public Integer getCanBookQty() {
        return canBookQty;
    }

    public void setCanBookQty(Integer canBookQty) {
        this.canBookQty = canBookQty;
    }

    public Integer getBookedQty() {
        return bookedQty;
    }

    public void setBookedQty(Integer bookedQty) {
        this.bookedQty = bookedQty;
    }

    public Integer getCheckScale() {
        return checkScale;
    }

    public void setCheckScale(Integer checkScale) {
        this.checkScale = checkScale;
    }

    public Integer getDcNo() {
        return dcNo;
    }

    public void setDcNo(Integer dcNo) {
        this.dcNo = dcNo;
    }

    public Integer getWhNo() {
        return whNo;
    }

    public void setWhNo(Integer whNo) {
        this.whNo = whNo;
    }

    public Integer getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(Integer isUrgent) {
        this.isUrgent = isUrgent;
    }

    public Integer getQueueQty() {
        return queueQty;
    }

    public void setQueueQty(Integer queueQty) {
        this.queueQty = queueQty;
    }

    public Integer getAutioQty() {
        return autioQty;
    }

    public void setAutioQty(Integer autioQty) {
        this.autioQty = autioQty;
    }

    public Integer getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(Integer purchaseType) {
        this.purchaseType = purchaseType;
    }
}

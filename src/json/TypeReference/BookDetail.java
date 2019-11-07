package json.TypeReference;


import java.io.Serializable;
import java.util.Date;

/**
 * 采购单明细档持久化对象
 *
 * @author dbwangshuang
 * @date 2015/8/7
 */
public class BookDetail extends BaseDomain implements Serializable {

    /**
     * 关联预约主档ID
     */
    private long bookID;

    /**
     * 如果需要拆单,由于需要重新生成映射关系,需要此属性记录原预约主档的外键,作为更新条件
     */
    private long oldBookID;

    /**
     * 预约单号
     */
    private String bookNo;

    /**
     * 采购单号
     */
    private String poNo;

    /**
     * 采购单状态
     */
    private int status;

    /**
     * 扩展字段(前置状态),该字段在数据库修改操作时可作为条件来控制并发
     */
    private int preStatus;

    /**
     * 采购数量
     */
    private int purchaseQty;

    /**
     * 供应商编码
     */
    private String supNo;

    /**
     * 供应商名称
     */
    private String supName;

    /**
     * 预约送货数量
     */
    private int bookQty;

    /**
     * 预约送货箱数
     */
    private int boxQty;

    /**
     * SKU数量
     */
    private int skuQty;

    /**
     * 预约的日期
     */
    private String bookDate;

    /**
     * 预约的时段
     */
    private String bookTimePeriod;

    /**
     * 采购员
     */
    private String buyer;

    /**
     * 采购员erp账号
     */
    private String buyerErpCode;

    /**
     * 所属部门ID
     */
    private String deptID;

    /**
     * 验收数量
     */
    private int receiveQty;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 到货时间
     */
    private Date arriveDate;

    /**
     * 收货开始时间
     */
    private Date receiveBeginTime;

    /**
     * 收货结束时间
     */
    private Date receiveEndTime;

    /**
     * 取消用户账号
     */
    private String cancelUserID;

    /**
     * 取消时间
     */
    private Date cancelTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 取消原因
     */
    private String reason;

    /**
     *
     */
    private String reasonName;


    /**
     * 排号时间
     */
    private Date queuingDate;

    /**
     * 排号方式
     */
    private String queuingMode;

    /**
     * 分批次标识(1:是 0:否)
     */
    private int batchSign;

    /**
     * 每个采购单下的商品明细
     */
    /*private List<? extends BookSkuDetail> skus;*/

    /**
     * 通道类型
     */
    private String channelType;

    /**
     * 签到人电话
     */
    private String registerTel;

    /**
     * 预约类型 : 0 人工预约  1 自动预约
     */
    private int bookSource;

    /**
     * 发货批次号
     */
    private String batchNo;


    ////////////////////////以下字段不保存到表中/////////////////////

    /**
     * 库区编号
     */
    private int whAreaNo;

    /**
     * 二级部门编号
     */
    private String groupID;

    /**
     * 是否使用了公共配额
     */
    private int useCommonQuota;

    /**
     * 实际占用配额所属部门编码
     */
    private String quotaDeptId;

    /**
     * 采购员所属一二三级部门编码路径，分号分隔， 可能为空，自营采购单才会有三级部门，ECLP则为null
     * 如： 000;111;222
     */
    private String orgCodePath;


    /**
     * 采购员所属一级部门, 不存于数据库中
     */
    private String oneLevelOrgCode;

    /**
     * 采购员所属二级部门, 不存于数据库中
     */
    private String twoLevleOrgCode;

    /**
     * 采购员所属三级部门， 可能为空
     */
    private String threeLevelOrgCode;

    /**
     * 配送中心
     */
    private Integer dcNo;

    /**
     * 库房
     */
    private Integer whNo;

    /**
     * 是否图书新品 1是0否
     */
    private Integer newBookFlag;

    /**
     * 是否占用配额 1是0否
     */
    private Integer occupyQuotaFlag;
    /**
     * 预约添加时所用单号
     */
    private String addNo;

    /**
     * 单号类型
     */
    private Integer addNoType;

    //////////////////////////////////////////

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
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

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getBuyerErpCode() {
        return buyerErpCode;
    }

    public void setBuyerErpCode(String buyerErpCode) {
        this.buyerErpCode = buyerErpCode;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public int getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(int receiveQty) {
        this.receiveQty = receiveQty;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public Date getReceiveBeginTime() {
        return receiveBeginTime;
    }

    public void setReceiveBeginTime(Date receiveBeginTime) {
        this.receiveBeginTime = receiveBeginTime;
    }

    public Date getReceiveEndTime() {
        return receiveEndTime;
    }

    public void setReceiveEndTime(Date receiveEndTime) {
        this.receiveEndTime = receiveEndTime;
    }

    public String getCancelUserID() {
        return cancelUserID;
    }

    public void setCancelUserID(String cancelUserID) {
        this.cancelUserID = cancelUserID;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getUseCommonQuota() {
        return useCommonQuota;
    }

    public void setUseCommonQuota(int useCommonQuota) {
        this.useCommonQuota = useCommonQuota;
    }

    public Date getQueuingDate() {
        return queuingDate;
    }

    public void setQueuingDate(Date queuingDate) {
        this.queuingDate = queuingDate;
    }

    public String getQueuingMode() {
        return queuingMode;
    }

    public void setQueuingMode(String queuingMode) {
        this.queuingMode = queuingMode;
    }

    public int getBatchSign() {
        return batchSign;
    }

    public void setBatchSign(int batchSign) {
        this.batchSign = batchSign;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPurchaseQty() {
        return purchaseQty;
    }

    public void setPurchaseQty(int purchaseQty) {
        this.purchaseQty = purchaseQty;
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

    public int getBookQty() {
        return bookQty;
    }

    public void setBookQty(int bookQty) {
        this.bookQty = bookQty;
    }

    public int getBoxQty() {
        return boxQty;
    }

    public void setBoxQty(int boxQty) {
        this.boxQty = boxQty;
    }

    public int getSkuQty() {
        return skuQty;
    }

    public void setSkuQty(int skuQty) {
        this.skuQty = skuQty;
    }

	/*public List<? extends BookSkuDetail> getSkus () {
		return skus;
	}

	public void setSkus (List<? extends BookSkuDetail> skus) {
		this.skus = skus;
	}*/

    public int getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(int preStatus) {
        this.preStatus = preStatus;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public long getOldBookID() {
        return oldBookID;
    }

    public void setOldBookID(long oldBookID) {
        this.oldBookID = oldBookID;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getRegisterTel() {
        return registerTel;
    }

    public void setRegisterTel(String registerTel) {
        this.registerTel = registerTel;
    }

    public int getBookSource() {
        return bookSource;
    }

    public void setBookSource(int bookSource) {
        this.bookSource = bookSource;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getQuotaDeptId() {
        return quotaDeptId;
    }

    public void setQuotaDeptId(String quotaDeptId) {
        this.quotaDeptId = quotaDeptId;
    }

    public String getOrgCodePath() {
        return orgCodePath;
    }


    public String getOneLevelOrgCode() {
        return oneLevelOrgCode;
    }

    public void setOneLevelOrgCode(String oneLevelOrgCode) {
        this.oneLevelOrgCode = oneLevelOrgCode;
    }

    public String getTwoLevleOrgCode() {
        return twoLevleOrgCode;
    }

    public void setTwoLevleOrgCode(String twoLevleOrgCode) {
        this.twoLevleOrgCode = twoLevleOrgCode;
    }

    public String getThreeLevelOrgCode() {
        return threeLevelOrgCode;
    }

    public void setThreeLevelOrgCode(String threeLevelOrgCode) {
        this.threeLevelOrgCode = threeLevelOrgCode;
    }

    public int getWhAreaNo() {
        return whAreaNo;
    }

    public void setWhAreaNo(int whAreaNo) {
        this.whAreaNo = whAreaNo;
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

    public Integer getNewBookFlag() {
        return newBookFlag == null ? 0 : newBookFlag;
    }

    public void setNewBookFlag(Integer newBookFlag) {
        this.newBookFlag = newBookFlag;
    }

    public Integer getOccupyQuotaFlag() {
        return occupyQuotaFlag == null ? 1 : occupyQuotaFlag;
    }

    public void setOccupyQuotaFlag(Integer occupyQuotaFlag) {
        this.occupyQuotaFlag = occupyQuotaFlag;
    }

    public String getAddNo() {
        return addNo;
    }

    public void setAddNo(String addNo) {
        this.addNo = addNo;
    }

    public Integer getAddNoType() {
        return addNoType;
    }

    public void setAddNoType(Integer addNoType) {
        this.addNoType = addNoType;
    }

    public void setOrgCodePath(String orgCodePath) {
        this.orgCodePath = orgCodePath;
    }
}

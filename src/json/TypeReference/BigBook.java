package json.TypeReference;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author nianguowei
 * @date 2015/8/14
 */
public class BigBook extends Book<BigBookDetail> {

    private List<BigBookSkuDetail> bigBookSkuDetails;

    public List<BigBookSkuDetail> getBigBookSkuDetails() {
        return bigBookSkuDetails;
    }

    public void setBigBookSkuDetails(List<BigBookSkuDetail> bigBookSkuDetails) {
        this.bigBookSkuDetails = bigBookSkuDetails;
    }

    /**
     * 实际占用的部门编号
     */
    private String occupyDeptID;

    /**
     * 实际占用的二级部门编号
     */
    private String occupyGroupID;

    private Integer handSign;

    /**
     * 创建用户的真实姓名
     */
    private String createUserName;

    //库房电话
    private String phone;

    private String reasonName;

    //货主名称
    private String ownerName;
    //货主编号
    private String ownerNo;

    //司机电话
    private String driverTel;
    /**
     * 签到人电话
     */
    private String registerTel;

    private String operator;

    private String instoreDate;

    /**
     * 排队号
     */
    private String queueNo;

    ///////////////////////////////////////////////////////////

    private Map<String, Integer> cateoryQtyCurMapped;

    private String failureReason;

    private Date firstQueueTime;

    private boolean isQueue;

    private Integer purchaseQty;

    private String supName;

    private String poNo;

    /**
     * 是否来自于大件TC自动预约
     */
    private Boolean isFromTc = false;

    /**
     * 预约数量，减去大件赠品后的数量
     */
    private int bookQuantity;

    /**
     * 赠品Sku列表
     */
    private List<String> giftSkuList;

    /**
     * 来源 现在大件预约来源只有：0手动 3供应商自动
     */
    private Integer bookSource = 0;

    /**
     * 待审核号
     */
    private String adoptNo;

    /**
     * 超量预约记录
     */
    private Integer beyondBookFlag;

    private Integer restBookQty;

    private boolean isEclp;

    ///////////////////////////////////////////////////////////

    @Override
    public String getOccupyDeptID() {
        return occupyDeptID;
    }

    @Override
    public void setOccupyDeptID(String occupyDeptID) {
        this.occupyDeptID = occupyDeptID;
    }

    @Override
    public String getOccupyGroupID() {
        return occupyGroupID;
    }

    @Override
    public void setOccupyGroupID(String occupyGroupID) {
        this.occupyGroupID = occupyGroupID;
    }

    public Integer getHandSign() {
        return handSign;
    }

    public void setHandSign(Integer handSign) {
        this.handSign = handSign;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerNo() {
        return ownerNo;
    }

    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo;
    }

    public String getDriverTel() {
        return driverTel;
    }

    public void setDriverTel(String driverTel) {
        this.driverTel = driverTel;
    }

    public String getRegisterTel() {
        return registerTel;
    }

    public void setRegisterTel(String registerTel) {
        this.registerTel = registerTel;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getInstoreDate() {
        return instoreDate;
    }

    public void setInstoreDate(String instoreDate) {
        this.instoreDate = instoreDate;
    }

    @Override
    public String getQueueNo() {
        return queueNo;
    }

    @Override
    public void setQueueNo(String queueNo) {
        this.queueNo = queueNo;
    }

    public Map<String, Integer> getCateoryQtyCurMapped() {
        return cateoryQtyCurMapped;
    }

    public void setCateoryQtyCurMapped(Map<String, Integer> cateoryQtyCurMapped) {
        this.cateoryQtyCurMapped = cateoryQtyCurMapped;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Date getFirstQueueTime() {
        return firstQueueTime;
    }

    public void setFirstQueueTime(Date firstQueueTime) {
        this.firstQueueTime = firstQueueTime;
    }

    public boolean isQueue() {
        return isQueue;
    }

    public void setQueue(boolean queue) {
        isQueue = queue;
    }

    public Integer getPurchaseQty() {
        return purchaseQty;
    }

    public void setPurchaseQty(Integer purchaseQty) {
        this.purchaseQty = purchaseQty;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public Boolean getFromTc() {
        return isFromTc;
    }

    public void setFromTc(Boolean fromTc) {
        isFromTc = fromTc;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public List<String> getGiftSkuList() {
        return giftSkuList;
    }

    public void setGiftSkuList(List<String> giftSkuList) {
        this.giftSkuList = giftSkuList;
    }

    public Integer getBookSource() {
        return bookSource;
    }

    public void setBookSource(Integer bookSource) {
        this.bookSource = bookSource;
    }

    public String getAdoptNo() {
        return adoptNo;
    }

    public void setAdoptNo(String adoptNo) {
        this.adoptNo = adoptNo;
    }

    public Integer getBeyondBookFlag() {
        return beyondBookFlag;
    }

    public void setBeyondBookFlag(Integer beyondBookFlag) {
        this.beyondBookFlag = beyondBookFlag;
    }

    public Integer getRestBookQty() {
        return restBookQty;
    }

    public void setRestBookQty(Integer restBookQty) {
        this.restBookQty = restBookQty;
    }

    public boolean isEclp() {
        return isEclp;
    }

    public void setEclp(boolean eclp) {
        isEclp = eclp;
    }
}

package json.TypeReference;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 预约业务主档对象
 * Created by dbwangshuang on 2015/8/7.
 */
public class Book<T extends BookDetail> extends BaseDomain {

    private List<T> bookDetails;
    /**
     * 机构编码
     */
    private Integer orgNo;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 配送中心编码
     */
    private Integer dcNo;

    /**
     * 配送中心名称
     */
    private String dcName;

    /**
     * 库房编码
     */
    private Integer whNo;

    /**
     * 库房名称
     */
    private String whName;

    /**
     * 预约单号
     */
    private String bookNo;

    /**
     * 预约的日期
     */
    private String bookDate;

    /**
     * 预约的时段
     */
    private String bookTimePeriod;

    /**
     * 预约业务发生时间
     */
    private Date bookTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否为紧急预约（0：否 1：是）
     */
    private int isUrgent;

    /**
     * 预约主档状态(1：保存 2：预约 3：取消 100:删除 99：待审核
     */
    private int status;

    /**
     * 扩展字段(前置状态),该字段在数据库修改操作时可作为条件来控制并发
     */
    private int preStatus;

    private String carrier;

    private String carrierTel;

    /**
     * 库房地址
     */
    private String address;

    /**
     * 预约采购单的总数
     */
    private int bookQty;

    /**
     * 业务创建人是否为本人的标识(1:是 0:否)
     */
    private int self;



    /**
     * 部门预约数量的map，key=部门id+库区编号，value=预约数量,用于取消预约
     */
    private Map<String, Integer> deptCancelBookMap;


    /**
     * 小件采购单所属采销员所属部门id集合,
     */
    private Set<String> deptIds;

    /**
     * 采购单占用配额对应部门map，key=采购单号,value=占用配额的部门编码
     */
    private Map<String, String> poDeptLockerMap;


    /**
     * 实际占用的部门编号
     */
    private String occupyDeptID;

    /**
     * 实际占用的二级部门编号
     */
    private String occupyGroupID;

    /**
     * 上传的发货清单URL
     */
    private String shippingListUrl;

    //////////////////////////////////////////////

    private List<String> poList;

    Map<String, String> manageTypeMap;

    /*List<QuotaInfoWrapper> quotaList;*/

    Map<String, Integer> bookedMap;

    Integer source;


    private String tcCode;

    private String tcName;

    /**
     * 排队号
     */
    private String queueNo;

    //配额部门类型
    private Integer deptType;

    public int getSelf() {
        return self;
    }

    public void setSelf(int self) {
        this.self = self;
    }

    public Integer getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(Integer orgNo) {
        this.orgNo = orgNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getDcNo() {
        return dcNo;
    }

    public void setDcNo(Integer dcNo) {
        this.dcNo = dcNo;
    }

    public String getDcName() {
        return dcName;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public Integer getWhNo() {
        return whNo;
    }

    public void setWhNo(Integer whNo) {
        this.whNo = whNo;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
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

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(int isUrgent) {
        this.isUrgent = isUrgent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrierTel() {
        return carrierTel;
    }

    public void setCarrierTel(String carrierTel) {
        this.carrierTel = carrierTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<T> getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(List<T> bookDetails) {
        this.bookDetails = bookDetails;
    }

    public int getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(int preStatus) {
        this.preStatus = preStatus;
    }

    public int getBookQty() {
        return bookQty;
    }

    public void setBookQty(int bookQty) {
        this.bookQty = bookQty;
    }

    public Map<String, Integer> getDeptCancelBookMap() {
        return deptCancelBookMap;
    }

    public void setDeptCancelBookMap(Map<String, Integer> deptCancelBookMap) {
        this.deptCancelBookMap = deptCancelBookMap;
    }

    public Set<String> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(Set<String> deptIds) {
        this.deptIds = deptIds;
    }

    public Map<String, String> getPoDeptLockerMap() {
        return poDeptLockerMap;
    }

    public void setPoDeptLockerMap(Map<String, String> poDeptLockerMap) {
        this.poDeptLockerMap = poDeptLockerMap;
    }

    public String getOccupyDeptID() {
        return occupyDeptID;
    }

    public void setOccupyDeptID(String occupyDeptID) {
        this.occupyDeptID = occupyDeptID;
    }

    public String getOccupyGroupID() {
        return occupyGroupID;
    }

    public void setOccupyGroupID(String occupyGroupID) {
        this.occupyGroupID = occupyGroupID;
    }

    public Map<String, String> getManageTypeMap() {
        return manageTypeMap;
    }

    public void setManageTypeMap(Map<String, String> manageTypeMap) {
        this.manageTypeMap = manageTypeMap;
    }

	/*public List<QuotaInfoWrapper> getQuotaList() {
		return quotaList;
	}

	public void setQuotaList(List<QuotaInfoWrapper> quotaList) {
		this.quotaList = quotaList;
	}*/

    public Map<String, Integer> getBookedMap() {
        return bookedMap;
    }

    public void setBookedMap(Map<String, Integer> bookedMap) {
        this.bookedMap = bookedMap;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getShippingListUrl() {
        return shippingListUrl;
    }

    public void setShippingListUrl(String shippingListUrl) {
        this.shippingListUrl = shippingListUrl;
    }


    public List<String> getPoList() {
        return poList;
    }

    public void setPoList(List<String> poList) {
        this.poList = poList;
    }

    public String getTcCode() {
        return tcCode;
    }

    public void setTcCode(String tcCode) {
        this.tcCode = tcCode;
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public String getQueueNo() {
        return queueNo;
    }

    public void setQueueNo(String queueNo) {
        this.queueNo = queueNo;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }
}

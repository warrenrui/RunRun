package json.TypeReference;

import java.io.Serializable;
import java.util.Date;

/**
 * User: zhaizhangquan
 */
public class BookLocker extends BaseDomain implements Serializable {

    /**
     * 库房编号
     */
    private Integer dcNo;

    private Integer whNo;

    private String bookDateString;

    private String bookTimeString;

    private int status;

    private Date lockTime;

    /**
     * 该维度的最大可预约数量(配额)
     */
    private int produceCapacityInPeriod;

    /**
     * 已预约的送货数量
     */
    private int bookedQty;

    /**
     * 本次要预约的送货数量
     */
    private int willBookQty;

    /**
     * 要减少的配额
     */
    private int decrementQty;

    private int bookedQuantity;

    /**
     * 最大可预约数量
     */
    private int maxQty;

    /**
     * 占用的部门id
     */
    private String deptId;

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

    public String getBookDateString() {
        return bookDateString;
    }

    public void setBookDateString(String bookDateString) {
        this.bookDateString = bookDateString;
    }

    public String getBookTimeString() {
        return bookTimeString;
    }

    public void setBookTimeString(String bookTimeString) {
        this.bookTimeString = bookTimeString;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public int getProduceCapacityInPeriod() {
        return produceCapacityInPeriod;
    }

    public void setProduceCapacityInPeriod(int produceCapacityInPeriod) {
        this.produceCapacityInPeriod = produceCapacityInPeriod;
    }

    public int getBookedQty() {
        return bookedQty;
    }

    public void setBookedQty(int bookedQty) {
        this.bookedQty = bookedQty;
    }

    public int getWillBookQty() {
        return willBookQty;
    }

    public void setWillBookQty(int willBookQty) {
        this.willBookQty = willBookQty;
    }

    public int getDecrementQty() {
        return decrementQty;
    }

    public void setDecrementQty(int decrementQty) {
        this.decrementQty = decrementQty;
    }

    public int getBookedQuantity() {
        return bookedQuantity;
    }

    public void setBookedQuantity(int bookedQuantity) {
        this.bookedQuantity = bookedQuantity;
    }

    public int getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(int maxQty) {
        this.maxQty = maxQty;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}

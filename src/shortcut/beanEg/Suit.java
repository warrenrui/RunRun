package shortcut.beanEg;

import java.util.ArrayList;
import java.util.List;

public class Suit {
    /**
     * 组套编号 主键 自增
     */
    private String id;

    /**
     * 组套名称
     */
    private String name;

    /**
     * 组套类型
     */
    private Integer type;

    /**
     * 商品编号
     */
    private String skuId;

    /**
     * 创建人账号
     */
    private String operator;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否有效
     */
    private Integer yn;

    //创建人
    private String createName;
    //更新人
    private String updateName;
    //创建时间
    private String createDate;
    //修改时间
    private String updateDate;

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    private List<SuitProduct> suitProductList = new ArrayList<SuitProduct>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public List<SuitProduct> getSuitProductList() {
        return suitProductList;
    }

    public void setSuitProductList(List<SuitProduct> suitProductList) {
        this.suitProductList = suitProductList;
    }
}

package shortcut.beanEg;

import java.math.BigDecimal;


public class SuitProduct {
    /**
     * 主键 自增
     */
    private Long id;

    /**
     * 商品编号
     */
    private String skuId;

    /**
     * 组套编号
     */
    private String suitId;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 拆分价
     */
    private BigDecimal splitPrice;

    /**
     * 显示状态
     */
    private Integer showState;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getSplitPrice() {
        return splitPrice;
    }

    public void setSplitPrice(BigDecimal splitPrice) {
        this.splitPrice = splitPrice;
    }

    public Integer getShowState() {
        return showState;
    }

    public void setShowState(Integer showState) {
        this.showState = showState;
    }

    public String getSuitId() {
        return suitId;
    }

    public void setSuitId(String suitId) {
        this.suitId = suitId;
    }

}

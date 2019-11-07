package json.TypeReference;

import java.io.Serializable;

/**
 * 预约采购单商品明细
 * Created by dbwangshuang on 2015/8/11.
 */
public class BookSkuDetail extends BaseDomain implements Serializable {
	/**
	 * 对应采购单明细ID
	 */
	private long bookDetailID;


	/**
	 * 采购单号
	 */
	private String poNo;

	/**
	 * 商品编码
	 */
	private String goodsNo;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 采购数量
	 */
	private int purchaseQty;

	public long getBookDetailID () {
		return bookDetailID;
	}

	public void setBookDetailID (long bookDetailID) {
		this.bookDetailID = bookDetailID;
	}

	public String getPoNo () {
		return poNo;
	}

	public void setPoNo (String poNo) {
		this.poNo = poNo;
	}

	public String getGoodsNo () {
		return goodsNo;
	}

	public void setGoodsNo (String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsName () {
		return goodsName;
	}

	public void setGoodsName (String goodsName) {
		this.goodsName = goodsName;
	}

	public int getPurchaseQty () {
		return purchaseQty;
	}

	public void setPurchaseQty (int purchaseQty) {
		this.purchaseQty = purchaseQty;
	}
}

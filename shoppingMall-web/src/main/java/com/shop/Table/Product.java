package com.shop.Table;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 产品信息.
 * 
 * @author
 * @version $Revision:$
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * PRODUCT.Id 主键.
	 */
	private String Id;
	/**
	 * PRODUCT.productNum 产品编号.
	 */
	private String productNum;
	/**
	 * PRODUCT.productName 产品名称.
	 */
	private String productName;
	/**
	 * PRODUCT.cityName 出发城市.
	 */
	private String cityName;
	/**
	 * PRODUCT.departureTime 出发时间.
	 */
	private String departureTime;
	/**
	 * PRODUCT.productPrice 产品价格.
	 */
	private BigDecimal productPrice;
	/**
	 * PRODUCT.productDesc 产品描述.
	 */
	private String productDesc;
	/**
	 * PRODUCT.productStatus 产品状态.
	 */
	private String productStatus;
	/**
	 * @return the Id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String Id) {
		this.Id = Id;
	}
	/**
	 * @return the productNum
	 */
	public String getProductNum() {
		return productNum;
	}
	/**
	 * @param productNum the productNum to set
	 */
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	/**
	 * @return the productPrice
	 */
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}
	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	/**
	 * @return the productStatus
	 */
	public String getProductStatus() {
		return productStatus;
	}
	/**
	 * @param productStatus the productStatus to set
	 */
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}



	@Override
	public String toString() {
		return "Product [Id=" + Id + ", productNum=" + productNum + ", productName=" + productName + ", cityName=" + cityName + ", departureTime=" + departureTime
				+ ", productPrice=" + productPrice + ", productDesc=" + productDesc + ", productStatus=" + productStatus + "]";
	}
}
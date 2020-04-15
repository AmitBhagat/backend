package com.dalrada.upload.intg.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable{
	
	private static final long serialVersionUID = 2513285264539776456L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long srNo ;
	@Column
	private String orderDate;
	@Column
	private String storeOrderId;
	@Column
	private String orderNumber;
	@Column
	private String poNumber;
	@Column
	private String referenceNumber;
	@Column
	private String channelName;
	@Column
	private String orderStatus;
	@Column
	private String sku;
	@Column
	private String productName;
	@Column
	private long quantity;
	@Column
	private double supplierCostPerSKU;
	@Column
	private double salePrice;
	@Column
	private double supplierCostTotal;
	@Column
	private double orderTotal;
	@Column
	private String supplierName;
	@Column
	private String storeShippingMethod;
	@Column
	private String shippingCarrier;
	@Column
	private String shippingMethod;
	@Column(length = 500)
	private String trackingNumbers;
	@Column
	private String customerName;
	@Column
	private String customerEmail;
	@Column
	private String customerPhone;
	@Column
	private String addressLine1;
	@Column
	private String addressLine2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zip;
	@Column
	private String country;
	@Column
	private String company;
	public Long getSrNo() {
		return srNo;
	}
	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getStoreOrderId() {
		return storeOrderId;
	}
	public void setStoreOrderId(String storeOrderId) {
		this.storeOrderId = storeOrderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getSupplierCostPerSKU() {
		return supplierCostPerSKU;
	}
	public void setSupplierCostPerSKU(double supplierCostPerSKU) {
		this.supplierCostPerSKU = supplierCostPerSKU;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public double getSupplierCostTotal() {
		return supplierCostTotal;
	}
	public void setSupplierCostTotal(double supplierCostTotal) {
		this.supplierCostTotal = supplierCostTotal;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getStoreShippingMethod() {
		return storeShippingMethod;
	}
	public void setStoreShippingMethod(String storeShippingMethod) {
		this.storeShippingMethod = storeShippingMethod;
	}
	public String getShippingCarrier() {
		return shippingCarrier;
	}
	public void setShippingCarrier(String shippingCarrier) {
		this.shippingCarrier = shippingCarrier;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getTrackingNumbers() {
		return trackingNumbers;
	}
	public void setTrackingNumbers(String trackingNumbers) {
		this.trackingNumbers = trackingNumbers;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetails [srNo=").append(srNo).append(", orderDate=").append(orderDate)
				.append(", storeOrderId=").append(storeOrderId).append(", orderNumber=").append(orderNumber)
				.append(", poNumber=").append(poNumber).append(", referenceNumber=").append(referenceNumber)
				.append(", channelName=").append(channelName).append(", orderStatus=").append(orderStatus)
				.append(", sku=").append(sku).append(", productName=").append(productName).append(", quantity=")
				.append(quantity).append(", supplierCostPerSKU=").append(supplierCostPerSKU).append(", salePrice=")
				.append(salePrice).append(", supplierCostTotal=").append(supplierCostTotal).append(", orderTotal=")
				.append(orderTotal).append(", supplierName=").append(supplierName).append(", storeShippingMethod=")
				.append(storeShippingMethod).append(", shippingCarrier=").append(shippingCarrier)
				.append(", shippingMethod=").append(shippingMethod).append(", trackingNumbers=").append(trackingNumbers)
				.append(", customerName=").append(customerName).append(", customerEmail=").append(customerEmail)
				.append(", customerPhone=").append(customerPhone).append(", addressLine1=").append(addressLine1)
				.append(", addressLine2=").append(addressLine2).append(", city=").append(city).append(", state=")
				.append(state).append(", zip=").append(zip).append(", country=").append(country).append(", company=")
				.append(company).append("]");
		return builder.toString();
	}
}

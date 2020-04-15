package com.dalrada.reconcile.process.beans;

/**
 * @author Sneha
 *
 */
public class ProcessResponseBody {
	
	private Long srNo ;
	private Double extNetUnit ;
	private String orderDate;
	private String storeOrderId;
	private String orderNumber;
	private String poNumber;
	private String referenceNumber;
	private String channelName;
	private String orderStatus;
	private String sku;
	private String productName;
	private Long quantity;
	private Double supplierCostPerSKU;
	private Double salePrice;
	private Double amazonAmount;
	private Double profit;
	private Double avgProfit;
	private Double roi;
	private Double supplierCostTotal;
	private Double orderTotal;
	private String supplierName;
	private String storeShippingMethod;
	private String shippingCarrier;
	private String shippingMethod;
	private String trackingNumbers;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String company;
	public Long getSrNo() {
		return srNo;
	}
	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}
	public Double getExtNetUnit() {
		return extNetUnit;
	}
	public void setExtNetUnit(Double extNetUnit) {
		this.extNetUnit = extNetUnit;
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
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
	public Double getAmazonAmount() {
		return amazonAmount;
	}
	public void setAmazonAmount(Double amazonAmount) {
		this.amazonAmount = amazonAmount;
	}
	public Double getProfit() {
		return profit;
	}
	public void setProfit(Double profit) {
		this.profit = profit;
	}
	public Double getAvgProfit() {
		return avgProfit;
	}
	public void setAvgProfit(Double avgProfit) {
		this.avgProfit = avgProfit;
	}
	public Double getRoi() {
		return roi;
	}
	public void setRoi(Double roi) {
		this.roi = roi;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getSupplierCostPerSKU() {
		return supplierCostPerSKU;
	}
	public void setSupplierCostPerSKU(Double supplierCostPerSKU) {
		this.supplierCostPerSKU = supplierCostPerSKU;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Double getSupplierCostTotal() {
		return supplierCostTotal;
	}
	public void setSupplierCostTotal(Double supplierCostTotal) {
		this.supplierCostTotal = supplierCostTotal;
	}
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcessResponseBody [srNo=").append(srNo).append(", extNetUnit=").append(extNetUnit)
				.append(", orderDate=").append(orderDate).append(", storeOrderId=").append(storeOrderId)
				.append(", orderNumber=").append(orderNumber).append(", poNumber=").append(poNumber)
				.append(", referenceNumber=").append(referenceNumber).append(", channelName=").append(channelName)
				.append(", orderStatus=").append(orderStatus).append(", sku=").append(sku).append(", productName=")
				.append(productName).append(", quantity=").append(quantity).append(", supplierCostPerSKU=")
				.append(supplierCostPerSKU).append(", salePrice=").append(salePrice).append(", amazonAmount=")
				.append(amazonAmount).append(", profit=").append(profit).append(", avgProfit=").append(avgProfit)
				.append(", roi=").append(roi).append(", supplierCostTotal=").append(supplierCostTotal)
				.append(", orderTotal=").append(orderTotal).append(", supplierName=").append(supplierName)
				.append(", storeShippingMethod=").append(storeShippingMethod).append(", shippingCarrier=")
				.append(shippingCarrier).append(", shippingMethod=").append(shippingMethod).append(", trackingNumbers=")
				.append(trackingNumbers).append(", customerName=").append(customerName).append(", customerEmail=")
				.append(customerEmail).append(", customerPhone=").append(customerPhone).append(", addressLine1=")
				.append(addressLine1).append(", addressLine2=").append(addressLine2).append(", city=").append(city)
				.append(", state=").append(state).append(", zip=").append(zip).append(", country=").append(country)
				.append(", company=").append(company).append("]");
		return builder.toString();
	}
}

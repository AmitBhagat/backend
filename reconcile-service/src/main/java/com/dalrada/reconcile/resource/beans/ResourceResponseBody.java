package com.dalrada.reconcile.resource.beans;

/**
 * @author Sneha
 *
 */
public class ResourceResponseBody {

	private Long srNo ;
	private String extNetUnit ;
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
	private String supplierCostPerSKU;
	private String salePrice;
	private String amazonAmount;
	private String profit;
	private String avgProfit;
	private String roi;
	private String supplierCostTotal;
	private String orderTotal;
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

	public String getExtNetUnit() {
		return extNetUnit;
	}

	public void setExtNetUnit(String extNetUnit) {
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

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getSupplierCostPerSKU() {
		return supplierCostPerSKU;
	}

	public void setSupplierCostPerSKU(String supplierCostPerSKU) {
		this.supplierCostPerSKU = supplierCostPerSKU;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getAmazonAmount() {
		return amazonAmount;
	}

	public void setAmazonAmount(String amazonAmount) {
		this.amazonAmount = amazonAmount;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getAvgProfit() {
		return avgProfit;
	}

	public void setAvgProfit(String avgProfit) {
		this.avgProfit = avgProfit;
	}

	public String getRoi() {
		return roi;
	}

	public void setRoi(String roi) {
		this.roi = roi;
	}

	public String getSupplierCostTotal() {
		return supplierCostTotal;
	}

	public void setSupplierCostTotal(String supplierCostTotal) {
		this.supplierCostTotal = supplierCostTotal;
	}

	public String getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(String orderTotal) {
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
		builder.append(srNo).append(", ").append(extNetUnit)
				.append(",").append(orderDate).append(",").append(storeOrderId)
				.append(",").append(orderNumber).append(",").append(poNumber)
				.append(",").append(referenceNumber).append(",").append(channelName)
				.append(",").append(orderStatus).append(",").append(sku).append(",\"")
				.append(productName).append("\",").append(quantity).append(",")
				.append(supplierCostPerSKU).append(",").append(salePrice).append(",")
				.append(amazonAmount).append(",").append(profit).append(",").append(avgProfit)
				.append(",").append(roi).append(",").append(supplierCostTotal)
				.append(",").append(orderTotal).append(",").append(supplierName)
				.append(",").append(storeShippingMethod).append(",")
				.append(shippingCarrier).append(",").append(shippingMethod).append(",\"")
				.append(trackingNumbers).append("\",").append(customerName).append(", ")
				.append(customerEmail).append(",").append(customerPhone).append(",")
				.append(addressLine1).append(",").append(addressLine2).append(",").append(city)
				.append(",").append(state).append(",").append(zip).append(",").append(country)
				.append(",").append(company);
		return builder.toString();
	}
}

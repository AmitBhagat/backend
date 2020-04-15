package com.dalrada.reconcile.integration.beans;

public class IntgResponseBody {
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
	private Double salePrice;
	private Double supplierCostPerSKU;
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
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Double getSupplierCostPerSKU() {
		return supplierCostPerSKU;
	}
	public void setSupplierCostPerSKU(Double supplierCostPerSKU) {
		this.supplierCostPerSKU = supplierCostPerSKU;
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
		builder.append("IntgResponseBody [srNo=").append(srNo).append(", extNetUnit=").append(extNetUnit)
				.append(", orderDate=").append(orderDate).append(", storeOrderId=").append(storeOrderId)
				.append(", orderNumber=").append(orderNumber).append(", poNumber=").append(poNumber)
				.append(", referenceNumber=").append(referenceNumber).append(", channelName=").append(channelName)
				.append(", orderStatus=").append(orderStatus).append(", sku=").append(sku).append(", productName=")
				.append(productName).append(", quantity=").append(quantity).append(", salePrice=").append(salePrice)
				.append(", supplierCostPerSKU=").append(supplierCostPerSKU).append(", supplierCostTotal=")
				.append(supplierCostTotal).append(", orderTotal=").append(orderTotal).append(", supplierName=")
				.append(supplierName).append(", storeShippingMethod=").append(storeShippingMethod)
				.append(", shippingCarrier=").append(shippingCarrier).append(", shippingMethod=").append(shippingMethod)
				.append(", trackingNumbers=").append(trackingNumbers).append(", customerName=").append(customerName)
				.append(", customerEmail=").append(customerEmail).append(", customerPhone=").append(customerPhone)
				.append(", addressLine1=").append(addressLine1).append(", addressLine2=").append(addressLine2)
				.append(", city=").append(city).append(", state=").append(state).append(", zip=").append(zip)
				.append(", country=").append(country).append(", company=").append(company).append(", getSrNo()=")
				.append(getSrNo()).append(", getExtNetUnit()=").append(getExtNetUnit()).append(", getOrderDate()=")
				.append(getOrderDate()).append(", getStoreOrderId()=").append(getStoreOrderId())
				.append(", getOrderNumber()=").append(getOrderNumber()).append(", getPoNumber()=").append(getPoNumber())
				.append(", getReferenceNumber()=").append(getReferenceNumber()).append(", getChannelName()=")
				.append(getChannelName()).append(", getOrderStatus()=").append(getOrderStatus()).append(", getSku()=")
				.append(getSku()).append(", getProductName()=").append(getProductName()).append(", getQuantity()=")
				.append(getQuantity()).append(", getSalePrice()=").append(getSalePrice())
				.append(", getSupplierCostPerSKU()=").append(getSupplierCostPerSKU())
				.append(", getSupplierCostTotal()=").append(getSupplierCostTotal()).append(", getOrderTotal()=")
				.append(getOrderTotal()).append(", getSupplierName()=").append(getSupplierName())
				.append(", getStoreShippingMethod()=").append(getStoreShippingMethod())
				.append(", getShippingCarrier()=").append(getShippingCarrier()).append(", getShippingMethod()=")
				.append(getShippingMethod()).append(", getTrackingNumbers()=").append(getTrackingNumbers())
				.append(", getCustomerName()=").append(getCustomerName()).append(", getCustomerEmail()=")
				.append(getCustomerEmail()).append(", getCustomerPhone()=").append(getCustomerPhone())
				.append(", getAddressLine1()=").append(getAddressLine1()).append(", getAddressLine2()=")
				.append(getAddressLine2()).append(", getCity()=").append(getCity()).append(", getState()=")
				.append(getState()).append(", getZip()=").append(getZip()).append(", getCountry()=")
				.append(getCountry()).append(", getCompany()=").append(getCompany()).append(", getClass()=")
				.append(getClass()).append(", hashCode()=").append(hashCode()).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}
	
}

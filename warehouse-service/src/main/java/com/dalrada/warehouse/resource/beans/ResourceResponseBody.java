package com.dalrada.warehouse.resource.beans;

import java.util.Date;


public class ResourceResponseBody {

	private Long warehouseId ;
	private String warehouseName ;
	private String warehouseAddress;
	private Integer warehouseCode;
	private Integer status ;
	private Date createdDate ;
	private String createdBy ;

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	public Integer getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(Integer warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ResourceResponseBody{");
		sb.append("warehouseId=").append(warehouseId);
		sb.append(", warehouseName='").append(warehouseName).append('\'');
		sb.append(", warehouseAddress='").append(warehouseAddress).append('\'');
		sb.append(", warehouseCode=").append(warehouseCode);
		sb.append(", status=").append(status);
		sb.append(", createdDate=").append(createdDate);
		sb.append(", createdBy='").append(createdBy).append('\'');
		sb.append('}');
		return sb.toString();
	}
}


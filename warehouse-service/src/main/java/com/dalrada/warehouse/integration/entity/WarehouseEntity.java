package com.dalrada.warehouse.integration.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "warehouse")
public class WarehouseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WAREHOUSE_ID")
	private Long warehouseId;
	@Column(name = "WAREHOUSE_NAME")
	private String warehouseName;
	@Column(name = "WAREHOUSE_ADDRESS")
	private String warehouseAddress;
	@Column(name = "WAREHOUSE_CODE")
	private Integer warehouseCode;
	@Column(name = "STATUS")
	private Integer status ;
	@Column(name = "CREATED_DATE")
	private Date createdDate ;
	@Column(name = "CREATED_BY")
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
}

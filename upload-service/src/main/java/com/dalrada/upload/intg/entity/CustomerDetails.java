/**
 * 
 */
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
@Table(name = "customer")
public class CustomerDetails implements Serializable{

	private static final long serialVersionUID = 6229892690668552411L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custID ;
	@Column
	private String warehouseID ;
	@Column
	private String custNumber ;
	@Column
	private String custName ;
	@Column
	private Long ordered ;
	@Column
	private Long shipped ;
	@Column
	private String discounts ;
	@Column
	private String tax ;
	@Column
	private String extNetUnit ;
	@Column
	private String fromDate ;
	@Column
	private String toDate ;
	public Long getCustID() {
		return custID;
	}
	public void setCustID(Long custID) {
		this.custID = custID;
	}
	public Long getOrdered() {
		return ordered;
	}
	public void setOrdered(Long ordered) {
		this.ordered = ordered;
	}
	public Long getShipped() {
		return shipped;
	}
	public void setShipped(Long shipped) {
		this.shipped = shipped;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getWarehouseID() {
		return warehouseID;
	}
	public void setWarehouseID(String warehouseID) {
		this.warehouseID = warehouseID;
	}
	public String getCustNumber() {
		return custNumber;
	}
	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getDiscounts() {
		return discounts;
	}
	public void setDiscounts(String discounts) {
		this.discounts = discounts;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getExtNetUnit() {
		return extNetUnit;
	}
	public void setExtNetUnit(String extNetUnit) {
		this.extNetUnit = extNetUnit;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetails [custID=").append(custID).append(", warehouseID=").append(warehouseID)
				.append(", custNumber=").append(custNumber).append(", custName=").append(custName).append(", ordered=")
				.append(ordered).append(", shipped=").append(shipped).append(", discounts=").append(discounts)
				.append(", tax=").append(tax).append(", extNetUnit=").append(extNetUnit).append(", fromDate=")
				.append(fromDate).append(", toDate=").append(toDate).append("]");
		return builder.toString();
	}
	
	
}

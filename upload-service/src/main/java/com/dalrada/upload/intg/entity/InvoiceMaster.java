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
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "invoice_master")
public class InvoiceMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5718953061922825991L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column
	private Long invMstID ;
	@Column
	private String invoiceNumber ;
	@Column
	private String warehouseID ;
	@Column
	private String custNumber ;
	@Column
	private String invDate ;
	@Column
	private String ordered ;
	@Column
	private String shipped ;
	@Column
	private String discounts ;
	@Column
	private String tax ;
	@Column
	private String extNetUnit ;
	@Column
	private String invCount ;
	@Column
	private String shipCount ;
	@Column
	private String dateCreated ;
	@Column
	private String createdBy ;
	
	public Long getInvMstID() {
		return invMstID;
	}
	public void setInvMstID(Long invMstID) {
		this.invMstID = invMstID;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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
	public String getInvDate() {
		return invDate;
	}
	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}
	public String getOrdered() {
		return ordered;
	}
	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}
	public String getShipped() {
		return shipped;
	}
	public void setShipped(String shipped) {
		this.shipped = shipped;
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
	public String getInvCount() {
		return invCount;
	}
	public void setInvCount(String invCount) {
		this.invCount = invCount;
	}
	public String getShipCount() {
		return shipCount;
	}
	public void setShipCount(String shipCount) {
		this.shipCount = shipCount;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvoiceMaster [invMstID=").append(invMstID).append(", invoiceNumber=").append(invoiceNumber)
				.append(", warehouseID=").append(warehouseID).append(", custNumber=").append(custNumber)
				.append(", invDate=").append(invDate).append(", ordered=").append(ordered).append(", shipped=")
				.append(shipped).append(", discounts=").append(discounts).append(", tax=").append(tax)
				.append(", extNetUnit=").append(extNetUnit).append(", invCount=").append(invCount)
				.append(", shipCount=").append(shipCount).append(", dateCreated=").append(dateCreated)
				.append(", createdBy=").append(createdBy).append("]");
		return builder.toString();
	}	
}

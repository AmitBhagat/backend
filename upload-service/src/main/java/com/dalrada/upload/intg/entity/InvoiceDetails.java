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
@Table(name = "invoice")
public class InvoiceDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1199841267804661714L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invDetID ;
	@Column
	private String invoiceNumber;
	@Column
	private String poNumber ;
	@Column
	private String invDate ;
	@Column
	private String warehouseID ;
	@Column
	private String custNumber ;
	@Column
	private String chain ;
	@Column
	private String productNumber ;
	@Column
	private String upcNumber ;
	@Column
	private String brand ;
	@Column
	private String description ;
	@Column
	private String pack ;
	@Column
	private String size ;
	@Column
	private String ordered ;
	@Column
	private String shipped ;
	@Column
	private String discDescr ;
	@Column
	private String discounts ;
	@Column
	private String tax ;
	@Column
	private String extNetUnit ;
	
	
	  public Long getInvDetID() { 
		  return invDetID; 
	  } 
	  public void setInvDetID(Long invDetID) { 
		  this.invDetID = invDetID; 
		  }
	 
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getInvDate() {
		return invDate;
	}
	public void setInvDate(String invDate) {
		this.invDate = invDate;
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
	public String getChain() {
		return chain;
	}
	public void setChain(String chain) {
		this.chain = chain;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getUpcNumber() {
		return upcNumber;
	}
	public void setUpcNumber(String upcNumber) {
		this.upcNumber = upcNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	public String getDiscDescr() {
		return discDescr;
	}
	public void setDiscDescr(String discDescr) {
		this.discDescr = discDescr;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvoiceDetails [invDetID=").append(", invoiceNumber=").append(invoiceNumber)
				.append(", poNumber=").append(poNumber).append(", invDate=").append(invDate).append(", warehouseID=")
				.append(warehouseID).append(", custNumber=").append(custNumber).append(", chain=").append(chain)
				.append(", productNumber=").append(productNumber).append(", upcNumber=").append(upcNumber)
				.append(", brand=").append(brand).append(", description=").append(description).append(", pack=")
				.append(pack).append(", size=").append(size).append(", ordered=").append(ordered).append(", shipped=")
				.append(shipped).append(", discDescr=").append(discDescr).append(", discounts=").append(discounts)
				.append(", tax=").append(tax).append(", extNetUnit=").append(extNetUnit).append("]");
		return builder.toString();
	}
}

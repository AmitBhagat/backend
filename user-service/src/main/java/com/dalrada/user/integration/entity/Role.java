package com.dalrada.user.integration.entity;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "role",uniqueConstraints = {@UniqueConstraint(columnNames = {
		"role_name" 
})})
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2686322222408778521L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId ;
	@Column(name = "role_name", unique = true, nullable = false)
	@Length(max = 20)
	private String roleName ;
	@Column(name = "status")
	private Integer status ;
	@Column(name = "created_date")
	private Date createdDate ;
	@Column(name = "created_by")
	private String createdBy ;
	
	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	public int hashCode() {	
		return this.getRoleName().hashCode();
	}
	
}

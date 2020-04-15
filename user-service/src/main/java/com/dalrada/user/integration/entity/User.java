package com.dalrada.user.integration.entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user",uniqueConstraints = {@UniqueConstraint(columnNames = {
		"userName" 
})})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2796703223448345725L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userId ;
	@Column
	private String userName ;
	@Column
	private String userEmail;
	@Column
	private String userPassword;
	@Column
	private Integer status ;
	@Column
	private Date createdDate ;
	@Column
	private String createdBy ;
	@Column
    private String roleName ;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {	
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=").append(userId).append(", userName=").append(userName).append(", userEmail=")
				.append(userEmail).append(", userPassword=").append(userPassword).append(", status=").append(status)
				.append(", createdDate=").append(createdDate).append(", createdBy=").append(createdBy)
				.append(", roleName=").append(roleName).append("]");
		return builder.toString();
	}
}

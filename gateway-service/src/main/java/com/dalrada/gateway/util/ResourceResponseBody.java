package com.dalrada.gateway.util;

import java.util.Date;


public class ResourceResponseBody {
	
	private Long userId ;
	private String userName ;
	private String userEmail;
	private String userPassword;
	private Integer status ;
	private Date createdDate ;
	private String createdBy ;
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
		builder.append("ResourceResponseBody [userId=").append(userId).append(", userName=").append(userName)
				.append(", userEmail=").append(userEmail).append(", userPassword=").append(userPassword)
				.append(", status=").append(status).append(", createdDate=").append(createdDate).append(", createdBy=")
				.append(createdBy).append(", roleName=").append(roleName).append("]");
		return builder.toString();
	}
	
}

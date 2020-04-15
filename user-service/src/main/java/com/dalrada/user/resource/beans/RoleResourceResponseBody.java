package com.dalrada.user.resource.beans;

import java.util.Date;


public class RoleResourceResponseBody {
	
	private Long roleId ;
	private String roleName ;
	private Integer status ;
	private Date createdDate ;
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
	public String toString() {
		final StringBuilder sb = new StringBuilder("ResourceResponseBody{");
		sb.append("roleId=").append(roleId);
		sb.append(", roleName='").append(roleName).append('\'');
		sb.append(", status=").append(status);
		sb.append(", createdDate=").append(createdDate);
		sb.append(", createdBy='").append(createdBy).append('\'');
		sb.append('}');
		return sb.toString();
	}
}


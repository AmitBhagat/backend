package com.dalrada.user.resource.requestBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.process.beans.RoleProcessRequest;
import com.dalrada.user.process.beans.UserProcessRequest;
import com.dalrada.user.resource.beans.RoleResourceRequest;
import com.dalrada.user.resource.beans.UserResourceRequest;

@Component
public class ResourceRequestBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ResourceRequestBuilder.class);
	public UserProcessRequest buildRequest(UserResourceRequest resourceRequest) {
		logger.debug("enter into buildRequest method");
		UserProcessRequest processRequest  = new UserProcessRequest();
		processRequest.setUserId(resourceRequest.getUserId());
		processRequest.setUserName(resourceRequest.getUserName());
		processRequest.setUserEmail(resourceRequest.getUserEmail());
		processRequest.setUserPassword(resourceRequest.getUserPassword());
		processRequest.setStatus(resourceRequest.getStatus());
		processRequest.setCreatedBy(resourceRequest.getCreatedBy());
		processRequest.setRoleName(resourceRequest.getRoleName());
		logger.debug("exit from buildRequest method");
		return processRequest;
	}
	
	public RoleProcessRequest buildRequest(RoleResourceRequest resourceRequest) {
		logger.debug("enter into buildRequest method");
		RoleProcessRequest processRequest  = new RoleProcessRequest();
		processRequest.setRoleId(resourceRequest.getRoleId());
		processRequest.setRoleName(resourceRequest.getRoleName());
		processRequest.setStatus(resourceRequest.getStatus());
		processRequest.setCreatedBy(resourceRequest.getCreatedBy());
		logger.debug("exit from buildRequest method");
		return processRequest;
	}
}

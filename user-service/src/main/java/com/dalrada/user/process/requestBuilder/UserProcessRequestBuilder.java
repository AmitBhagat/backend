package com.dalrada.user.process.requestBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.integration.beans.RoleIntgRequest;
import com.dalrada.user.integration.beans.UserIntgRequest;
import com.dalrada.user.process.beans.RoleProcessRequest;
import com.dalrada.user.process.beans.UserProcessRequest;

@Component
public class UserProcessRequestBuilder {
	private static final Logger logger = LoggerFactory.getLogger(UserProcessRequestBuilder.class);
	public UserIntgRequest buildRequest(UserProcessRequest processRequest) {
		logger.debug("enter into buildRequest method");
		UserIntgRequest intgRequest  = new UserIntgRequest();
		intgRequest.setUserId(processRequest.getUserId());
		intgRequest.setUserName(processRequest.getUserName());
		intgRequest.setUserEmail(processRequest.getUserEmail());
		intgRequest.setStatus(processRequest.getStatus());
		intgRequest.setUserPassword(processRequest.getUserPassword());
		intgRequest.setCreatedBy(processRequest.getCreatedBy());
		intgRequest.setRoleName(processRequest.getRoleName());
		logger.debug("exit from buildRequest method");
		return intgRequest;
	}
	
	public RoleIntgRequest buildRequest(RoleProcessRequest processRequest) {
		logger.debug("enter into buildRequest method");
		RoleIntgRequest intgRequest  = new RoleIntgRequest();
		intgRequest.setRoleId(processRequest.getRoleId());
		intgRequest.setRoleName(processRequest.getRoleName());
		intgRequest.setStatus(processRequest.getStatus());
		intgRequest.setCreatedBy(processRequest.getCreatedBy());
		logger.debug("exit from buildRequest method");
		return intgRequest;
	}

}

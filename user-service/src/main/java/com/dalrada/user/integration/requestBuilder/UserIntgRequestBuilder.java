package com.dalrada.user.integration.requestBuilder;

import java.sql.Date;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.integration.beans.RoleIntgRequest;
import com.dalrada.user.integration.beans.UserIntgRequest;
import com.dalrada.user.integration.entity.Role;
import com.dalrada.user.integration.entity.User;

@Component
public class UserIntgRequestBuilder {
	private static final Logger logger = LoggerFactory.getLogger(UserIntgRequestBuilder.class);
	public User buildRequest(UserIntgRequest intgRequest) {
		logger.debug("enter into buildRequest method");
		User entity  = new User();
		entity.setUserName(intgRequest.getUserName());
		entity.setCreatedBy(intgRequest.getCreatedBy());
		entity.setUserEmail(intgRequest.getUserEmail());
		entity.setStatus(intgRequest.getStatus());
		entity.setUserPassword(intgRequest.getUserPassword());
		entity.setCreatedBy(intgRequest.getCreatedBy());
		LocalDate currentDate = LocalDate.now();
		entity.setCreatedDate(Date.valueOf(currentDate));
		entity.setRoleName(intgRequest.getRoleName());
		logger.debug("exit from buildRequest method");
		return entity;
	}
	
	
	public User buildRequest(User entity,UserIntgRequest intgRequest) {
		logger.debug("enter into buildRequest method for edit");
		entity.setUserEmail(intgRequest.getUserEmail());
		entity.setUserPassword(intgRequest.getUserPassword());
		entity.setUserName(intgRequest.getUserName());
		logger.debug("exit from buildRequest method for edit");
		return entity;
	}
	
	public Role buildRequest(RoleIntgRequest intgRequest) {
		logger.debug("enter into buildRequest method");
		Role entity  = new Role();
		entity.setRoleName(intgRequest.getRoleName());
		entity.setStatus(intgRequest.getStatus());
		entity.setCreatedBy(intgRequest.getCreatedBy());
		LocalDate currentDate = LocalDate.now();
		entity.setCreatedDate(Date.valueOf(currentDate));
		logger.debug("exit from buildRequest method");
		return entity;
	}

	public Role buildRequest(Role entity,RoleIntgRequest intgRequest){
		logger.debug("enter into editRole method");
		entity.setRoleName(intgRequest.getRoleName());
		logger.debug("exit from editRole method");
		return entity;
	}
}

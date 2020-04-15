package com.dalrada.user.integration.responseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.integration.beans.RoleIntgResponse;
import com.dalrada.user.integration.beans.UserIntgResponse;
import com.dalrada.user.integration.entity.Role;
import com.dalrada.user.integration.entity.User;

@Component
public class UserIntgResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(UserIntgResponseBuilder.class);
	public UserIntgResponse buildResponse(User entity) {
		logger.debug("enter into buildResponse method");
		UserIntgResponse response = new UserIntgResponse();
		response.setResponseCode("200");
		response.setResponseMsg("successfull");
		response.setRespBody(entity);
		logger.debug("exit from buildResponse method");
		return response;		
	}

	public UserIntgResponse userBuildResponse(String responseCode, String respMsg) {
		logger.debug("enter into buildResponse method");
		UserIntgResponse response = new UserIntgResponse();
		response.setResponseCode(responseCode);
		response.setResponseMsg(respMsg);
		logger.debug("exit from buildResponse method");
		return response;	

	}
	
	public RoleIntgResponse buildResponse(Role entity) {
		logger.debug("enter into buildResponse method");
		RoleIntgResponse response = new RoleIntgResponse();
		response.setResponseCode("200");
		response.setResponseMsg("successful");
		response.setRespBody(entity);
		logger.debug("exit from buildResponse method");
		return response;		
	}

	public RoleIntgResponse RoleBuildResponse(String responseCode, String respMsg) {
		logger.debug("enter into buildResponse method");
		RoleIntgResponse response = new RoleIntgResponse();
		response.setResponseCode(responseCode);
		response.setResponseMsg(respMsg);
		logger.debug("exit from buildResponse method");
		return response;	
	}

}

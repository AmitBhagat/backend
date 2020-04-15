package com.dalrada.user.resource.responseBuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.process.beans.RoleProcessResponse;
import com.dalrada.user.process.beans.UserProcessResponse;
import com.dalrada.user.resource.beans.RoleResourceResponse;
import com.dalrada.user.resource.beans.RoleResourceResponseBody;
import com.dalrada.user.resource.beans.UserResourceResponse;
import com.dalrada.user.resource.beans.UserResourceResponseBody;

@Component
public class ResourceResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ResourceResponseBuilder.class);
	
	public UserResourceResponse buildResponse(UserProcessResponse intgResponse) {
		logger.debug("enter into buildResponse method");
		UserResourceResponse resourceResponse = new UserResourceResponse();
		resourceResponse.setResponseCode(intgResponse.getResponseCode());
		resourceResponse.setResponseMsg(intgResponse.getResponseMsg());
		UserResourceResponseBody responseBody = new UserResourceResponseBody();
		responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
		responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
		responseBody.setStatus(intgResponse.getRespBody().getStatus());
		responseBody.setUserEmail(intgResponse.getRespBody().getUserEmail());
		responseBody.setUserId(intgResponse.getRespBody().getUserId());
		responseBody.setUserName(intgResponse.getRespBody().getUserName());
		responseBody.setUserPassword(intgResponse.getRespBody().getUserPassword());	
		responseBody.setRoleName((intgResponse.getRespBody().getRoleName()));
		resourceResponse.setRespBody(responseBody);
		logger.debug("exit from buildResponse method");
		return resourceResponse;
	}
	
	public List<UserResourceResponse> userBuildResponse(List<UserProcessResponse> processRespList) {
		logger.debug("enter into buildResponse method");
		List<UserResourceResponse> resourceRespList = new ArrayList<UserResourceResponse>();
		processRespList.forEach(intgResponse ->{
			UserResourceResponse resourceResponse = new UserResourceResponse();
			resourceResponse.setResponseCode(intgResponse.getResponseCode());
			resourceResponse.setResponseMsg(intgResponse.getResponseMsg());
			UserResourceResponseBody responseBody = new UserResourceResponseBody();
			responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
			responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
			responseBody.setStatus(intgResponse.getRespBody().getStatus());
			responseBody.setUserEmail(intgResponse.getRespBody().getUserEmail());
			responseBody.setUserId(intgResponse.getRespBody().getUserId());
			responseBody.setUserName(intgResponse.getRespBody().getUserName());
			responseBody.setUserPassword(intgResponse.getRespBody().getUserPassword());
			responseBody.setRoleName((intgResponse.getRespBody().getRoleName()));
			resourceResponse.setRespBody(responseBody);
			resourceRespList.add(resourceResponse);
		});
		logger.debug("exit from buildResponse method");
		return resourceRespList;
	}
	
	public RoleResourceResponse buildResponse(RoleProcessResponse processResponse) {
		logger.debug("enter into buildResponse method");
		RoleResourceResponse roleResourceResponse = new RoleResourceResponse();
		roleResourceResponse.setResponseCode(processResponse.getResponseCode());
		roleResourceResponse.setResponseMsg(processResponse.getResponseMsg());
		RoleResourceResponseBody responseBody = new RoleResourceResponseBody();
		responseBody.setCreatedBy(processResponse.getRespBody().getCreatedBy());
		responseBody.setCreatedDate(processResponse.getRespBody().getCreatedDate());
		responseBody.setStatus(processResponse.getRespBody().getStatus());
		responseBody.setRoleId(processResponse.getRespBody().getRoleId());
		responseBody.setRoleName(processResponse.getRespBody().getRoleName());
		roleResourceResponse.setRespBody(responseBody);
		logger.debug("exit from buildResponse method");
		return roleResourceResponse;
	}
	
	public List<RoleResourceResponse> roleBuildResponse(List<RoleProcessResponse> processRespList) {
		logger.debug("enter into buildResponse method");
		List<RoleResourceResponse> resourceRespList = new ArrayList<RoleResourceResponse>();
		processRespList.forEach(processResponse ->{
			RoleResourceResponse roleResourceResponse = new RoleResourceResponse();
			roleResourceResponse.setResponseCode(processResponse.getResponseCode());
			roleResourceResponse.setResponseMsg(processResponse.getResponseMsg());
			RoleResourceResponseBody responseBody = new RoleResourceResponseBody();
			responseBody.setCreatedBy(processResponse.getRespBody().getCreatedBy());
			responseBody.setCreatedDate(processResponse.getRespBody().getCreatedDate());
			responseBody.setStatus(processResponse.getRespBody().getStatus());
			responseBody.setRoleId(processResponse.getRespBody().getRoleId());
			responseBody.setRoleName(processResponse.getRespBody().getRoleName());
			roleResourceResponse.setRespBody(responseBody);
			resourceRespList.add(roleResourceResponse);
		});
		logger.debug("exit from buildResponse method");
		return resourceRespList;
	}
	
}

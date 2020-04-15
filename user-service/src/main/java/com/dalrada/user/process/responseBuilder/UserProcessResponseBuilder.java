package com.dalrada.user.process.responseBuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.integration.beans.RoleIntgResponse;
import com.dalrada.user.integration.beans.UserIntgResponse;
import com.dalrada.user.process.beans.RoleProcessResponse;
import com.dalrada.user.process.beans.RoleProcessResponseBody;
import com.dalrada.user.process.beans.UserProcessResponse;
import com.dalrada.user.process.beans.UserProcessResponseBody;


@Component
public class UserProcessResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(UserProcessResponseBuilder.class);
	public UserProcessResponse buildResponse(UserIntgResponse intgResponse) {
		logger.debug("enter into buildResponse method");
		UserProcessResponse processResponse = new UserProcessResponse();
		processResponse.setResponseCode(intgResponse.getResponseCode());
		processResponse.setResponseMsg(intgResponse.getResponseMsg());
		UserProcessResponseBody responseBody = new UserProcessResponseBody();
		responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
		responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
		responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
		responseBody.setStatus(intgResponse.getRespBody().getStatus());
		responseBody.setUserEmail(intgResponse.getRespBody().getUserEmail());
		responseBody.setUserId(intgResponse.getRespBody().getUserId());
		responseBody.setUserName(intgResponse.getRespBody().getUserName());
		responseBody.setRoleName((intgResponse.getRespBody().getRoleName()));
		responseBody.setUserPassword(intgResponse.getRespBody().getUserPassword());	
		processResponse.setRespBody(responseBody);
		logger.debug("enter into buildResponse method");
		return processResponse;
	}
	
	
	
	
	
	public List<UserProcessResponse> userBuildResponse(List<UserIntgResponse> intgRespList) {
		List<UserProcessResponse> processRespList = new ArrayList<UserProcessResponse>();
		intgRespList.forEach(intgResponse ->{
			UserProcessResponse processResponse = new UserProcessResponse();
			processResponse.setResponseCode(intgResponse.getResponseCode());
			processResponse.setResponseMsg(intgResponse.getResponseMsg());
			UserProcessResponseBody responseBody = new UserProcessResponseBody();
			responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
			responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
			responseBody.setStatus(intgResponse.getRespBody().getStatus());
			responseBody.setUserEmail(intgResponse.getRespBody().getUserEmail());
			responseBody.setUserId(intgResponse.getRespBody().getUserId());
			responseBody.setUserName(intgResponse.getRespBody().getUserName());
			responseBody.setRoleName((intgResponse.getRespBody().getRoleName()));
			responseBody.setUserPassword(intgResponse.getRespBody().getUserPassword());	
			processResponse.setRespBody(responseBody);
			processRespList.add(processResponse);
		});
		return processRespList;
	}
	
	public RoleProcessResponse buildResponse(RoleIntgResponse intgResponse) {
		logger.debug("enter into buildResponse method");
		RoleProcessResponse processResponse = new RoleProcessResponse();
		processResponse.setResponseCode(intgResponse.getResponseCode());
		processResponse.setResponseMsg(intgResponse.getResponseMsg());
		RoleProcessResponseBody responseBody = new RoleProcessResponseBody();
		responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
		responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
		responseBody.setStatus(intgResponse.getRespBody().getStatus());
		responseBody.setRoleId(intgResponse.getRespBody().getRoleId());
		responseBody.setRoleName(intgResponse.getRespBody().getRoleName());
		processResponse.setRespBody(responseBody);
		logger.debug("exit into buildResponse method");
		return processResponse;
	}
	
	
	
	
	
	public List<RoleProcessResponse> roleBuildResponse(List<RoleIntgResponse> intgRespList) {
		List<RoleProcessResponse> processRespList = new ArrayList<RoleProcessResponse>();
		intgRespList.forEach(intgResponse ->{
			RoleProcessResponse processResponse = new RoleProcessResponse();
			processResponse.setResponseCode(intgResponse.getResponseCode());
			processResponse.setResponseMsg(intgResponse.getResponseMsg());
			RoleProcessResponseBody responseBody = new RoleProcessResponseBody();
			responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
			responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
			responseBody.setStatus(intgResponse.getRespBody().getStatus());
			responseBody.setRoleId(intgResponse.getRespBody().getRoleId());
			responseBody.setRoleName(intgResponse.getRespBody().getRoleName());
			processResponse.setRespBody(responseBody);
			processRespList.add(processResponse);
		});
		return processRespList;
	}
}

package com.dalrada.user.resource.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dalrada.user.integration.exception.BusinessException;
import com.dalrada.user.integration.exception.SystemException;
import com.dalrada.user.resource.beans.UserResourceResponse;
import com.dalrada.user.resource.exception.InvalidRequestException;


@ControllerAdvice
@ResponseBody
public class UserExceptionHandler {
	
	@ExceptionHandler(InvalidRequestException.class)
	public UserResourceResponse invalidRequestExceptionHandler(InvalidRequestException ex){
		UserResourceResponse response = new UserResourceResponse();
		response.setResponseCode(ex.getErrorCode());
		response.setResponseMsg(ex.getErrorMsg());
		return response;	
	}
	@ExceptionHandler(SystemException.class)
	public UserResourceResponse systemExceptionHandler(SystemException ex){
		UserResourceResponse response = new UserResourceResponse();
		response.setResponseCode(ex.getErrorCode());
		response.setResponseMsg(ex.getErrorMsg());
		return response;	
	}
	@ExceptionHandler(BusinessException.class)
	public UserResourceResponse businessExceptionHandler(BusinessException ex){
		UserResourceResponse response = new UserResourceResponse();
		response.setResponseCode(ex.getErrorCode());
		response.setResponseMsg(ex.getErrorMsg());
		return response;	
	}
	
}


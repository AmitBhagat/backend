package com.dalrada.warehouse.resource.exceptionHandler;

import com.dalrada.warehouse.integration.exception.BusinessException;
import com.dalrada.warehouse.integration.exception.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.dalrada.warehouse.resource.beans.ResourceResponse;
import com.dalrada.warehouse.resource.exception.InvalidRequestException;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidRequestException.class)
	public ResourceResponse invalidRequestExceptionHandler(InvalidRequestException ex){
		ResourceResponse response = new ResourceResponse();
		response.setResponseCode(ex.getErrorCode());
		response.setResponseMsg(ex.getErrorMsg());
		return response;	
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(SystemException.class)
	public ResourceResponse systemExceptionHandler(SystemException ex){
		ResourceResponse response = new ResourceResponse();
		response.setResponseCode(ex.getErrorCode());
		response.setResponseMsg(ex.getErrorMsg());
		return response;	
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
	public ResourceResponse businessExceptionHandler(BusinessException ex){
		ResourceResponse response = new ResourceResponse();
		response.setResponseCode(ex.getErrorCode());
		response.setResponseMsg(ex.getErrorMsg());
		return response;	
	}
	
}


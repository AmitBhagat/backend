package com.dalrada.upload.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dalrada.upload.intg.exception.BusinessException;
import com.dalrada.upload.intg.exception.SystemException;
import com.dalrada.upload.resource.beans.UploadResponse;
import com.dalrada.upload.resource.exception.InvalidRequestException;
import com.dalrada.upload.resource.requestBuilder.OrderResourceRequestBuilder;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@ControllerAdvice
@ResponseBody
public class UploadExceptionHandler {

	private final static Logger logger = LoggerFactory.getLogger(OrderResourceRequestBuilder.class);
	
	@ExceptionHandler(InvalidRequestException.class)
	public UploadResponse handleInvalidrequestException(InvalidRequestException ex) {
		logger.debug("Entering into the handleInvalidrequestException method");
		UploadResponse response = new UploadResponse();
		response.setRespCode(ex.getErrorCode());
		response.setRespMsg(ex.getErrorMsg());
		logger.debug("Exiting from the handleInvalidrequestException method");
		return response;
	}
	@ExceptionHandler(BusinessException.class)
	public UploadResponse handleBusinessException(BusinessException ex) {
		logger.debug("Entering into the handleBusinessException method");
		UploadResponse response = new UploadResponse();
		response.setRespCode(ex.getErrorCode());
		response.setRespMsg(ex.getErrorMsg());
		logger.debug("Exiting from the handleBusinessException method");
		return response;
	}
	@ExceptionHandler(SystemException.class)
	public UploadResponse handleSystemException(SystemException ex) {
		logger.debug("Entering into the handleBusinessException method");
		UploadResponse response = new UploadResponse();
		response.setRespCode(ex.getErrorCode());
		response.setRespMsg(ex.getErrorMsg());
		logger.debug("Exiting from the handleBusinessException method");
		return response;
	}
	
}

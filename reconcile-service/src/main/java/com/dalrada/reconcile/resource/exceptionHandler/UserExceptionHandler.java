package com.dalrada.reconcile.resource.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dalrada.reconcile.integration.exception.BusinessException;
import com.dalrada.reconcile.integration.exception.SystemException;
import com.dalrada.reconcile.resource.beans.ReconcileResourceResponse;
import com.dalrada.reconcile.resource.exception.InvalidRequestException;

import reactor.core.publisher.Mono;

/**
 * @author Sneha
 *
 */
//Spring allowing you to write global code that can be applied to a wide range of controllers
@ControllerAdvice
public class UserExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(UserExceptionHandler.class);
	@ExceptionHandler(InvalidRequestException.class)
	public Mono<ReconcileResourceResponse> invalidRequestExceptionHandler(InvalidRequestException ex){
		logger.debug("enter into invalidRequestExceptionHandler method");
		ReconcileResourceResponse response = new ReconcileResourceResponse();
		response.setResponseCode(ex.getErrorCode());
		response.setResponseMsg(ex.getErrorMsg());
		logger.debug("exit from invalidRequestExceptionHandler method");
		return Mono.just(response);	
	}
	@ExceptionHandler(SystemException.class)
	public Mono<ReconcileResourceResponse> systemExceptionHandler(SystemException ex){
		logger.debug("enter into systemExceptionHandler method");
		ReconcileResourceResponse response = new ReconcileResourceResponse();
		response.setResponseCode(ex.getErrorCode());
		response.setResponseMsg(ex.getErrorMsg());
		logger.debug("exit from invalidRequestExceptionHandler method");
		return Mono.just(response);	
	}
	@ExceptionHandler(BusinessException.class)
	public Mono<ReconcileResourceResponse> businessExceptionHandler(BusinessException ex){
		logger.debug("enter into businessExceptionHandler method");
		ReconcileResourceResponse response = new ReconcileResourceResponse();
		response.setResponseCode(ex.getErrorCode());
		response.setResponseMsg(ex.getErrorMsg());
		logger.debug("exist from invalidRequestExceptionHandler method");
		return Mono.just(response);	
	}
	
}


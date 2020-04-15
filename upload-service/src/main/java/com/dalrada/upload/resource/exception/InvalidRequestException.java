package com.dalrada.upload.resource.exception;

public class InvalidRequestException extends Exception {

	private String errorCode ;
	private String errorMsg ;
	
	public InvalidRequestException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
	
}

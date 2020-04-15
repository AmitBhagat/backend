package com.dalrada.warehouse.resource.exception;

public class InvalidRequestException extends Exception {
	
	private static final long serialVersionUID = 8871613805521871110L;
	private String errorCode ;
	private String errorMsg;
	public InvalidRequestException(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvalidRequestException [errorCode=").append(errorCode).append(", errorMsg=").append(errorMsg)
				.append("]");
		return builder.toString();
	}

}

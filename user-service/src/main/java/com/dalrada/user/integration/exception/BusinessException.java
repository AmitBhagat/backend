package com.dalrada.user.integration.exception;

public class BusinessException extends Exception {
	private static final long serialVersionUID = -2249451426741743799L;
	private String errorCode ;
	private String errorMsg;
	public BusinessException(String errorCode, String errorMsg) {
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
		builder.append("BusinessException [errorCode=").append(errorCode).append(", errorMsg=").append(errorMsg)
				.append("]");
		return builder.toString();
	}

}

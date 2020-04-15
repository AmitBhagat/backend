package com.dalrada.user.integration.exception;

public class SystemException extends Exception {

	private static final long serialVersionUID = 7344921808783560590L;
	private String errorCode ;
	private String errorMsg;
	public SystemException(String errorCode, String errorMsg) {
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
		builder.append("SystemException [errorCode=").append(errorCode).append(", errorMsg=").append(errorMsg)
				.append("]");
		return builder.toString();
	}

}

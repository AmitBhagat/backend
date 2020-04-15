package com.dalrada.upload.intg.exception;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
public class SystemException extends Exception {
	private static final long serialVersionUID = 3864919214579440900L;
	private String errorCode ;
	private String errorMsg ;
	public SystemException(String errorCode, String errorMsg) {
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

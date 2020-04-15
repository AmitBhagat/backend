package com.dalrada.upload.intg.exception;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 8783955285335056968L;
	private String errorCode ;
	private String errorMsg ;
	public BusinessException(String errorCode, String errorMsg) {
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

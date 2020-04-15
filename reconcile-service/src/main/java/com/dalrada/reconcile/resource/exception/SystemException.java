package com.dalrada.reconcile.resource.exception;
/**
 * @author Sneha
 *
 */
public class SystemException extends Exception {

	private static final long serialVersionUID = -4627832690259532435L;
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

}

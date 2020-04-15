package com.dalrada.reconcile.integration.beans;

/**
 * @author Sneha
 *
 */
public class ReconcileIntgResponse {

	private String responseCode ;
	private String responseMsg ;
	private IntgResponseBody responseBody ;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public IntgResponseBody getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(IntgResponseBody responseBody) {
		this.responseBody = responseBody;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReconcileIntgResponse [responseCode=").append(responseCode).append(", responseMsg=")
				.append(responseMsg).append(", responseBody=").append(responseBody).append("]");
		return builder.toString();
	}
}

package com.dalrada.warehouse.process.beans;

public class ProcessResponse {

	private String responseCode ;
	private String responseMsg ;
	private ProcessResponseBody respBody ;
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
	public ProcessResponseBody getRespBody() {
		return respBody;
	}
	public void setRespBody(ProcessResponseBody respBody) {
		this.respBody = respBody;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserProcessResponse [responseCode=").append(responseCode).append(", responseMsg=")
				.append(responseMsg).append(", respBody=").append(respBody).append("]");
		return builder.toString();
	}
	
	
}

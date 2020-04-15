package com.dalrada.user.process.beans;

public class RoleProcessResponse {

	private String responseCode ;
	private String responseMsg ;
	private RoleProcessResponseBody respBody ;
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
	public RoleProcessResponseBody getRespBody() {
		return respBody;
	}
	public void setRespBody(RoleProcessResponseBody respBody) {
		this.respBody = respBody;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoleProcessResponse [responseCode=").append(responseCode).append(", responseMsg=")
				.append(responseMsg).append(", respBody=").append(respBody).append("]");
		return builder.toString();
	}
	
	
}

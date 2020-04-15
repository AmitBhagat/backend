package com.dalrada.user.integration.beans;

import com.dalrada.user.integration.entity.User;

public class UserIntgResponse {

	private String responseCode ;
	private String responseMsg ;
	private User respBody ;
	
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
	public User getRespBody() {
		return respBody;
	}
	public void setRespBody(User respBody) {
		this.respBody = respBody;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserIntgResponse [responseCode=").append(responseCode).append(", responseMsg=")
				.append(responseMsg).append(", respBody=").append(respBody).append("]");
		return builder.toString();
	}
	
	
	
	
}

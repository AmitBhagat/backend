package com.dalrada.user.resource.beans;

import org.springframework.stereotype.Component;

@Component 
public class RoleResourceResponse {

	private String responseCode ;
	private String responseMsg ;
	private RoleResourceResponseBody respBody ;
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
	public RoleResourceResponseBody getRespBody() {
		return respBody;
	}
	public void setRespBody(RoleResourceResponseBody respBody) {
		this.respBody = respBody;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserResourceResponse [responseCode=").append(responseCode).append(", responseMsg=")
				.append(responseMsg).append(", respBody=").append(respBody).append("]");
		return builder.toString();
	}
	
}

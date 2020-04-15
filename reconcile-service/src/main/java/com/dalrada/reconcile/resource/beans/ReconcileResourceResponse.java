package com.dalrada.reconcile.resource.beans;

import org.springframework.stereotype.Component;
/**
 * @author Sneha
 *
 */
@Component 
public class ReconcileResourceResponse {

	private String responseCode ;
	private String responseMsg ;
	private ResourceResponseBody respBody ;
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
	public ResourceResponseBody getRespBody() {
		return respBody;
	}
	public void setRespBody(ResourceResponseBody respBody) {
		this.respBody = respBody;
	}
	//overriding toString() method will return the specified values.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserResourceResponse [responseCode=").append(responseCode).append(", responseMsg=")
				.append(responseMsg).append(", respBody=").append(respBody).append("]");
		return builder.toString();
	}
	
}

package com.dalrada.warehouse.integration.beans;

import com.dalrada.warehouse.integration.entity.WarehouseEntity;

public class IntgResponse {

	private String responseCode ;
	private String responseMsg ;
	private WarehouseEntity respBody ;
	
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
	public WarehouseEntity getRespBody() {
		return respBody;
	}
	public void setRespBody(WarehouseEntity respBody) {
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

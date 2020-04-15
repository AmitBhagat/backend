package com.dalrada.warehouse.resource.responseBuilder;

import java.util.ArrayList;
import java.util.List;

import com.dalrada.warehouse.process.beans.ProcessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.warehouse.resource.beans.ResourceResponseBody;
import com.dalrada.warehouse.resource.beans.ResourceResponse;

@Component
public class ResourceResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ResourceResponseBuilder.class);
	
	public ResourceResponse buildResponse(ProcessResponse processResponse) {
		logger.debug("enter into buildResponse method");
		ResourceResponse resourceResponse = new ResourceResponse();
		resourceResponse.setResponseCode(processResponse.getResponseCode());
		resourceResponse.setResponseMsg(processResponse.getResponseMsg());
		ResourceResponseBody responseBody = new ResourceResponseBody();
		responseBody.setCreatedBy(processResponse.getRespBody().getCreatedBy());
		responseBody.setCreatedDate(processResponse.getRespBody().getCreatedDate());
		responseBody.setStatus(processResponse.getRespBody().getStatus());
		responseBody.setWarehouseId(processResponse.getRespBody().getWarehouseId());
		responseBody.setWarehouseName(processResponse.getRespBody().getWarehouseName());
		responseBody.setWarehouseAddress(processResponse.getRespBody().getWarehouseAddress());
		responseBody.setWarehouseCode(processResponse.getRespBody().getWarehouseCode());
		resourceResponse.setRespBody(responseBody);
		logger.debug("exit from buildResponse method");
		return resourceResponse;
	}
	
	public List<ResourceResponse> buildResponse(List<ProcessResponse> processResponseListRespList) {
		logger.debug("enter into buildResponse method");
		List<ResourceResponse> processRespList = new ArrayList<ResourceResponse>();
		processResponseListRespList.forEach(processResponse ->{
			ResourceResponse resourceResponse = new ResourceResponse();
			resourceResponse.setResponseCode(processResponse.getResponseCode());
			resourceResponse.setResponseMsg(processResponse.getResponseMsg());
			ResourceResponseBody responseBody = new ResourceResponseBody();
			responseBody.setCreatedBy(processResponse.getRespBody().getCreatedBy());
			responseBody.setCreatedDate(processResponse.getRespBody().getCreatedDate());
			responseBody.setStatus(processResponse.getRespBody().getStatus());
			responseBody.setWarehouseId(processResponse.getRespBody().getWarehouseId());
			responseBody.setWarehouseName(processResponse.getRespBody().getWarehouseName());
			responseBody.setWarehouseAddress(processResponse.getRespBody().getWarehouseAddress());
			responseBody.setWarehouseCode(processResponse.getRespBody().getWarehouseCode());
			resourceResponse.setRespBody(responseBody);
			processRespList.add(resourceResponse);
		});
		logger.debug("exit from buildResponse method");
		return processRespList;
	}
	
}

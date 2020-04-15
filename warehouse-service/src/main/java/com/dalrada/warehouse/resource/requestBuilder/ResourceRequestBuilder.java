package com.dalrada.warehouse.resource.requestBuilder;

import com.dalrada.warehouse.process.beans.ProcessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.warehouse.resource.beans.ResourceRequest;

@Component
public class ResourceRequestBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ResourceRequestBuilder.class);
	public ProcessRequest buildRequest(ResourceRequest resourceRequest) {
		logger.debug("enter into buildRequest method");
		ProcessRequest processRequest  = new ProcessRequest();
		processRequest.setWarehouseName(resourceRequest.getWarehouseName());
		processRequest.setWarehouseAddress(resourceRequest.getWarehouseAddress());
		processRequest.setWarehouseCode(resourceRequest.getWarehouseCode());
		processRequest.setStatus(resourceRequest.getStatus());
		processRequest.setCreatedBy(resourceRequest.getCreatedBy());
		logger.debug("exit from buildRequest method");
		return processRequest;
	}
}

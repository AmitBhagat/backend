package com.dalrada.warehouse.process.requestBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.warehouse.integration.beans.IntgRequest;
import com.dalrada.warehouse.process.beans.ProcessRequest;

@Component
public class ProcessRequestBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ProcessRequestBuilder.class);
	public IntgRequest buildRequest(ProcessRequest processRequest) {
		logger.debug("enter into buildRequest method");
		IntgRequest intgRequest  = new IntgRequest();
		intgRequest.setWarehouseName(processRequest.getWarehouseName());
		intgRequest.setWarehouseAddress(processRequest.getWarehouseAddress());
		intgRequest.setWarehouseCode(processRequest.getWarehouseCode());
		intgRequest.setStatus(processRequest.getStatus());
		intgRequest.setCreatedBy(processRequest.getCreatedBy());
		logger.debug("exit from buildRequest method");
		return intgRequest;
	}

}

/**
 * 
 */
package com.dalrada.upload.resource.requestBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.upload.process.beans.OrderProcessRequest;
import com.dalrada.upload.resource.beans.OrderResourceRequest;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderResourceRequestBuilder {

	private final static Logger logger = LoggerFactory.getLogger(OrderResourceRequestBuilder.class);
	
	/**
	 * @param request
	 * @return
	 */
	

	public OrderProcessRequest buildRequest(OrderResourceRequest request ) {
		logger.debug("Entering into the buildRequest method");
		logger.info("parameters" , request);
		
		OrderProcessRequest processReq = new OrderProcessRequest();
		processReq.setStartDate(request.getStartDate());
		processReq.setLastDate(request.getLastDate());
		processReq.setFile(request.getFile());
		
		logger.debug("Exiting from the uploadWarehouse method");
		return processReq;
	}
}

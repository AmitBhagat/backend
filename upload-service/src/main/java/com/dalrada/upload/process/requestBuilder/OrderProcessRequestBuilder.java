/**
 * 
 */
package com.dalrada.upload.process.requestBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beans.OrderIntgRequest;
import com.dalrada.upload.process.beans.OrderProcessRequest;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderProcessRequestBuilder {

	private final static Logger logger = LoggerFactory.getLogger(OrderProcessRequestBuilder.class);
	
	public OrderIntgRequest buildRequest(OrderProcessRequest request ) {
		logger.debug("Entering into the buildRequest method");
		logger.info("parameters" , request);
		OrderIntgRequest intgReq = new OrderIntgRequest();
		intgReq.setStartDate(request.getStartDate());
		intgReq.setLastDate(request.getLastDate());
		intgReq.setFile(request.getFile());
		logger.debug("Exiting from the buildRequest method");
		return intgReq;
	}

}

/**
 * 
 */
package com.dalrada.upload.process.responseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beans.OrderIntgResponse;
import com.dalrada.upload.process.beans.OrderProcessResponse;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderProcessResponseBuilder {

	private final static Logger logger = LoggerFactory.getLogger(OrderProcessResponseBuilder.class);
	/**
	 * @param intgResponse
	 * @return
	 */
	public OrderProcessResponse buildResponse(OrderIntgResponse intgResponse) {
		logger.debug("Entering into the buildResponse method");
		logger.info("parameters" , intgResponse);
		OrderProcessResponse response = new OrderProcessResponse();
		response.setRespCode(intgResponse.getRespCode());
		response.setRespMsg(intgResponse.getRespMsg());
		logger.debug("Exiting from the buildResponse method");
		return response;
	}

}

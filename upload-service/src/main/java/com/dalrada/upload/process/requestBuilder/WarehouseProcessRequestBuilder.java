/**
 * 
 */
package com.dalrada.upload.process.requestBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beans.WarehouseIntgRequest;
import com.dalrada.upload.process.beans.WarehouseProcessRequest;
import com.dalrada.upload.resource.requestBuilder.OrderResourceRequestBuilder;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseProcessRequestBuilder {

	private final static Logger logger = LoggerFactory.getLogger(OrderResourceRequestBuilder.class);
	/**
	 * @param records
	 * @return
	 */

	public WarehouseIntgRequest buildRequest(WarehouseProcessRequest processReq) {
		logger.debug("Entering into the buildRequest method");
		logger.info("parameters" , processReq);
		WarehouseIntgRequest request = new WarehouseIntgRequest();
		request.setId(processReq.getId());
		request.setFile(processReq.getFile());
		logger.debug("Exiting from the buildRequest method");
		return request;
	}

}

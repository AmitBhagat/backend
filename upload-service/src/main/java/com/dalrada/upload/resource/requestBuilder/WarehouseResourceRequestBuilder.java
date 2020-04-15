/**
 * 
 */
package com.dalrada.upload.resource.requestBuilder;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beans.WarehouseIntgRequest;
import com.dalrada.upload.process.beans.WarehouseProcessRequest;
import com.dalrada.upload.resource.beans.WarehouseResourceRequest;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseResourceRequestBuilder {

	private final static Logger logger = LoggerFactory.getLogger(WarehouseResourceRequestBuilder.class);
	/**
	 * @param id
	 * @param wFile
	 * @return
	 * @throws IOException 
	 */

	public WarehouseProcessRequest buildRequest(WarehouseResourceRequest resourceReq ) throws IOException {
		logger.debug("Entering into the buildRequest method");
		logger.info("parameters" , resourceReq);
		WarehouseProcessRequest request = new WarehouseProcessRequest();
	
		request.setFile(resourceReq.getFile());
		request.setId(resourceReq.getId());
		
		
		logger.debug("Exiting from the uploadWarehouse method");
		return request;
	}

}

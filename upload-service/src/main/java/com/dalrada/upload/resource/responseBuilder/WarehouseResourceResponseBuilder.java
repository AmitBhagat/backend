/**
 * 
 */
package com.dalrada.upload.resource.responseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.upload.process.beans.WarehouseProcessResponse;
import com.dalrada.upload.resource.beans.UploadResponse;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */

@Component
public class WarehouseResourceResponseBuilder {
	private final static Logger logger = LoggerFactory.getLogger(WarehouseResourceResponseBuilder.class);
	
	public UploadResponse buildResponse(WarehouseProcessResponse processResp) {
		logger.debug("Entering into the buildResponse method");
		logger.info("parameters" , processResp);
		UploadResponse response = new UploadResponse();
		response.setRespCode(processResp.getRespCode());
		response.setRespMsg(processResp.getRespMsg());
		logger.debug("Exiting from the buildResponse method");
		return response;
	}
	
}

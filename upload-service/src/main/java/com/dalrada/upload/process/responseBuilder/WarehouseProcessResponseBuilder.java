/**
 * 
 */
package com.dalrada.upload.process.responseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beans.WarehouseIntgResponse;
import com.dalrada.upload.process.beans.WarehouseProcessResponse;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseProcessResponseBuilder {

	private final static Logger logger = LoggerFactory.getLogger(WarehouseProcessResponseBuilder.class);
	/**
	 * @param intgResp
	 * @return
	 */
	public WarehouseProcessResponse buildResponse(WarehouseIntgResponse intgResp) {
		logger.debug("Entering into the buildResponse method");
		logger.info("parameters" , intgResp);
		WarehouseProcessResponse response = new WarehouseProcessResponse();
		response.setRespCode(intgResp.getRespCode());
		response.setRespMsg(intgResp.getRespMsg());
		logger.debug("Exiting from the buildResponse method");
		return response ;
	}

}

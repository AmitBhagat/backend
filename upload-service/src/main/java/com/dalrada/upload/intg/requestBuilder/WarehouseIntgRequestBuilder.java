/**
 * 
 */
package com.dalrada.upload.intg.requestBuilder;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.entity.InvoiceMaster;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseIntgRequestBuilder {
	private final static Logger logger = LoggerFactory.getLogger(OrderIntgRequestBuilder.class);
	
	public InvoiceMaster buildRequest(List<String> last) {
		logger.debug("Entering into the buildRequest method");
		logger.info("parameters" , last);
		
		logger.debug("Exiting from the buildRequest method");
		return null;
	}

}

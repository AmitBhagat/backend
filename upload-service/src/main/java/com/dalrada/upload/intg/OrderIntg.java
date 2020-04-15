
/**
 * 
 */
package com.dalrada.upload.intg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beans.OrderIntgRequest;
import com.dalrada.upload.intg.beans.OrderIntgResponse;
import com.dalrada.upload.intg.exception.SystemException;
import com.dalrada.upload.intg.responseBuilder.OrderIntgResponseBuilder;
import com.dalrada.upload.intg.tasklet.OrderTasklet;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderIntg {

	private final static Logger logger = LoggerFactory.getLogger(OrderIntg.class);
	
	@Autowired
	OrderTasklet tasklet; 
	@Autowired
	OrderIntgResponseBuilder respBuilder ;

	public OrderIntgResponse uploadOrder(OrderIntgRequest request) throws SystemException{

		logger.debug("Entering into the uploadOrder method");
		logger.info("parameters" , request);
		OrderIntgResponse response ;
		try {
			tasklet.execute();
		} catch (Exception e) {
		// throw new SystemException("500", "file not uploaded successfully");
			
			e.printStackTrace();
		}
		
		response = respBuilder.buildResponse("200", "file uploaded successfully");
		logger.debug("Exiting from the uploadOrder method");
		return response;
	}
}


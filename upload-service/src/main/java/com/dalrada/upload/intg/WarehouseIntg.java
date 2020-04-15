package com.dalrada.upload.intg;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beans.WarehouseIntgRequest;
import com.dalrada.upload.intg.beans.WarehouseIntgResponse;
import com.dalrada.upload.intg.exception.BusinessException;
import com.dalrada.upload.intg.exception.SystemException;
import com.dalrada.upload.intg.requestBuilder.OrderIntgRequestBuilder;
import com.dalrada.upload.intg.responseBuilder.WarehouseIntgResponseBuilder;
import com.dalrada.upload.intg.tasklet.WarehouseTasklet;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseIntg{

	private final static Logger logger = LoggerFactory.getLogger(OrderIntgRequestBuilder.class);

	@Autowired
	WarehouseTasklet tasklet ;
	@Autowired
	WarehouseIntgResponseBuilder respBuilder ;

	public WarehouseIntgResponse uploadWarehouse(WarehouseIntgRequest intgRequest) throws SystemException, BusinessException, IOException {
		logger.debug("Entering into the uploadWarehouse method");
		logger.info("parameters" , intgRequest);

		try {
			tasklet.execute();
		} catch (Exception e) {
			throw new SystemException("500","file not uploaded successfully");
		}
		WarehouseIntgResponse response = respBuilder.buildResponse("200","file uploaded successfully");
		return response;	 
	}

}


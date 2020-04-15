/**
 * 
 */
package com.dalrada.upload.process;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.dalrada.upload.intg.WarehouseIntg;
import com.dalrada.upload.intg.beans.WarehouseIntgRequest;
import com.dalrada.upload.intg.beans.WarehouseIntgResponse;
import com.dalrada.upload.intg.exception.BusinessException;
import com.dalrada.upload.intg.exception.SystemException;
import com.dalrada.upload.process.beans.WarehouseProcessRequest;
import com.dalrada.upload.process.beans.WarehouseProcessResponse;
import com.dalrada.upload.process.requestBuilder.WarehouseProcessRequestBuilder;
import com.dalrada.upload.process.responseBuilder.WarehouseProcessResponseBuilder;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseProcess {

	private final WarehouseProcessResponseBuilder warehouseRespBuilder ;
	private final WarehouseProcessRequestBuilder warehouseReqBuilder ;
	private final WarehouseIntg warehouseIntg ;
	
	@Autowired
	public WarehouseProcess(WarehouseProcessResponseBuilder warehouseRespBuilder,
			WarehouseProcessRequestBuilder warehouseReqBuilder, WarehouseIntg warehouseIntg,
			WarehouseProcessResponseBuilder respBuilder, WarehouseProcessRequestBuilder reqBuilder) {
		super();
		this.warehouseRespBuilder = warehouseRespBuilder;
		this.warehouseReqBuilder = warehouseReqBuilder;
		this.warehouseIntg = warehouseIntg;
	}


	public WarehouseProcessResponse uploadWarehouse(@RequestBody WarehouseProcessRequest request) throws IllegalStateException, IOException,SystemException, BusinessException {
		WarehouseIntgRequest intgRequest = warehouseReqBuilder.buildRequest(request);
		WarehouseIntgResponse intgResp = warehouseIntg.uploadWarehouse(intgRequest);	
		WarehouseProcessResponse response = warehouseRespBuilder.buildResponse(intgResp);
		return response;
	}


	
}

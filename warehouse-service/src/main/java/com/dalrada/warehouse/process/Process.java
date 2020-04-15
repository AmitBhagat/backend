package com.dalrada.warehouse.process;

import java.util.List;

import com.dalrada.warehouse.process.beans.ProcessRequest;
import com.dalrada.warehouse.process.beans.ProcessResponse;
import com.dalrada.warehouse.process.requestBuilder.ProcessRequestBuilder;
import com.dalrada.warehouse.process.responseBuilder.ProcessResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.warehouse.integration.Integration;
import com.dalrada.warehouse.integration.beans.IntgRequest;
import com.dalrada.warehouse.integration.beans.IntgResponse;
import com.dalrada.warehouse.integration.exception.BusinessException;
import com.dalrada.warehouse.integration.exception.SystemException;

@Component
public class Process {

	ProcessRequestBuilder requestBuilder;
	Integration Intg;
	ProcessResponseBuilder responseBuilder;
	private static final Logger logger = LoggerFactory.getLogger(Process.class);
	@Autowired
	public Process(ProcessRequestBuilder requestBuilder, Integration intg,
				   ProcessResponseBuilder responseBuilder) {
		super();
		this.requestBuilder = requestBuilder;
		Intg = intg;
		this.responseBuilder = responseBuilder;
	}
	public ProcessResponse getWarehouseById( Integer warehouseCode) throws BusinessException, SystemException {
		logger.debug("enter into getWarehouseById method");
		IntgResponse intgResponse = Intg.getWarehouseById(warehouseCode);
		ProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from getWarehouseById method");
		return processResponse;
	}
	public List<ProcessResponse> getAllWarehouse() throws BusinessException, SystemException {
		logger.debug("enter into getAllWarehouse method");
		List<IntgResponse> intgRespList = Intg.getAllWarehouses();
		List<ProcessResponse> processRespList = responseBuilder.buildResponse(intgRespList);
		logger.debug("exit from getAllWarehouse method");
		return processRespList;
	}


	public ProcessResponse createWarehouse(ProcessRequest processRequest) throws BusinessException, SystemException {
		logger.debug("enter into createWarehouse method");
		IntgRequest intgRequest = requestBuilder.buildRequest(processRequest);
		IntgResponse intgResponse = Intg.createWarehouse(intgRequest);
		ProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from createWarehouse method");
		return processResponse;
	}

	public ProcessResponse editWarehouse(ProcessRequest processRequest) throws BusinessException, SystemException {
		logger.debug("enter into editWarehouse method");
		IntgRequest intgRequest = requestBuilder.buildRequest(processRequest);
		IntgResponse intgResponse = Intg.editWarehouse(intgRequest);
		ProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from editWarehouse method");
		return processResponse;
	}

    public ProcessResponse changeStatus(long warehouseId,int status) throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		IntgResponse intgResponse = Intg.changeStatus(warehouseId,status);
		ProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from changeStatus method");
		return processResponse;
    }
}

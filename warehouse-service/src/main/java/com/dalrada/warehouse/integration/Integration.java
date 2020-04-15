package com.dalrada.warehouse.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.dalrada.warehouse.integration.beans.IntgRequest;
import com.dalrada.warehouse.integration.beans.IntgResponse;
import com.dalrada.warehouse.integration.entity.WarehouseEntity;
import com.dalrada.warehouse.integration.exception.BusinessException;
import com.dalrada.warehouse.integration.exception.SystemException;
import com.dalrada.warehouse.integration.repository.WarehouseRepository;
import com.dalrada.warehouse.integration.requestBuilder.IntgRequestBuilder;
import com.dalrada.warehouse.integration.responseBuilder.IntgResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Integration {

	IntgRequestBuilder requestBuilder ;
	WarehouseRepository repository ;
	IntgResponseBuilder responseBuilder ;
	private static final Logger logger = LoggerFactory.getLogger(Integration.class);
	@Autowired
	public Integration(IntgRequestBuilder requestBuilder, WarehouseRepository repository,
					   IntgResponseBuilder responseBuilder) {
		this.requestBuilder = requestBuilder;
		this.repository = repository;
		this.responseBuilder = responseBuilder;
	}

	public IntgResponse getWarehouseById(Integer warehouseCode) throws BusinessException, SystemException {
		logger.debug("enter into getWarehouseById method");
		WarehouseEntity warehouse;
		try {
			warehouse = repository.getWarehouseByCode(warehouseCode);
					} catch (RuntimeException e) {
			logger.error("Exception occurred due to " ,e);
			throw new SystemException("","");	
		}
		if(warehouse != null) {
			IntgResponse intgResponse = responseBuilder.buildResponse(warehouse);
			logger.debug("exit from getWarehouseById method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not present");
	}

	public List<IntgResponse> getAllWarehouses() throws BusinessException, SystemException {
		logger.debug("enter into getAllWarehouses method");
		List<WarehouseEntity> warehouseList;
		try {
			warehouseList = repository.findAll();
		} catch (RuntimeException e) {
			logger.error("Exception occurred  " ,e);
			throw new SystemException("","");	
		}
		List<IntgResponse> responseList = new ArrayList<IntgResponse>();
		if(warehouseList != null) {
			warehouseList.forEach(warehouse ->{
				IntgResponse intgResponse = responseBuilder.buildResponse(warehouse);
				responseList.add(intgResponse);
			});
			logger.debug("exit from getAllWarehouses method");
			List<IntgResponse> activeResponseList = responseList.stream()
					.filter(response -> response.getRespBody().getStatus()==1)
					.collect(Collectors.toList());
			return activeResponseList;
		}
		else
			throw new BusinessException("505","data not present");
	}
	public IntgResponse createWarehouse(IntgRequest intgRequest) throws BusinessException, SystemException {
		logger.debug("enter into createWarehouse method");
		WarehouseEntity warehouse = requestBuilder.buildRequest(intgRequest);
		WarehouseEntity entity;
		try {
			entity = repository.save(warehouse);
		} catch (RuntimeException e) {
			logger.error("Exception occurred  " ,e);
			throw new SystemException("","");
		}
		if(entity != null) {
			IntgResponse intgResponse = responseBuilder.buildResponse(warehouse);
			logger.debug("exit from createWarehouse method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not saved");
	}

	public IntgResponse editWarehouse(IntgRequest intgRequest) throws BusinessException, SystemException {
		logger.debug("enter into editWarehouse method");
		WarehouseEntity warehouse = null ;
		WarehouseEntity entity = null;
		Long warehouseId = intgRequest.getWarehouseId();
		try {
			entity = repository.findById(warehouseId).get();
			warehouse = requestBuilder.buildRequest(entity,intgRequest);
			entity =repository.save(warehouse);
		} catch (RuntimeException e) {
			logger.error("Exception occurred  " ,e);
			throw new SystemException("","");
		}
		catch (Exception e) {
			throw new BusinessException("","");
		}
		if(entity != null) {
			IntgResponse intgResponse = responseBuilder.buildResponse(warehouse);
			logger.debug("exit from editWarehouse method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not updated");
	}

	public IntgResponse changeStatus(long warehouseId,int status) throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		WarehouseEntity entity = null;
		try {
			WarehouseEntity warehouse = repository.findById(warehouseId).get();
			warehouse.setStatus(status);
			entity =repository.save(warehouse);
		} catch (RuntimeException e) {
			logger.error("Exception occurred  " ,e);
			throw new SystemException("","");
		}
		catch (Exception e) {
			throw new BusinessException("","");
		}
		if(entity != null) {
			IntgResponse intgResponse = responseBuilder.buildResponse(entity);
			logger.debug("exit from changeStatus method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","Status not updated");
	}

}

package com.dalrada.warehouse.integration.requestBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.warehouse.integration.beans.IntgRequest;
import com.dalrada.warehouse.integration.entity.WarehouseEntity;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class IntgRequestBuilder {
	private static final Logger logger = LoggerFactory.getLogger(IntgRequestBuilder.class);
	public WarehouseEntity buildRequest(IntgRequest intgRequest) {
		logger.debug("enter into buildRequest method");
		WarehouseEntity entity  = new WarehouseEntity();
		entity.setWarehouseName(intgRequest.getWarehouseName());
		entity.setWarehouseAddress(intgRequest.getWarehouseAddress());
		entity.setWarehouseCode(intgRequest.getWarehouseCode());
		entity.setStatus(intgRequest.getStatus());
		entity.setCreatedBy(intgRequest.getCreatedBy());
		LocalDate currentDate = LocalDate.now();
		entity.setCreatedDate(Date.valueOf(currentDate));
		logger.debug("exit from buildRequest method");
		return entity;
	}

	public WarehouseEntity buildRequest(WarehouseEntity entity, IntgRequest intgRequest){
		logger.debug("enter into editWarehouse method");
		entity.setWarehouseName(intgRequest.getWarehouseName());
		entity.setWarehouseAddress(intgRequest.getWarehouseAddress());
		entity.setWarehouseCode(intgRequest.getWarehouseCode());
		logger.debug("exit from editWarehouse method");
		return entity;
	}


}

package com.dalrada.warehouse.resource;

import java.util.List;

import com.dalrada.warehouse.integration.exception.BusinessException;
import com.dalrada.warehouse.integration.exception.SystemException;
import com.dalrada.warehouse.process.Process;
import com.dalrada.warehouse.process.beans.ProcessRequest;
import com.dalrada.warehouse.process.beans.ProcessResponse;
import com.dalrada.warehouse.resource.beans.ResourceRequest;
import com.dalrada.warehouse.resource.beans.ResourceResponse;
import com.dalrada.warehouse.resource.requestBuilder.ResourceRequestBuilder;
import com.dalrada.warehouse.resource.responseBuilder.ResourceResponseBuilder;
import com.dalrada.warehouse.resource.validator.RequestValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@Api(value = "Warehouse Service API")
public class Resource {
	
	ResourceRequestBuilder requestBuilder;
	Process process;
	ResourceResponseBuilder responsebuilder;
	RequestValidator requestValidator ;
	private static final Logger logger = LoggerFactory.getLogger(Resource.class);
	@Autowired
	public Resource(ResourceRequestBuilder requestBuilder, Process process,
					ResourceResponseBuilder responsebuilder, RequestValidator requestValidator) {
		super();
		this.requestBuilder = requestBuilder;
		this.process = process;
		this.responsebuilder = responsebuilder;
		this.requestValidator = requestValidator;
	}

	@GetMapping("warehouses/{warehouseCode}")
	@ApiOperation(value = "Get Warehouse By Id API")
	public Mono<ResourceResponse> getUserById(@PathVariable Integer warehouseCode) throws BusinessException, SystemException {
		logger.debug("enter into getWarehouseById method");
		requestValidator.validate(warehouseCode);
		ProcessResponse processResponse = process.getWarehouseById(warehouseCode);
		ResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from getWarehouseById method");
		return Mono.just(resourceResponse);
	}
	
	@GetMapping("warehouses")
	@ApiOperation(value = "Get All Warehouse API")
	public Flux<ResourceResponse> getAllWarehouses() throws BusinessException, SystemException {
		logger.debug("enter into getAllWarehouses method");
		List<ProcessResponse> processRespList = process.getAllWarehouse();
		List<ResourceResponse> resourceRespList = responsebuilder.buildResponse(processRespList);
		logger.debug("exit from getAllWarehouses method");
		return Flux.fromIterable(resourceRespList);
	}
	@PostMapping("warehouses/create")
	@ApiOperation(value = "Warehouse Creating API")
	public Mono<ResourceResponse> createWarehouse(@RequestBody ResourceRequest resourceRequest) throws BusinessException, SystemException {
		logger.debug("enter into createWarehouse method");
		requestValidator.validate(resourceRequest);
		ProcessRequest processRequest = requestBuilder.buildRequest(resourceRequest);
		ProcessResponse processResponse = process.createWarehouse(processRequest);
		ResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from createWarehouses method");
		return Mono.just(resourceResponse);
	}
	@PostMapping("warehouses/edit")
	@ApiOperation(value = "Warehouse Editing API")
	public Mono<ResourceResponse> editWarehouse(@RequestBody ResourceRequest resourceRequest) throws BusinessException, SystemException {
		logger.debug("enter into editWarehouse method");
		requestValidator.validate(resourceRequest);
		ProcessRequest processRequest = requestBuilder.buildRequest(resourceRequest);
		ProcessResponse processResponse = process.editWarehouse(processRequest);
		ResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from editWarehouse method");
		return Mono.just(resourceResponse);
	}
	@PostMapping("warehouses/{warehouseId}/{status}")
	@ApiOperation(value = "Status Creating API")
	public Mono<ResourceResponse> changeStatus(@PathVariable long warehouseId, @PathVariable int status)  throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		ProcessResponse processResponse = process.changeStatus(warehouseId,status);
		ResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from editUser method");
		return Mono.just(resourceResponse);
	}


	@GetMapping("warehouses/healthStatus")
	@ApiOperation(value = "Health Checking API")
	public Mono<String> getHealth() {

		return Mono.just("Service is up and running");
	}

}


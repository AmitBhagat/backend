package com.dalrada.upload.resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.dalrada.upload.intg.exception.BusinessException;
import com.dalrada.upload.intg.exception.SystemException;
import com.dalrada.upload.process.WarehouseProcess;
import com.dalrada.upload.process.beans.WarehouseProcessRequest;
import com.dalrada.upload.process.beans.WarehouseProcessResponse;
import com.dalrada.upload.resource.beans.UploadResponse;
import com.dalrada.upload.resource.beans.WarehouseResourceRequest;
import com.dalrada.upload.resource.exception.InvalidRequestException;
import com.dalrada.upload.resource.requestBuilder.WarehouseResourceRequestBuilder;
import com.dalrada.upload.resource.responseBuilder.WarehouseResourceResponseBuilder;
import com.dalrada.upload.resource.validator.WarehouseResourceValidator;
import com.dalrada.upload.util.WarehouseConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@RestController
@Api(value = "Warehouse File Upload Controller")
public class WarehouseResource{

	private final static Logger logger = LoggerFactory.getLogger(WarehouseResource.class);
	private final WarehouseResourceResponseBuilder warehouseRespBuilder ;
	private final WarehouseResourceRequestBuilder warehouseReqBuilder ;
	private final WarehouseResourceValidator wareHouseValidator ;
	private final WarehouseProcess warehouseProcess ;

	@Autowired
	public WarehouseResource(WarehouseResourceResponseBuilder warehouseRespBuilder, WarehouseResourceRequestBuilder warehouseReqBuilder,
			WarehouseResourceValidator wareHouseValidator, WarehouseProcess warehouseProcess) {
		super();
		this.warehouseRespBuilder = warehouseRespBuilder;
		this.warehouseReqBuilder = warehouseReqBuilder;
		this.wareHouseValidator = wareHouseValidator;
		this.warehouseProcess = warehouseProcess;
	}



	@PostMapping( path = "warehouse",consumes = {"multipart/form-data"} )
	@ApiOperation(value = "Warehouse Details File Upload File Service" , 
	consumes = "application/multipart", httpMethod = "POST" )
	public Mono<UploadResponse> uploadWarehouse(
			@RequestPart("file") FilePart file , @RequestPart("id") String id ) 
					throws IllegalStateException, IOException,SystemException, BusinessException, InvalidRequestException {
		logger.debug("Entering into the resource uploadWarehouse method");
		System.out.println("Entering into the resource uploadWarehouse method");
		File warehouseFile = convertFile(file);
		WarehouseResourceRequest request = new WarehouseResourceRequest();
		request.setFile(warehouseFile);
		request.setId(id);
		Resource resource = new FileSystemResource(request.getFile().getAbsolutePath());
		WarehouseConstants.setConstants(resource , request.getId());
		WarehouseProcessRequest processRequest = warehouseReqBuilder.buildRequest(request);

		WarehouseProcessResponse processRespList = warehouseProcess.uploadWarehouse(processRequest);

		UploadResponse response = warehouseRespBuilder.buildResponse(processRespList);
		logger.debug("Exiting from the uploadWarehouse method");
		return Mono.just(response);

	}



	private File convertFile(FilePart file) throws SystemException {
		String fileName = file.filename();
		Path filePath ;
		try {
			filePath = Files.createTempFile(fileName, ".csv");
			file.transferTo(filePath);
		} catch (IOException e) {
		 throw new SystemException("500","file conversion error");
		}
		File warehouseFile =new File(filePath.toUri());
		return warehouseFile;
	}
	
	@GetMapping("/msg")
	public String msg() {
		return "service up and running";
	}
}

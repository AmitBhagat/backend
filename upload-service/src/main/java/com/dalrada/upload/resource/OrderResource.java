package com.dalrada.upload.resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.dalrada.upload.intg.exception.SystemException;
import com.dalrada.upload.process.OrderProcess;
import com.dalrada.upload.process.beans.OrderProcessRequest;
import com.dalrada.upload.process.beans.OrderProcessResponse;
import com.dalrada.upload.resource.beans.OrderResourceRequest;
import com.dalrada.upload.resource.beans.UploadResponse;
import com.dalrada.upload.resource.requestBuilder.OrderResourceRequestBuilder;
import com.dalrada.upload.resource.responseBuilder.OrderResourceResponseBuilder;
import com.dalrada.upload.resource.validator.OrderResourceValidator;
import com.dalrada.upload.util.OrderConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@RestController
@Api(value = "Order File Upload Controller")
public class OrderResource{

	private final static Logger logger = LoggerFactory.getLogger(OrderResource.class);
	private final OrderResourceResponseBuilder orderRespBuilder ;
	private final OrderResourceRequestBuilder orderReqBuilder ;
	private final OrderResourceValidator orderValidator ;
	private final OrderProcess orderProcess ;

	@Autowired
	public OrderResource(OrderResourceResponseBuilder orderRespBuilder, OrderResourceRequestBuilder orderReqBuilder,
			OrderResourceValidator orderValidator, OrderProcess orderProcess) {
		super();
		this.orderRespBuilder = orderRespBuilder;
		this.orderReqBuilder = orderReqBuilder;
		this.orderValidator = orderValidator;
		this.orderProcess = orderProcess;
	}

	@PostMapping( path = "orders",consumes = {"multipart/form-data"})
	@ApiOperation(value = "Order Details File Upload Service" , 
	consumes = "multipart/form-data", httpMethod = "POST" )
	public Mono<UploadResponse> uploadOrder(@RequestPart("file") FilePart file ,
			@RequestPart("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate ,
			@RequestPart("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate lastDate) throws IllegalStateException, IOException, SystemException {
		File orderDetailsFile = convertFile(file);
		OrderResourceRequest request  = new OrderResourceRequest();
		request.setFile(orderDetailsFile);
		request.setStartDate(startDate);
		request.setLastDate(lastDate);
		Resource resource = new FileSystemResource(request.getFile().getAbsolutePath());
		OrderConstants.setResource(resource);
		OrderConstants.setToDate(request.getStartDate());
		OrderConstants.setFromDate(request.getLastDate());
		logger.debug("Entering into the uploadOrder method");
		logger.info("parameters" , request);
		orderValidator.validate(request);


		OrderProcessRequest processRequest = orderReqBuilder.buildRequest(request);
		OrderProcessResponse processResp = orderProcess.uploadOrder(processRequest);
		UploadResponse response = orderRespBuilder.buildResponse(processResp);

		logger.debug("Exiting from the uploadOrder method");
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
	
}

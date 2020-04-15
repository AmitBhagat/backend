package com.dalrada.reconcile.resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dalrada.reconcile.integration.exception.BusinessException;
import com.dalrada.reconcile.integration.exception.SystemException;
import com.dalrada.reconcile.process.ReconcileProcess;
import com.dalrada.reconcile.process.beans.ReconcileProcessResponse;
import com.dalrada.reconcile.resource.beans.ReconcileResourceResponse;
import com.dalrada.reconcile.resource.exception.InvalidRequestException;
import com.dalrada.reconcile.resource.responseBuilder.ReconcileResourceResponseBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * @author Sneha
 *
 */
//used to create the restful web service 
@RestController
@Api(value = "Reconcile Service")
public class ReconcileResource {
	
	ReconcileProcess process;
	ReconcileResourceResponseBuilder responsebuilder;
	List<ReconcileResourceResponse> resourceRespList ;
	private static final Logger logger = LoggerFactory.getLogger(ReconcileResource.class);
	
	@Autowired
	public ReconcileResource(ReconcileProcess process,
			ReconcileResourceResponseBuilder responsebuilder ) {
		super();
		this.process = process;
		this.responsebuilder = responsebuilder;
	}

	
	@GetMapping("orders/{startDate}/{endDate}")
	@ApiOperation(value = "Get Order By Date API")
	public Flux<ReconcileResourceResponse> getAllOrders(@PathVariable String startDate ,@PathVariable String endDate)  throws BusinessException, SystemException, InvalidRequestException {
		logger.debug("enter into getAllUsers method");
		System.out.println("reconcile service called");
		List<ReconcileProcessResponse> processRespList = process.getAllOrders(startDate , endDate);
		resourceRespList = responsebuilder.buildResponse(processRespList);
		logger.debug("exit from getAllUsers method");
		return Flux.fromIterable(resourceRespList);
	}

	@GetMapping("orders/download")
	@ApiOperation(value = "Download Order File API")
	public ResponseEntity<Resource> download(String param) throws IOException {

		List<String> lines = resourceRespList.stream()
				.sorted(Comparator.comparing(record -> record.getRespBody().getSrNo()))
				.map(order -> toLine(order)).collect(Collectors.toList());
		
		Path path = Files.createTempFile("order", ".csv");
		Files.write(path, lines, StandardOpenOption.APPEND);
		File file = path.toFile();
	    
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
		
		HttpHeaders header = new HttpHeaders();
	        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=order.csv");
	        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        header.add("Pragma", "no-cache");
	        header.add("Expires", "0");
	    
	        return ResponseEntity.ok()
	            .contentLength(file.length())
	            .headers(header)
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .body(resource);
	}
	
	private String toLine(ReconcileResourceResponse response) {
		
		return response.getRespBody().toString();
	}


	@GetMapping("orders/healthStatus")
	public Mono<String> getHealth() {
		return Mono.just("Service is up and running");
	}

}


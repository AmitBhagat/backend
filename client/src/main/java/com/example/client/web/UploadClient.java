package com.example.client.web;

import java.io.File;
import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@RestController
@Api(value = "Upload Client Application")
public class UploadClient {

	
	@GetMapping("healthcheck")
	@ApiOperation(value = "Health Check Service" , response = String.class)
	public String upload() {
		WebClient client = WebClient.create("http://localhost:8082/healthCheck");
		Mono<String> msg = client.post().bodyValue("amit")
				.retrieve().bodyToMono(String.class);
		msg.subscribe(System.out::println);
		return "service is called";
		
	}
	
	@GetMapping("order")
	@ApiOperation(value = "Order File Upload Service" , response = Mono.class)
	public Mono<String> order() {
		WebClient client = WebClient.create("http://localhost:8082/orders");
		OrderResourceRequest request = new OrderResourceRequest();
		request.setFile(new File("D:\\Dalrada Microservice\\Files\\order-export.03-04-2020.csv"));
		request.setStartDate(LocalDate.now());
		request.setLastDate(LocalDate.now());
		Mono<String> msg = client.post().contentType(MediaType.APPLICATION_JSON).bodyValue(request)
				.retrieve().bodyToMono(String.class);
		return msg;
	}
	
	@GetMapping("warehouse")
	@ApiOperation(value = "Warehouse File Upload Service" , response = Mono.class)
	public Mono<String> warehouse() {
		WebClient client = WebClient.create("http://localhost:8082/warehouse");
		WarehouseResourceRequest request = new WarehouseResourceRequest();
		request.setFile(new File("D:\\Dalrada Microservice\\Files\\42_23223_2019112821361.csv"));
		request.setId("23223");
		Mono<String> msg = client.post().contentType(MediaType.APPLICATION_JSON).bodyValue(request)
				.retrieve().bodyToMono(String.class);
		return msg;
		
	}
}

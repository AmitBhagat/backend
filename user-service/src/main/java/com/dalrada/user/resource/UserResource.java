package com.dalrada.user.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrada.user.integration.exception.BusinessException;
import com.dalrada.user.integration.exception.SystemException;
import com.dalrada.user.process.Process;
import com.dalrada.user.process.beans.UserProcessRequest;
import com.dalrada.user.process.beans.UserProcessResponse;
import com.dalrada.user.resource.beans.UserResourceRequest;
import com.dalrada.user.resource.beans.UserResourceResponse;
import com.dalrada.user.resource.exception.InvalidRequestException;
import com.dalrada.user.resource.requestBuilder.ResourceRequestBuilder;
import com.dalrada.user.resource.responseBuilder.ResourceResponseBuilder;
import com.dalrada.user.resource.validator.RequestValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@Api(value = "USER-SERVICE")
@RequestMapping("userResource")
public class UserResource {
	
	ResourceRequestBuilder requestBuilder;
	Process process;
	ResourceResponseBuilder responsebuilder;
	RequestValidator requestValidator ;
	private static final Logger logger = LoggerFactory.getLogger(UserResource.class);
	@Autowired
	public UserResource(ResourceRequestBuilder requestBuilder, Process process,
			ResourceResponseBuilder responsebuilder, RequestValidator requestValidator) {
		super();
		this.requestBuilder = requestBuilder;
		this.process = process;
		this.responsebuilder = responsebuilder;
		this.requestValidator = requestValidator;
	}

	@GetMapping("users/id/{userId}")
	@ApiOperation(value = "GET USER BY ID API")
	public Mono<UserResourceResponse> getUserById(@PathVariable Long userId) throws BusinessException, SystemException, InvalidRequestException {
		logger.debug("enter into getUserById method");
		requestValidator.userValidate(userId);
		UserProcessResponse processResponse = process.getUserById(userId);
		UserResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from getUserById method");
		return Mono.just(resourceResponse);	
	}
	
	@GetMapping("users/name/{userName}")
	@ApiOperation(value = "GET USER BY ID API")
	public Mono<UserResourceResponse> getUserByName(@PathVariable String userName) throws BusinessException, SystemException, InvalidRequestException {
		logger.debug("enter into getUserById method");
		requestValidator.validate(userName);
		UserProcessResponse processResponse = process.getUserByName(userName);
		UserResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from getUserById method");
		return Mono.just(resourceResponse);	
	}
	
	@GetMapping("users")
	@ApiOperation(value = "GET ALL USER API")
	public Flux<UserResourceResponse> getAllUsers() throws BusinessException, SystemException {
		logger.debug("enter into getAllUsers method");
		List<UserProcessResponse> processRespList = process.getAllUser();
		List<UserResourceResponse> resourceRespList = responsebuilder.userBuildResponse(processRespList);
		logger.debug("exit from getAllUsers method");
		return Flux.fromIterable(resourceRespList);	
	}
	@PostMapping("users/create")
	@ApiOperation(value = "CREATE USER API")
	public Mono<UserResourceResponse> createUser(@RequestBody UserResourceRequest resourceRequest) throws BusinessException, SystemException, InvalidRequestException {
		logger.debug("enter into createUser method");
		requestValidator.validate(resourceRequest);
		UserProcessRequest processRequest = requestBuilder.buildRequest(resourceRequest);
		UserProcessResponse processResponse = process.createUser(processRequest);
		UserResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from createUsers method");
		return Mono.just(resourceResponse);	
	}
	@PostMapping("users/edit")
	@ApiOperation(value = "EDIT USER API")
	public Mono<UserResourceResponse> editUser(@RequestBody UserResourceRequest resourceRequest) throws BusinessException, SystemException, InvalidRequestException {
		logger.debug("enter into editUser method");
		requestValidator.validate(resourceRequest);
		System.out.println(resourceRequest);
		UserProcessRequest processRequest = requestBuilder.buildRequest(resourceRequest);
		UserProcessResponse processResponse = process.editUser(processRequest);
		UserResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from editUser method");
		return Mono.just(resourceResponse);
		 
	}
	@PostMapping("users/{userId}/{status}")
	@ApiOperation(value = "EDIT STATUS API")
	public Mono<UserResourceResponse> changeStatus(@PathVariable Long userId, @PathVariable int status) throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		UserProcessResponse processResponse = process.changeStatus(userId,status);
		UserResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from changeStatus method");
		return Mono.just(resourceResponse);
	}
}


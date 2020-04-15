package com.dalrada.user.resource;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dalrada.user.process.Process;
import com.dalrada.user.integration.exception.BusinessException;
import com.dalrada.user.integration.exception.SystemException;
import com.dalrada.user.process.beans.RoleProcessRequest;
import com.dalrada.user.process.beans.RoleProcessResponse;
import com.dalrada.user.resource.beans.RoleResourceRequest;
import com.dalrada.user.resource.beans.RoleResourceResponse;
import com.dalrada.user.resource.exception.InvalidRequestException;
import com.dalrada.user.resource.requestBuilder.ResourceRequestBuilder;
import com.dalrada.user.resource.responseBuilder.ResourceResponseBuilder;
import com.dalrada.user.resource.validator.RequestValidator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@Api(value = "Role Service API")
@RequestMapping("roleResource")
public class RoleResource {
	
	ResourceRequestBuilder requestBuilder;
	Process process;
	ResourceResponseBuilder responsebuilder;
	RequestValidator requestValidator ;
	private static final Logger logger = LoggerFactory.getLogger(RoleResource.class);
	@Autowired
	public RoleResource(ResourceRequestBuilder requestBuilder, Process process,
					ResourceResponseBuilder responsebuilder, RequestValidator requestValidator) {
		this.requestBuilder = requestBuilder;
		this.process = process;
		this.responsebuilder = responsebuilder;
		this.requestValidator = requestValidator;
	}

	@GetMapping("roles/{roleId}")
	@ApiOperation(value = "Get Role By Id API")
	public Mono<RoleResourceResponse> getUserById(@PathVariable Long roleId) throws BusinessException, SystemException, InvalidRequestException {
		logger.debug("enter into getRoleById method");
		requestValidator.roleValidate(roleId);
		RoleProcessResponse processResponse = process.getRoleById(roleId);
		RoleResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from getRoleById method");
		return Mono.just(resourceResponse);
	}
	
	@GetMapping("roles")
	@ApiOperation(value = "Get All Role API")
	public Flux<RoleResourceResponse> getAllRoles() throws BusinessException, SystemException {
		logger.debug("enter into getAllRoles method");
		List<RoleProcessResponse> processRespList = process.getAllRole();
		List<RoleResourceResponse> resourceRespList = responsebuilder.roleBuildResponse(processRespList);
		logger.debug("exit from getAllRoles method");
		return Flux.fromIterable(resourceRespList);
	}
	@PostMapping("roles/create")
	@ApiOperation(value = "Role Creating API")
	public Mono<RoleResourceResponse> createRole(@RequestBody RoleResourceRequest resourceRequest) throws BusinessException, SystemException, InvalidRequestException {
		logger.debug("enter into createRole method");
		requestValidator.validate(resourceRequest);
		RoleProcessRequest processRequest = requestBuilder.buildRequest(resourceRequest);
		RoleProcessResponse processResponse = process.createRole(processRequest);
		RoleResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from createRoles method");
		return Mono.just(resourceResponse);
	}
	@PostMapping("roles/edit")
	@ApiOperation(value = "Role Editing API")
	public Mono<RoleResourceResponse> editUser(@RequestBody RoleResourceRequest resourceRequest) throws BusinessException, SystemException, InvalidRequestException {
		logger.debug("enter into editRole method");
		requestValidator.validate(resourceRequest);
		RoleProcessRequest processRequest = requestBuilder.buildRequest(resourceRequest);
		RoleProcessResponse processResponse = process.editRole(processRequest);
		RoleResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from editRole method");
		return Mono.just(resourceResponse);
	}
	@PostMapping("roles/{roleId}/{status}")
	@ApiOperation(value = "Status Creating API")
	public Mono<RoleResourceResponse> changeStatus(@PathVariable long roleId, @PathVariable int status)  throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		RoleProcessResponse processResponse = process.changeStatus(roleId,status);
		RoleResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from editUser method");
		return Mono.just(resourceResponse);
	}
}


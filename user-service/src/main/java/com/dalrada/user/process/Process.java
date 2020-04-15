package com.dalrada.user.process;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dalrada.user.integration.Integration;
import com.dalrada.user.integration.beans.RoleIntgRequest;
import com.dalrada.user.integration.beans.RoleIntgResponse;
import com.dalrada.user.integration.beans.UserIntgRequest;
import com.dalrada.user.integration.beans.UserIntgResponse;
import com.dalrada.user.integration.exception.BusinessException;
import com.dalrada.user.integration.exception.SystemException;
import com.dalrada.user.process.beans.RoleProcessRequest;
import com.dalrada.user.process.beans.RoleProcessResponse;
import com.dalrada.user.process.beans.UserProcessRequest;
import com.dalrada.user.process.beans.UserProcessResponse;
import com.dalrada.user.process.requestBuilder.UserProcessRequestBuilder;
import com.dalrada.user.process.responseBuilder.UserProcessResponseBuilder;

@Component
public class Process {

	UserProcessRequestBuilder requestBuilder;
	Integration Intg;
	UserProcessResponseBuilder responseBuilder;
	private static final Logger logger = LoggerFactory.getLogger(Process.class);
	@Autowired
	public Process(UserProcessRequestBuilder requestBuilder, Integration intg,
			UserProcessResponseBuilder responseBuilder) {
		super();
		this.requestBuilder = requestBuilder;
		Intg = intg;
		this.responseBuilder = responseBuilder;
	}
	public UserProcessResponse getUserById(Long userId) throws BusinessException, SystemException {
		logger.debug("enter into getUserById method");
		UserIntgResponse intgResponse = Intg.getUserById(userId);
		UserProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from getUserById method");
		return processResponse;
	}
	
	public UserProcessResponse getUserByName(String userName) throws BusinessException, SystemException {
		logger.debug("enter into getUserById method");
		UserIntgResponse intgResponse = Intg.getUserByName(userName);
		UserProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from getUserById method");
		return processResponse;
	}
	
	public List<UserProcessResponse> getAllUser() throws BusinessException, SystemException {
		logger.debug("enter into getAllUsers method");
		List<UserIntgResponse> intgRespList = Intg.getAllUsers();
		List<UserProcessResponse> processRespList = responseBuilder.userBuildResponse(intgRespList);
		logger.debug("exit from getAllUsers method");
		return processRespList;
	}


	public UserProcessResponse createUser(UserProcessRequest processRequest) throws BusinessException, SystemException {
		logger.debug("enter into createUser method");
		UserIntgRequest intgRequest = requestBuilder.buildRequest(processRequest);
		UserIntgResponse intgResponse = Intg.createUser(intgRequest);
		UserProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from createUser method");
		return processResponse;
	}

	public UserProcessResponse editUser(UserProcessRequest processRequest) throws BusinessException, SystemException {
		logger.debug("enter into editUser method");
		UserIntgRequest intgRequest = requestBuilder.buildRequest(processRequest);
		UserIntgResponse intgResponse = Intg.editUser(intgRequest);
		UserProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from editUser method");
		return processResponse;
	}
	public UserProcessResponse changeStatus(Long userId, int status) throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		UserIntgResponse intgResponse = Intg.changeStatus(userId,status);
		UserProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from changeStatus method");
		return processResponse;
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

	public RoleProcessResponse getRoleById(Long roleId) throws BusinessException, SystemException {
		logger.debug("enter into getRoleById method");
		RoleIntgResponse intgResponse = Intg.getRoleById(roleId);
		RoleProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from getRoleById method");
		return processResponse;
	}
	public List<RoleProcessResponse> getAllRole() throws BusinessException, SystemException {
		logger.debug("enter into getAllRoles method");
		List<RoleIntgResponse> intgRespList = Intg.getAllRoles();
		List<RoleProcessResponse> processRespList = responseBuilder.roleBuildResponse(intgRespList);
		logger.debug("exit from getAllRoles method");
		return processRespList;
	}


	public RoleProcessResponse createRole(RoleProcessRequest processRequest) throws BusinessException, SystemException {
		logger.debug("enter into createRole method");
		RoleIntgRequest intgRequest = requestBuilder.buildRequest(processRequest);
		RoleIntgResponse intgResponse = Intg.createRole(intgRequest);
		RoleProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from createRole method");
		return processResponse;
	}

	public RoleProcessResponse editRole(RoleProcessRequest processRequest) throws BusinessException, SystemException {
		logger.debug("enter into editRole method");
		RoleIntgRequest intgRequest = requestBuilder.buildRequest(processRequest);
		RoleIntgResponse intgResponse = Intg.editRole(intgRequest);
		RoleProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from editRole method");
		return processResponse;
	}

    public RoleProcessResponse changeStatus(long roleId,int status) throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		RoleIntgResponse intgResponse = Intg.changeStatus(roleId,status);
		RoleProcessResponse processResponse = responseBuilder.buildResponse(intgResponse);
		logger.debug("exit from changeStatus method");
		return processResponse;
    }


}

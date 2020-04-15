package com.dalrada.user.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.user.integration.beans.RoleIntgRequest;
import com.dalrada.user.integration.beans.RoleIntgResponse;
import com.dalrada.user.integration.beans.UserIntgRequest;
import com.dalrada.user.integration.beans.UserIntgResponse;
import com.dalrada.user.integration.entity.Role;
import com.dalrada.user.integration.entity.User;
import com.dalrada.user.integration.exception.BusinessException;
import com.dalrada.user.integration.exception.SystemException;
import com.dalrada.user.integration.repository.RoleRepository;
import com.dalrada.user.integration.repository.UserRepository;
import com.dalrada.user.integration.requestBuilder.UserIntgRequestBuilder;
import com.dalrada.user.integration.responseBuilder.UserIntgResponseBuilder;

@Component
public class Integration {

	UserIntgRequestBuilder requestBuilder ;
	UserRepository repository ;
	UserIntgResponseBuilder responseBuilder ;
	RoleRepository roleRepository;
	private static final Logger logger = LoggerFactory.getLogger(Integration.class);
	@Autowired
	public Integration(UserIntgRequestBuilder requestBuilder, UserRepository repository,
			UserIntgResponseBuilder responseBuilder, RoleRepository roleRepository) {
		super();
		this.requestBuilder = requestBuilder;
		this.repository = repository;
		this.responseBuilder = responseBuilder;
		this.roleRepository = roleRepository;
	}

	public UserIntgResponse getUserById(Long userId) throws BusinessException, SystemException {
		logger.debug("enter into getUserById method");
		User user;
		try {
			user = repository.findById(userId).get();
		} catch (RuntimeException e) {
			logger.error("Exception occured due to " ,e);
			throw new SystemException("","");	
		}
		if(user != null) {
			UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
			logger.debug("exit from getUserById method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not persent");
	}
	



	public UserIntgResponse getUserByName(String userName) throws SystemException, BusinessException {
		logger.debug("enter into getUserById method");
		User user;
		try {
			List<User> userList = repository.getUserByName(userName);
			user = userList.get(0);
		} catch (RuntimeException e) {
			logger.error("Exception occured due to " ,e);
			throw new SystemException("","");	
		}
		if(user != null) {
			UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
			logger.debug("exit from getUserById method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not persent");
	}

	public List<UserIntgResponse> getAllUsers() throws BusinessException, SystemException {
		logger.debug("enter into getAllUsers method");
		List<User> userList;
		try {
			userList = repository.findAll();
		} catch (RuntimeException e) {
			logger.error("Exception occured  " ,e);
			throw new SystemException("","");	
		}
		List<UserIntgResponse> responseList = new ArrayList<UserIntgResponse>();
		if(userList != null) {
			userList.forEach(user ->{
				UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
				responseList.add(intgResponse);
			});
			logger.debug("exit from getAllUsers method");
			return responseList;
		}
		else
			throw new BusinessException("505","data not persent");
	}
	public UserIntgResponse createUser(UserIntgRequest intgRequest) throws BusinessException, SystemException {
		logger.debug("enter into createUser method");
		User user = requestBuilder.buildRequest(intgRequest);
		User entity;
		try {
			entity = repository.save(user);
		} catch (RuntimeException e) {
			logger.error("Exception occured  " ,e);
			throw new SystemException("","");
		}
		if(entity != null) {
			UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
			logger.debug("exit from getAllUsers method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not saved");
	}

	public UserIntgResponse editUser(UserIntgRequest intgRequest) throws BusinessException, SystemException {
		logger.debug("enter into editUser method");
		User user = null ;
		
		Long userId = intgRequest.getUserId();
		try {
			user = repository.findById(userId).get();
			user = requestBuilder.buildRequest(user,intgRequest);
			user = repository.save(user);
//			repository.updateUser(userEmail ,userPassword , status ,createdBy , userId );
		} catch (RuntimeException e) {
			logger.error("Exception occured  " ,e);
			throw new SystemException("","");
		}
		catch (Exception e) {
			throw new BusinessException("","");
		}
		if(user != null) {
			UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
			logger.debug("exit from editUser method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not persent");
	}

	public UserIntgResponse changeStatus(Long userId, int status) throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		User user = null ;
		try {
			user = repository.findById(userId).get();
			user.setStatus(status);
			user = repository.save(user);
//			repository.updateUser(userEmail ,userPassword , status ,createdBy , userId );
		} catch (RuntimeException e) {
			logger.error("Exception occured  " ,e);
			throw new SystemException("","");
		}
		catch (Exception e) {
			throw new BusinessException("","");
		}
		if(user != null) {
			UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
			logger.debug("exit from changeStatus method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not persent");
	}
	
	public RoleIntgResponse getRoleById(Long roleId) throws BusinessException, SystemException {
		logger.debug("enter into getRoleById method");
		Role role;
		try {
			role = roleRepository.findById(roleId).get();
		} catch (RuntimeException e) {
			logger.error("Exception occurred due to " ,e);
			throw new SystemException("","");	
		}
		if(role != null) {
			RoleIntgResponse intgResponse = responseBuilder.buildResponse(role);
			logger.debug("exit from getRoleById method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not present");
	}

	public List<RoleIntgResponse> getAllRoles() throws BusinessException, SystemException {
		logger.debug("enter into getAllRoles method");
		List<Role> roleList;
		try {
			roleList = roleRepository.findAll();
		} catch (RuntimeException e) {
			logger.error("Exception occurred  " ,e);
			throw new SystemException("","");	
		}
		List<RoleIntgResponse> responseList = new ArrayList<RoleIntgResponse>();
		if(roleList != null) {
			roleList.forEach(role ->{
				RoleIntgResponse intgResponse = responseBuilder.buildResponse(role);
				responseList.add(intgResponse);
			});
			logger.debug("exit from getAllRoles method");
			List<RoleIntgResponse> activeResponseList = responseList.stream()
					.filter(response -> response.getRespBody().getStatus()==1)
					.collect(Collectors.toList());
			return activeResponseList;
		}
		else
			throw new BusinessException("505","data not present");
	}
	public RoleIntgResponse createRole(RoleIntgRequest intgRequest) throws BusinessException, SystemException {
		logger.debug("enter into createRole method");
		Role role = requestBuilder.buildRequest(intgRequest);
		Role entity;
		try {
			entity = roleRepository.save(role);
		} catch (RuntimeException e) {
			logger.error("Exception occurred  " ,e);
			throw new SystemException("","");
		}
		if(entity != null) {
			RoleIntgResponse intgResponse = responseBuilder.buildResponse(role);
			logger.debug("exit from getAllRoles method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not saved");
	}

	public RoleIntgResponse editRole(RoleIntgRequest intgRequest) throws BusinessException, SystemException {
		logger.debug("enter into editRole method");
		Role role = null ;
		Role entity = null;
		Long roleId = intgRequest.getRoleId();
		try {
			entity = roleRepository.findById(roleId).get();
			role = requestBuilder.buildRequest(entity,intgRequest);
			entity =roleRepository.save(role);
		} catch (RuntimeException e) {
			logger.error("Exception occurred  " ,e);
			throw new SystemException("","");
		}
		catch (Exception e) {
			throw new BusinessException("","");
		}
		if(entity != null) {
			RoleIntgResponse intgResponse = responseBuilder.buildResponse(role);
			logger.debug("exit from editRole method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not updated");
	}

	public RoleIntgResponse changeStatus(long roleId,int status) throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		Role entity = null;
		try {
			Role role = roleRepository.findById(roleId).get();
			role.setStatus(status);
			entity =roleRepository.save(role);
		} catch (RuntimeException e) {
			logger.error("Exception occurred  " ,e);
			throw new SystemException("","");
		}
		catch (Exception e) {
			throw new BusinessException("","");
		}
		if(entity != null) {
			RoleIntgResponse intgResponse = responseBuilder.buildResponse(entity);
			logger.debug("exit from changeStatus method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","Status not updated");
	}


}

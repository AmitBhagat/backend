package com.dalrada.user.resource.validator;

import org.springframework.stereotype.Component;

import com.dalrada.user.resource.beans.RoleResourceRequest;
import com.dalrada.user.resource.beans.UserResourceRequest;
import com.dalrada.user.resource.exception.InvalidRequestException;

@Component
public class RequestValidator {

	public void userValidate(Long userId) throws InvalidRequestException {
		if (userId == null || userId == 0 ) {
			throw new InvalidRequestException("500", "UserId is invalid");
		}

	}

	public void validate(String userName) throws InvalidRequestException {
		if (userName == null || userName == "") {
			throw new InvalidRequestException("500", "userName is invalid");
		}

	}

	public void validate(UserResourceRequest resourceRequest) throws InvalidRequestException {
		if (resourceRequest.getUserName() == null || resourceRequest.getUserEmail() == null
				|| resourceRequest.getUserPassword() == null || resourceRequest.getCreatedBy() == null
				|| resourceRequest.getStatus() == null) {
			throw new InvalidRequestException("500", "Invalid input");
		}
	}

	public void roleValidate(Long roleId) throws InvalidRequestException {
		if (roleId == null || roleId == 0) {
			throw new InvalidRequestException("500", "RoleId is invalid");
		}

	}

	public void validate(RoleResourceRequest resourceRequest) throws InvalidRequestException {
		if(resourceRequest.getRoleName()==null||resourceRequest.getStatus()==null||resourceRequest.getCreatedBy()==null) {
			throw new InvalidRequestException("500","Invalid input");
		}
	}

}

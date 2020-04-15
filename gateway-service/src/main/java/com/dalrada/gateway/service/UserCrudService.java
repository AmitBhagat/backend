package com.dalrada.gateway.service;

import java.util.Optional;

import com.dalrada.gateway.util.User;
import com.dalrada.gateway.util.UserResourceRequest;


public interface UserCrudService {
	
    	User save(UserResourceRequest userRequest);

	  Optional<User> find(String id);

	  Optional<User> findByUsername(String username);
	}

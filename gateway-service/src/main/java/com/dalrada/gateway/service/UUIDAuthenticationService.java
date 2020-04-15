package com.dalrada.gateway.service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dalrada.gateway.util.User;
@Component
public class UUIDAuthenticationService implements UserAuthenticationService {

	DalradaUserDetailService userService;


	public UUIDAuthenticationService(DalradaUserDetailService userService) {
		this.userService = userService;
	}

	@Override
	public Optional<String> login(final String username, final String password) {
		
		User user = userService.findByUsername(username).get();
		String uuid = null ;
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(user != null) {
			System.out.println(user);
			String userPassword = user.getPassword() ;
			uuid = UUID.randomUUID().toString();
			userService.getUsers().put(uuid, user);
		}
		return Optional.ofNullable(uuid);
	}

	@Override
	public Optional<User> findByToken(final String token) {
		Map<String ,User> users = userService.getUsers();
		User user = null ;
		if(users.containsKey(token)) {
		user = userService.getUsers().get(token);
	}
		return Optional.ofNullable(user);
	}

	@Override
	public void logout(final String id ) {
		userService.getUsers().remove(id);
	}
}

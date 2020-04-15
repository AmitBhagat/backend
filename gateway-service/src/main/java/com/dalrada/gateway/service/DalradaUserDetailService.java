package com.dalrada.gateway.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.dalrada.gateway.util.Account;
import com.dalrada.gateway.util.ResourceResponse;
import com.dalrada.gateway.util.User;
import com.dalrada.gateway.util.UserResourceRequest;

import reactor.core.publisher.Mono;
@Component
public class DalradaUserDetailService implements UserCrudService {

	private UserClient userClient ;
	public Map<String, User> users = new HashMap<>();

	
	@Autowired
	public DalradaUserDetailService(UserClient userClient) {
		this.userClient = userClient;
	}


	public Map<String, User> getUsers() {
		return users;
	}


	private static final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


	@Override
	public User save(final UserResourceRequest userRequest) {
		User user = new User();
		 userClient.save(userRequest).subscribe(response ->{
			 
			 Account account = new Account( response.getRespBody().getUserId() , response.getRespBody().getUserName(), 
						passwordEncoder.encode(response.getRespBody().getUserPassword()), true );
				user.setAccount(account); 
				String roleName = response.getRespBody().getRoleName();
				user.setAuthorities(new String[] {roleName}); 
		 } );
		 return user;
	}

	@Override
	public Optional<User> find(String id) {
		Mono<ResourceResponse> userMono = userClient.getUserById(id);		  
		User maybeUser = new User() ;			  
		userMono.subscribe(user ->{ 
			System.out.println(user);
			Account account = new Account( user.getRespBody().getUserId() , user.getRespBody().getUserName(), 
					passwordEncoder.encode(user.getRespBody().getUserPassword()), true );
			maybeUser.setAccount(account); 
			String roleName = user.getRespBody().getRoleName();
			maybeUser.setAuthorities(new String[] {"ROLE_"+roleName}); 
			System.out.println(maybeUser);
		}); 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Optional.of(maybeUser);		  
	}


	@Override
	public Optional<User> findByUsername(String username) {
		Mono<ResourceResponse> userMono = userClient.getUserByName(username);		  
		User maybeUser = new User() ;			  
		userMono.subscribe(user ->{ 
			Account account = new Account( user.getRespBody().getUserId() , user.getRespBody().getUserName(), 
					passwordEncoder.encode(user.getRespBody().getUserPassword()), true );
			maybeUser.setAccount(account); 
			String roleName = user.getRespBody().getRoleName();
			maybeUser.setAuthorities(new String[] {roleName}); 
		}); 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Optional.of(maybeUser);		  
	}
}

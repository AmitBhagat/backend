package com.dalrada.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrada.gateway.service.UserAuthenticationService;
import com.dalrada.gateway.service.UserCrudService;
import com.dalrada.gateway.util.UserResourceRequest;

@RestController
@RequestMapping("/public/users")	
public class PublicUsersController {
	 UserAuthenticationService authentication;
	
	  UserCrudService users;
	  
	  
	  public PublicUsersController(UserAuthenticationService authentication, UserCrudService users) {
		super();
		this.authentication = authentication;
		this.users = users;
	}

	@PostMapping("/register")
	  String register(@RequestBody UserResourceRequest request ) {
	   
		users .save( request);
		 String username = request.getUserName();
		 String password = request.getUserPassword();
		return authentication
			      .login(username, password).get();
	  }

	  @GetMapping("/login/{username}/{password}")
	  String login(
	    @PathVariable("username") final String username,
	    @PathVariable("password") final String password) {
		  System.out.println(username+" : "+password);
	    return authentication
	      .login(username, password)
	      .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
	  }
	}
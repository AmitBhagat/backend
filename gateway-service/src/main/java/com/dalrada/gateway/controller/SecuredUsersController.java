package com.dalrada.gateway.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dalrada.gateway.service.MailClient;
import com.dalrada.gateway.service.UserAuthenticationService;
import com.dalrada.gateway.service.UserClient;
import com.dalrada.gateway.util.MailRequest;
import com.dalrada.gateway.util.ResourceResponse;
import com.dalrada.gateway.util.User;

import reactor.core.publisher.Mono;
@RestController
public class SecuredUsersController {
	UserAuthenticationService authentication;
	UserClient userClient;
	MailClient mailClient;
	
	@Autowired
	public SecuredUsersController(UserAuthenticationService authentication, UserClient userClient,
			MailClient mailClient) {
		this.authentication = authentication;
		this.userClient = userClient;
		this.mailClient = mailClient;
	}

	@GetMapping("/current")
	User getCurrent(@AuthenticationPrincipal  User user) {
		return user;
	}

	@GetMapping("/logout")
	boolean logout(@PathVariable final String id) {
		authentication.logout(id);
		return true;
	}
	@GetMapping("forgetPassword/{username}")
	public String forgetPassword(@PathVariable String username) {
		Mono<ResourceResponse> userMono = userClient.getUserByName(username);
		userMono.subscribe(user ->{
			MailRequest request = new MailRequest();
			request.setUsername(user.getRespBody().getUserName());
			request.setPassword(user.getRespBody().getUserPassword());
			request.setEmailId(user.getRespBody().getUserEmail());
			String ipAddress = null;
			try {
				ipAddress = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			request.setIpAddress(ipAddress);
			mailClient.sendMailToUser(request).subscribe(); 

		});
		return "mail send";
	}
}

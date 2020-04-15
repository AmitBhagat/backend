package com.dalrada.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.dalrada.gateway.util.ResourceResponse;
import com.dalrada.gateway.util.UserResourceRequest;
import reactor.core.publisher.Mono;

@Component
public class UserClient {
	@Autowired
	WebClient webClient ;
	
	public Mono<ResourceResponse> save(UserResourceRequest userRequest){
		
		Mono<ResourceResponse> userMono =
				  webClient.post().uri("user/userResource/users/create", userRequest)
				  .accept(MediaType.APPLICATION_JSON) .retrieve()
				  .bodyToMono(ResourceResponse.class);
		return userMono;
	}
	
	public Mono<ResourceResponse> getUserById(String userId){
		Mono<ResourceResponse> userMono =
				webClient.get().uri("user/userResource/users/id/{userId}", userId)
				.accept(MediaType.APPLICATION_JSON) .retrieve()
				.bodyToMono(ResourceResponse.class);
		return userMono;
	}
	
	public Mono<ResourceResponse> getUserByName(String userName){
		Mono<ResourceResponse> userMono =
				webClient.get().uri("user/userResource/users/name/{userName}", userName)
				.accept(MediaType.APPLICATION_JSON) .retrieve()
				.bodyToMono(ResourceResponse.class);
		return userMono;
	}


}

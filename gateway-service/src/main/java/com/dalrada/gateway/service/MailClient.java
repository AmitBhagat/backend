package com.dalrada.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.dalrada.gateway.util.MailRequest;
import com.dalrada.gateway.util.ResourceResponse;

import reactor.core.publisher.Mono;

@Component
public class MailClient {
	@Autowired
	WebClient webClient ;
	public Mono<ResourceResponse> sendMailToUser(MailRequest request){
		Mono<ResourceResponse> userMono =
				  webClient.post().uri("mail/send")
				  .bodyValue(request)
				  .accept(MediaType.APPLICATION_JSON) .retrieve()
				  .bodyToMono(ResourceResponse.class);
		return userMono;
	}
}

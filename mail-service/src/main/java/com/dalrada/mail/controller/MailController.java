package com.dalrada.mail.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dalrada.mail.beans.MailRequest;
import com.dalrada.mail.service.MailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Mail Service API")
public class MailController {
	@Autowired
	MailService mailService ;
	
	@PostMapping("send")
	@ApiOperation(value = "Mail Sending API")
	public void SendMail(@RequestBody MailRequest request) {
		try {
			mailService.sendEmail(request);
		} catch (MessagingException e) {
			
		}
	}
}

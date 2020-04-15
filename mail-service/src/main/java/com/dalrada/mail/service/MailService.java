package com.dalrada.mail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.dalrada.mail.beans.MailRequest;
@Component
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(MailRequest request) throws MessagingException {
		String mailId = request.getEmailId();
		String username = request.getUsername();
		String password = request.getPassword();
		String ipAddress = request.getIpAddress();
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(mailId);
		String credentials = "<h2>Check Username & Password ! </h2>"+"\n<h3> Username : "+username+"</h3>\n"+"<h3>Password :" + password+"</h3>\n";
		String url = "\n<h4><a href=\"http://"+ ipAddress +":3000/signIn\">Click here to login</a></h4>";
		helper.setSubject("Dalrada Dashboard UserName & Password");
		helper.setText(credentials + url, true);

		javaMailSender.send(msg);

	}
}

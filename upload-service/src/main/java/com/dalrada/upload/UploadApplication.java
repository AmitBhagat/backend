package com.dalrada.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
@EnableEurekaClient
//@RefreshScope
public class UploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadApplication.class, args);
	}
	
}

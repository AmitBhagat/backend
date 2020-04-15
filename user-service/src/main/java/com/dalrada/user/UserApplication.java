package com.dalrada.user;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.dalrada.user.integration.entity.Role;
import com.dalrada.user.integration.repository.RoleRepository;

@SpringBootApplication
@EnableEurekaClient
public class UserApplication implements CommandLineRunner {
	@Autowired
	RoleRepository repository ;
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LocalDate currentDate = LocalDate.now();
		
		Role user = new Role();
		user.setRoleName("USER");
		user.setCreatedDate(Date.valueOf(currentDate));
		user.setCreatedBy("ADMIN");
		user.setStatus(1);
		
		Role admin = new Role();
		admin.setRoleName("ADMIN");
		admin.setCreatedDate(Date.valueOf(currentDate));
		admin.setCreatedBy("ADMIN");
		admin.setStatus(1);
		
		List<Role> roles = Arrays.asList(user , admin);
		try {
			repository.saveAll(roles);
		} catch (Exception e) {
			
		}
	}


}

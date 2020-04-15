package com.dalrada.upload.intg.writer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beanBuilder.CustomerBeanBuilder;
import com.dalrada.upload.intg.entity.CustomerDetails;
import com.dalrada.upload.intg.repository.CustomerRepository;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class CustomerWriter implements Writer{

	@Autowired
	CustomerRepository repository ;
	@Autowired
	CustomerBeanBuilder beanBuilder ;

	public void write(List<String> customerLines) throws IOException{
		/*
		 * List<String> items =customerLines.parallelStream() .map(line ->
		 * beanBuilder.buildBean(line).toString()).collect(Collectors.toList());
		 * Files.write(Paths.get("D:\\Dalrada old\\customer.csv"), items ,
		 * StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		 */
		List<CustomerDetails> items = customerLines.parallelStream()
				.map(line -> beanBuilder.buildBean(line)).collect(Collectors.toList());
		repository.saveAll(items);	

	}

}
package com.dalrada.upload.intg.writer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beanBuilder.OderBeanBuilder;
import com.dalrada.upload.intg.beanBuilder.OrderNoQuoteBeanBuilder;
import com.dalrada.upload.intg.beanBuilder.OrderQuotesBeanBuilder;
import com.dalrada.upload.intg.entity.OrderDetails;
import com.dalrada.upload.intg.repository.OrderRepository;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderWriter implements Writer{

	@Autowired
	OrderRepository repository ;
	@Autowired
	OrderNoQuoteBeanBuilder beanNoQuoteBuilder ;
	@Autowired
	OrderQuotesBeanBuilder beanQuotesBuilder ;
	
	public void write(List<String> orderLines){
		
		/*
		 * List<String> items =orderLines.parallelStream() .map(line
		 * ->beanQuotesBuilder.buildBean(line).toString()).collect(Collectors.toList());
		 * try { Files.write(Paths.get("D:\\Dalrada Microservice\\Files\\order4.csv"),
		 * items , StandardOpenOption.CREATE, StandardOpenOption.APPEND); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		Long quotes = orderLines.get(2).chars().mapToObj(c ->(char)c).filter(q -> q=='\"').count();
		OderBeanBuilder beanBuilder ;
		if(quotes > 4) {
			 beanBuilder = beanQuotesBuilder ;
		}
		else {
			beanBuilder = beanNoQuoteBuilder ;
		}
		  Set<OrderDetails> itemSet = orderLines.parallelStream() .map(line ->
		  beanBuilder.buildBean(line)).distinct().sorted(Comparator.comparing(
		  item -> item.getOrderDate())).collect(Collectors.toSet()); 
		  List<OrderDetails>
		  items = new ArrayList<OrderDetails>(itemSet); 
		  try {
		  repository.saveAll(items); } 
		  catch (Exception e) { 
		   e.printStackTrace(); }
		 
	}
	
}
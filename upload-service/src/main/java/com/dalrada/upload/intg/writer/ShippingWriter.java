package com.dalrada.upload.intg.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beanBuilder.ShippingBeanBuilder;
import com.dalrada.upload.intg.entity.ShippingDetails;
import com.dalrada.upload.intg.repository.ShippingRepository;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class ShippingWriter implements Writer{

	@Autowired
	ShippingRepository repository ;
	@Autowired
	ShippingBeanBuilder beanBuilder ;

	public void write(List<String> shippingLines) throws IOException {
		/*
		 * List<String> items =shippingLines.parallelStream() .map(line ->
		 * beanBuilder.buildBean(line).toString()).collect(Collectors.toList());
		 * Files.write(Paths.get("D:\\Dalrada old\\shipping.csv"), items ,
		 * StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		 */
		List<ShippingDetails> items = shippingLines.parallelStream()
				.map(line -> beanBuilder.buildBean(line)).distinct().sorted(Comparator.comparing(item -> item.getInvoiceNumber())).collect(Collectors.toList());
		try {
			repository.saveAll(items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
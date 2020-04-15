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

import com.dalrada.upload.intg.beanBuilder.InvoiceBeanBuilder;
import com.dalrada.upload.intg.entity.InvoiceDetails;
import com.dalrada.upload.intg.repository.InvoiceDetailsRepository;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */

@Component
public class InvoiceWriter implements Writer{

	@Autowired
	InvoiceDetailsRepository repository ;
	@Autowired
	InvoiceBeanBuilder beanBuilder ;
	
	public void write(List<String> invoiceLines) throws IOException{
		/*
		 * List<String> items =invoiceLines.parallelStream() .map(line ->
		 * beanBuilder.buildBean(line).toString()).collect(Collectors.toList());
		 * Files.write(Paths.get("D:\\Dalrada old\\invoice.csv"), items ,
		 * StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		 */
		 List<InvoiceDetails> items = invoiceLines.parallelStream()
					.map(line -> beanBuilder.buildBean(line)).distinct().sorted(Comparator.comparing(item -> item.getInvoiceNumber())).collect(Collectors.toList());
		repository.saveAll(items);	
		
	}
	
}
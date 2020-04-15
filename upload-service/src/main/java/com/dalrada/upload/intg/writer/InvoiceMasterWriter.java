package com.dalrada.upload.intg.writer;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beanBuilder.InvoiceMasternBeanBuilder;
import com.dalrada.upload.intg.entity.InvoiceMaster;
import com.dalrada.upload.intg.repository.InvoiceMasterRepository;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class InvoiceMasterWriter implements Writer{

	@Autowired
	InvoiceMasterRepository repository ;
	@Autowired
	InvoiceMasternBeanBuilder beanBuilder ;

	public void write(List<String> invoiceMasterLines) throws IOException {
		/*
		 * List<String> items =invoiceMasterLines.parallelStream() .map(line ->
		 * beanBuilder.buildBean(line).toString()).collect(Collectors.toList());
		 * Files.write(Paths.get("D:\\Dalrada old\\invoiceMaster.csv"), items ,
		 * StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		 */
		 List<InvoiceMaster> items = invoiceMasterLines.parallelStream()
				.map(line -> beanBuilder.buildBean(line)).distinct().sorted(Comparator.comparing(item -> item.getInvoiceNumber())).collect(Collectors.toList());
		repository.saveAll(items);	

	}

}
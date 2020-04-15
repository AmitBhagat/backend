package com.dalrada.upload.intg.beanBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.entity.InvoiceMaster;
import com.dalrada.upload.util.WarehouseConstants;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class InvoiceMasternBeanBuilder{

	public InvoiceMaster buildBean(String record) {
		
		List<String> list = Arrays.asList(record.split("~+")).stream().map(word -> word.trim())
				.collect(Collectors.toList());
		InvoiceMaster details = new InvoiceMaster();
		
		details.setWarehouseID(WarehouseConstants.getWareHouseId());
		details.setCreatedBy("3152563");
		details.setCustNumber(WarehouseConstants.getCustNumber());
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
		String currentDate = date.format(formatter);
		
		details.setDateCreated(currentDate);
		details.setDiscounts(list.get(4));
		details.setExtNetUnit(list.get(6));
		// details.setInvCount(String.valueOf(recordCount));
		details.setInvDate("frsgebedtb");
		details.setInvoiceNumber(list.get(1));
		details.setOrdered(list.get(2));
		details.setShipCount("32565");
		details.setShipped(list.get(3));
		details.setTax(list.get(5));	
		return details;	
	}
}
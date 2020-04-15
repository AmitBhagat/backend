package com.dalrada.upload.intg.beanBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.entity.ShippingDetails;
import com.dalrada.upload.util.WarehouseConstants;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class ShippingBeanBuilder{

	public ShippingDetails buildBean(String record) {

		List<String> list = Arrays.asList(record.split("~")).stream().map(word -> word.trim())
				.collect(Collectors.toList());
		ShippingDetails details = new ShippingDetails();
		details.setInvoiceNumber(list.get(0));
		details.setBrand(list.get(7));
		details.setChain(list.get(4));
		details.setCustNumber(list.get(3));
		details.setDescription(list.get(8));
		details.setDiscDescr(list.get(13));
		details.setDiscounts(list.get(14));
		details.setExtNetUnit(list.get(16));
		details.setInvDate(list.get(2));
		details.setOrdered(list.get(11));
		details.setPack(list.get(9));
		details.setPoNumber(list.get(1));
		details.setProductNumber(list.get(5));
		details.setShipped(list.get(12));
		details.setSize(list.get(10));
		details.setTax(list.get(15));
		details.setUpcNumber(list.get(6));
		
		details.setWarehouseID(WarehouseConstants.getWareHouseId());
		
		details.setCustNumber(WarehouseConstants.getCustNumber());

		return details;	
	}
}
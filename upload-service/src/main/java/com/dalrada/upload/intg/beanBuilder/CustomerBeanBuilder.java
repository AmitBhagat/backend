package com.dalrada.upload.intg.beanBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.entity.CustomerDetails;
import com.dalrada.upload.util.WarehouseConstants;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class CustomerBeanBuilder{

	public  CustomerDetails buildBean(String record){

		List<String> list = Arrays.asList(record.split("~+")).stream().map(word -> word.trim())
				.collect(Collectors.toList());

		CustomerDetails details = new CustomerDetails();
		details.setCustName(list.get(2));
		details.setCustNumber(list.get(1));
		details.setDiscounts(list.get(5));
		details.setExtNetUnit(list.get(7));
		details.setOrdered(Long.valueOf(list.get(3)));
		details.setShipped(Long.valueOf(list.get(4)));
		details.setTax(list.get(6));

		details.setFromDate(WarehouseConstants.getFromDate());
		details.setToDate(WarehouseConstants.getToDate());
		details.setWarehouseID(WarehouseConstants.getWareHouseId());

		return details ;

	}
}
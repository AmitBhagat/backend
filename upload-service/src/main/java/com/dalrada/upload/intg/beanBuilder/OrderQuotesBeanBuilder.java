package com.dalrada.upload.intg.beanBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.entity.OrderDetails;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderQuotesBeanBuilder  implements OderBeanBuilder{

	public  OrderDetails buildBean(String itemRecord){
	
		
		
		
		String	record = itemRecord
		.chars()
		.mapToObj(c -> Character.toString((char)c))
		.filter(q -> ! (q == "\"")).collect(Collectors.joining());
		
		List<String> list = Arrays.asList(record.split(",")).stream()
				.collect(Collectors.toList());
		
		List<String> itemList = Arrays.asList(itemRecord.split(",")).stream()
				.collect(Collectors.toList());

		List<Integer> indexList = list.stream()
				.filter(item -> item.contains("\""))
				.map(item -> list.indexOf(item))
				.collect(Collectors.toList());

		String productName = null ;
		String trackingNumbers = null ;
		int productNameIndex =8 ;
		int trackingNumbersIndex=18 ;
		try {
			if(indexList.size()>0) {
				if(indexList.size()>1 && indexList.size()<=2) {

					List<String> first = list.subList(indexList.get(0), indexList.get(1)+1) ;
					String firstItem = first.stream().collect(Collectors.joining(","));
					if(indexList.get(0)==8) {
						productName = firstItem ;
						productNameIndex = indexList.get(1) ;
					}
					else {
						trackingNumbers = firstItem ;
						trackingNumbersIndex = indexList.get(1) ;
					}
				}
				else if(indexList.size()>2) {
					List<String> first = list.subList(indexList.get(0), indexList.get(1)+1) ;
					List<String> second = list.subList(indexList.get(2), indexList.get(indexList.size()-1)+1) ;
					productName = first.stream().collect(Collectors.joining(","));
					productNameIndex = indexList.get(1) ;
					trackingNumbers = second.stream().collect(Collectors.joining(","));
					trackingNumbersIndex = indexList.get(indexList.size()-1) ;

				}
			}
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		OrderDetails details = new OrderDetails();

		try {
			details.setAddressLine1(list.get(list.size()-6));
			details.setAddressLine2(list.get(list.size()-5));
			details.setChannelName(list.get(5));
			details.setCity(list.get(list.size()-4));
			details.setCompany(null);
			details.setCountry(list.get(list.size()-1));
			details.setCustomerEmail(list.get(list.size()-8));
			details.setCustomerName(list.get(list.size()-9));
			details.setCustomerPhone(list.get(list.size()-7));
			details.setOrderDate(list.get(0));
			details.setOrderNumber(list.get(2));
			details.setOrderStatus(list.get(6));
			try {
				details.setOrderTotal(Double.valueOf(list.get(productNameIndex+5)));
			} catch (Exception e2) {
				details.setQuantity(0);
			}
			details.setPoNumber(list.get(3));
			try {
				details.setQuantity(Long.valueOf(list.get(productNameIndex+1)));
			} catch (Exception e1) {
				details.setQuantity(0);
			}

			details.setReferenceNumber(list.get(4));

			try {
				details.setSalePrice(Double.valueOf(list.get(productNameIndex+3)));
			} catch (Exception e) {
				details.setSalePrice(0.0);
			}
			details.setShippingCarrier(list.get(productNameIndex+8));
			details.setShippingMethod(list.get(productNameIndex+9));
			details.setSku(list.get(7));
			details.setSrNo(null);
			details.setState(list.get(list.size()-3));
			details.setStoreOrderId(list.get(1));
			details.setStoreShippingMethod(list.get(productNameIndex+7));

			try {
				details.setSupplierCostPerSKU(Double.valueOf(list.get(productNameIndex+2)));
			} catch (Exception e) {
				details.setSupplierCostPerSKU(0.0);
			}

			try {
				details.setSupplierCostTotal(Double.valueOf(list.get(productNameIndex+4)));
			} catch (Exception e) {
				details.setSupplierCostTotal(0.0);
			}
			if(productName == null)
				details.setProductName(list.get(productNameIndex));
			else
				details.setProductName(productName);
			details.setSupplierName(list.get(productNameIndex+6));
			if(trackingNumbers == null)
				details.setTrackingNumbers(list.get(productNameIndex+10));
			else
				details.setTrackingNumbers(trackingNumbers);
			details.setZip(list.get(list.size()-2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(list);
		}
		return details ;
	}
}

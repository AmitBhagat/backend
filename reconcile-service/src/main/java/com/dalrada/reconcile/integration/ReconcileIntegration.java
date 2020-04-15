package com.dalrada.reconcile.integration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dalrada.reconcile.integration.beans.ReconcileIntgResponse;
import com.dalrada.reconcile.integration.entity.OrderDetails;
import com.dalrada.reconcile.integration.entity.ShippingDetails;
import com.dalrada.reconcile.integration.exception.BusinessException;
import com.dalrada.reconcile.integration.exception.SystemException;
import com.dalrada.reconcile.integration.repository.OrderRepository;
import com.dalrada.reconcile.integration.repository.ShippingRepository;
import com.dalrada.reconcile.integration.responseBuilder.ReconcileIntgResponseBuilder;
/**
 * @author Sneha
 *
 */
@Component
public class ReconcileIntegration {

	OrderRepository orderRepository ;
	ShippingRepository shippingRepository ;
	ReconcileIntgResponseBuilder responseBuilder ;
	private static final Logger logger = LoggerFactory.getLogger(ReconcileIntegration.class);
	@Autowired
	public ReconcileIntegration(OrderRepository orderRepository,ShippingRepository shippingRepository ,
			ReconcileIntgResponseBuilder responseBuilder) {
		super();
		this.orderRepository = orderRepository;
		this.shippingRepository = shippingRepository;
		this.responseBuilder = responseBuilder;
	}
	@Transactional(readOnly = true)
	public List<ReconcileIntgResponse> getAllOrders( String startDate , String endDate) throws BusinessException, SystemException {
		logger.debug("enter into getAllUsers method");	
		
		  String fromDate = startDate.concat(" 00:00:00 GMT"); 
		  String toDate = endDate.concat(" 00:00:00 GMT");
		 
		List<OrderDetails> orderList = null;
		try(Stream<OrderDetails> orderStream = orderRepository.getAllBetween(fromDate, toDate)) {
			orderList = orderStream.collect(Collectors.toList());
		} catch (RuntimeException e) {
			logger.error("Exception occured  " ,e);
			throw new SystemException("500","order details not available");	
		}		

		List<String> poNumbers = orderList.parallelStream().map(order -> order.getPoNumber()).collect(Collectors.toList());
		Stream<ShippingDetails> shippingStream = shippingRepository.findByPoNumber(poNumbers);
		Map<String, List<ShippingDetails>> shippingMap = shippingStream.collect(Collectors.groupingBy(shipping -> shipping.getPoNumber()));

		List<ReconcileIntgResponse> responseList =  orderList.parallelStream().map(order ->{
			ReconcileIntgResponse intgResponse = responseBuilder.buildResponse(order) ;
			ShippingDetails shipping = null ;
			List<ShippingDetails> shippingList = null ;
			if(order.getPoNumber() != null) {
				shippingList = shippingMap.get(order.getPoNumber());
				if(shippingList !=null && shippingList.size()>=1) {
						shipping = shippingList.get(0);
				}
				else
					shipping = null;
			}
			else
				shipping = null;
			
			if(shipping != null) {
				String extNetUnit = shipping.getExtNetUnit();
				try {
					intgResponse.getResponseBody().setExtNetUnit(Double.valueOf(extNetUnit.substring(1)));
				} catch (NumberFormatException e) {
					intgResponse.getResponseBody().setExtNetUnit(0.00);
				}
			}
			return intgResponse;
		}).collect(Collectors.toList());
		logger.debug("exit from getAllUsers method");
		return responseList;
	}
}

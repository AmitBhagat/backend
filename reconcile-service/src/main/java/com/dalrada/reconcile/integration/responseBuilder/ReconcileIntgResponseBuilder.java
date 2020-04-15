package com.dalrada.reconcile.integration.responseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.reconcile.integration.beans.IntgResponseBody;
import com.dalrada.reconcile.integration.beans.ReconcileIntgResponse;
import com.dalrada.reconcile.integration.entity.OrderDetails;
import com.dalrada.reconcile.integration.entity.ShippingDetails;
/**
 * @author Sneha
 *
 */
@Component
public class ReconcileIntgResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ReconcileIntgResponseBuilder.class);
	public ReconcileIntgResponse buildResponse(OrderDetails order) {
		logger.debug("enter into buildResponse method");
		ReconcileIntgResponse response = new ReconcileIntgResponse();
		response.setResponseCode("200");
		response.setResponseMsg("successfull");
		IntgResponseBody responseBody = new IntgResponseBody();
		responseBody.setAddressLine1(order.getAddressLine1());
		responseBody.setAddressLine2(order.getAddressLine2());
		responseBody.setChannelName(order.getChannelName());
		responseBody.setCity(order.getCity());
		responseBody.setCompany(order.getCompany());
		responseBody.setCountry(order.getCountry());
		responseBody.setCustomerEmail(order.getCustomerEmail());
		responseBody.setCustomerName(order.getCustomerName());
		responseBody.setCustomerPhone(order.getCustomerPhone());
		responseBody.setOrderDate(order.getOrderDate());
		responseBody.setOrderNumber(order.getOrderNumber());
		responseBody.setOrderStatus(order.getOrderStatus());
		responseBody.setOrderTotal(order.getOrderTotal());
		responseBody.setPoNumber(order.getPoNumber());
		responseBody.setProductName(order.getProductName());
		responseBody.setQuantity(order.getQuantity());
		responseBody.setReferenceNumber(order.getReferenceNumber());
		responseBody.setSalePrice(order.getSalePrice());
		responseBody.setShippingCarrier(order.getShippingCarrier());
		responseBody.setShippingMethod(order.getShippingMethod());
		responseBody.setSku(order.getSku());
		responseBody.setSrNo(order.getSrNo());
		responseBody.setState(order.getState());
		responseBody.setStoreOrderId(order.getStoreOrderId());
		responseBody.setStoreShippingMethod(order.getStoreShippingMethod());
		responseBody.setSupplierCostPerSKU(order.getSupplierCostPerSKU());
		responseBody.setSupplierCostTotal(order.getSupplierCostTotal());
		responseBody.setSupplierName(order.getSupplierName());
		responseBody.setTrackingNumbers(order.getTrackingNumbers());
		responseBody.setZip(order.getZip());
		responseBody.setExtNetUnit(0.0);
		response.setResponseBody(responseBody);
		logger.debug("exit from buildResponse method");
		return response;		
	}

	public ReconcileIntgResponse buildResponse(String responseCode, String respMsg) {
		logger.debug("enter into buildResponse method");
		ReconcileIntgResponse response = new ReconcileIntgResponse();
		response.setResponseCode(responseCode);
		response.setResponseMsg(respMsg);
		logger.debug("exit from buildResponse method");
		return response;	

	}

}

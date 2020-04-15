package com.dalrada.reconcile.resource.responseBuilder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.reconcile.process.beans.ReconcileProcessResponse;
import com.dalrada.reconcile.resource.beans.ReconcileResourceResponse;
import com.dalrada.reconcile.resource.beans.ResourceResponseBody;
/**
 * @author Sneha
 *
 */
@Component
public class ReconcileResourceResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ReconcileResourceResponseBuilder.class);
	private static DecimalFormat DECIMALFORMAT = new DecimalFormat("#.##");

	public List<ReconcileResourceResponse> buildResponse(List<ReconcileProcessResponse> intgRespList) {
		logger.debug("enter into buildResponse method");
		List<ReconcileResourceResponse> processRespList = new ArrayList<ReconcileResourceResponse>();
		intgRespList.forEach(intgResponse ->{
			ReconcileResourceResponse resourceResponse = new ReconcileResourceResponse();
			resourceResponse.setResponseCode(intgResponse.getResponseCode());
			resourceResponse.setResponseMsg(intgResponse.getResponseMsg());
			ResourceResponseBody responseBody = new ResourceResponseBody();
			responseBody.setAddressLine1(intgResponse.getRespBody().getAddressLine1());
			responseBody.setAddressLine2(intgResponse.getRespBody().getAddressLine2());
			responseBody.setChannelName(intgResponse.getRespBody().getChannelName());
			responseBody.setCity(intgResponse.getRespBody().getCity());
			responseBody.setCompany(intgResponse.getRespBody().getCompany());
			responseBody.setCountry(intgResponse.getRespBody().getCountry());
			responseBody.setCustomerEmail(intgResponse.getRespBody().getCustomerEmail());
			responseBody.setCustomerName(intgResponse.getRespBody().getCustomerName());
			responseBody.setCustomerPhone(intgResponse.getRespBody().getCustomerPhone());
			responseBody.setOrderDate(intgResponse.getRespBody().getOrderDate());
			responseBody.setOrderNumber(intgResponse.getRespBody().getOrderNumber());
			responseBody.setOrderStatus(intgResponse.getRespBody().getOrderStatus());
			
			Double orderTotal = intgResponse.getRespBody().getOrderTotal() ;
			responseBody.setOrderTotal(DECIMALFORMAT.format(orderTotal));
			
			responseBody.setPoNumber(intgResponse.getRespBody().getPoNumber());
			responseBody.setProductName(intgResponse.getRespBody().getProductName());
			responseBody.setQuantity(intgResponse.getRespBody().getQuantity());
			responseBody.setReferenceNumber(intgResponse.getRespBody().getReferenceNumber());
			
			Double salePrice = intgResponse.getRespBody().getSalePrice() ;
			responseBody.setSalePrice(DECIMALFORMAT.format(salePrice));
			responseBody.setShippingCarrier(intgResponse.getRespBody().getShippingCarrier());
			responseBody.setShippingMethod(intgResponse.getRespBody().getShippingMethod());
			responseBody.setSku(intgResponse.getRespBody().getSku());
			responseBody.setSrNo(intgResponse.getRespBody().getSrNo());
			responseBody.setState(intgResponse.getRespBody().getState());
			responseBody.setStoreOrderId(intgResponse.getRespBody().getStoreOrderId());
			responseBody.setStoreShippingMethod(intgResponse.getRespBody().getStoreShippingMethod());
			
			Double supplierTotalCost = intgResponse.getRespBody().getSupplierCostPerSKU();	
			responseBody.setSupplierCostTotal(DECIMALFORMAT.format(supplierTotalCost));
			responseBody.setSupplierName(intgResponse.getRespBody().getSupplierName());
			responseBody.setTrackingNumbers(intgResponse.getRespBody().getTrackingNumbers());
			Double amazonAmount = intgResponse.getRespBody().getAmazonAmount();
			responseBody.setAmazonAmount(DECIMALFORMAT.format(amazonAmount));
			Double extNetUnit = intgResponse.getRespBody().getExtNetUnit();
			responseBody.setExtNetUnit(DECIMALFORMAT.format(extNetUnit));
			Double profit =intgResponse.getRespBody().getProfit();
			responseBody.setProfit(DECIMALFORMAT.format(profit));
			
			Double avgProfit = intgResponse.getRespBody().getAvgProfit() ;
			responseBody.setAvgProfit(DECIMALFORMAT.format(avgProfit));
			
			Double roi =intgResponse.getRespBody().getRoi();
			responseBody.setRoi(DECIMALFORMAT.format(roi));
			responseBody.setZip(intgResponse.getRespBody().getZip());
			
			resourceResponse.setRespBody(responseBody);
			processRespList.add(resourceResponse);
		});
		logger.debug("exit from buildResponse method");
		return processRespList;
	}
	
}

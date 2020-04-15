package com.dalrada.reconcile.process.responseBuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.reconcile.integration.beans.ReconcileIntgResponse;
import com.dalrada.reconcile.process.beans.ProcessResponseBody;
import com.dalrada.reconcile.process.beans.ReconcileProcessResponse;

/**
 * @author Sneha
 *
 */
@Component
public class ReconcileProcessResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ReconcileProcessResponseBuilder.class);
	
	public List<ReconcileProcessResponse> buildResponse(List<ReconcileIntgResponse> intgRespList) {
		logger.debug("enter into buildResponse mehtod");
		List<ReconcileProcessResponse> processRespList = new ArrayList<ReconcileProcessResponse>();
		intgRespList.forEach(intgResponse ->{
			ReconcileProcessResponse processResponse = new ReconcileProcessResponse();
			processResponse.setResponseCode(intgResponse.getResponseCode());
			processResponse.setResponseMsg(intgResponse.getResponseMsg());
			ProcessResponseBody responseBody = new ProcessResponseBody();
			responseBody.setAddressLine1(intgResponse.getResponseBody().getAddressLine1());
			responseBody.setAddressLine2(intgResponse.getResponseBody().getAddressLine2());
			responseBody.setChannelName(intgResponse.getResponseBody().getChannelName());
			responseBody.setCity(intgResponse.getResponseBody().getCity());
			responseBody.setCompany(intgResponse.getResponseBody().getCompany());
			responseBody.setCountry(intgResponse.getResponseBody().getCountry());
			responseBody.setCustomerEmail(intgResponse.getResponseBody().getCustomerEmail());
			responseBody.setCustomerName(intgResponse.getResponseBody().getCustomerName());
			responseBody.setCustomerPhone(intgResponse.getResponseBody().getCustomerPhone());
			responseBody.setExtNetUnit(intgResponse.getResponseBody().getExtNetUnit());
			responseBody.setOrderDate(intgResponse.getResponseBody().getOrderDate());
			responseBody.setOrderNumber(intgResponse.getResponseBody().getOrderNumber());
			responseBody.setOrderStatus(intgResponse.getResponseBody().getOrderStatus());
			
			try {
				responseBody.setOrderTotal(Double.valueOf(intgResponse.getResponseBody().getOrderTotal()));
			} catch (NumberFormatException e) {
				responseBody.setOrderTotal(null);
			}
			responseBody.setPoNumber(intgResponse.getResponseBody().getPoNumber());
			responseBody.setProductName(intgResponse.getResponseBody().getProductName());
			try {
				responseBody.setQuantity(Long.valueOf(intgResponse.getResponseBody().getQuantity()));
			} catch (NumberFormatException e) {
				responseBody.setQuantity(null);
			}
			responseBody.setReferenceNumber(intgResponse.getResponseBody().getReferenceNumber());
			try {
				responseBody.setSalePrice(Double.valueOf(intgResponse.getResponseBody().getSalePrice()));
			} catch (NumberFormatException e) {
				responseBody.setSalePrice(null);
			}
			responseBody.setShippingCarrier(intgResponse.getResponseBody().getShippingCarrier());
			responseBody.setShippingMethod(intgResponse.getResponseBody().getShippingMethod());
			responseBody.setSku(intgResponse.getResponseBody().getSku());
			responseBody.setSrNo(intgResponse.getResponseBody().getSrNo());
			responseBody.setState(intgResponse.getResponseBody().getState());
			responseBody.setStoreOrderId(intgResponse.getResponseBody().getStoreOrderId());
			responseBody.setStoreShippingMethod(intgResponse.getResponseBody().getStoreShippingMethod());
			try {
				responseBody.setSupplierCostPerSKU(Double.valueOf(intgResponse.getResponseBody().getSupplierCostPerSKU()));
			} catch (NumberFormatException e) {
				responseBody.setSupplierCostPerSKU(null);
			}
			try {
				responseBody.setSupplierCostTotal(Double.valueOf(intgResponse.getResponseBody().getSupplierCostTotal()));
			} catch (NumberFormatException e) {
				responseBody.setSupplierCostTotal(null);
			}
			responseBody.setSupplierName(intgResponse.getResponseBody().getSupplierName());
			responseBody.setTrackingNumbers(intgResponse.getResponseBody().getTrackingNumbers());
			responseBody.setZip(intgResponse.getResponseBody().getZip());
			Double salePrice = responseBody.getSalePrice() ;
			Long quantity = responseBody.getQuantity();
			Double amazonAmount = calculateAmazonAmount(salePrice ,quantity );
			responseBody.setAmazonAmount(amazonAmount);
			Double extNetUnit = responseBody.getExtNetUnit();
			Double profit = calculateProfit(amazonAmount ,extNetUnit );
			responseBody.setProfit(profit);
			Double roi = calculateRoi(profit , extNetUnit);
			responseBody.setRoi(roi);
			processResponse.setRespBody(responseBody);
			processRespList.add(processResponse);
		});
		logger.debug("exit from buildResponse mehtod");
		return processRespList;
	}

	private Double calculateAmazonAmount(Double salePrice, Long quantity) {
		logger.debug("enter into calculateAmazonAmount mehtod");
		double amzPercentage = 0.00;
		if(salePrice < 10d){
		amzPercentage = 0.08;
		}else{
		amzPercentage = 0.15;
		}
		Double amazonAmount = salePrice - (salePrice * amzPercentage) ;
		logger.debug("exit from calculateAmazonAmount mehtod");
		return amazonAmount;
	}

	private Double calculateProfit(Double amazonAmount, Double extNetUnit) {
		logger.debug("enter into calculateProfit mehtod");
		Double profit = 0.00;
		if(extNetUnit > 0.00){
			profit = amazonAmount - extNetUnit;
			}else{
			profit = 0.00;
			}
		logger.debug("exit from calculateProfit mehtod");
		return profit;
	}

	private Double calculateRoi(Double profit, Double extNetUnit) {
		logger.debug("enter into calculateRoi mehtod");
		Double roi = 0.00 ;
		if(extNetUnit != 0.00){
			roi = (profit*100)/extNetUnit;
			}
		logger.debug("exit from calculateRoi mehtod");
		return roi ;
	}

	
}

package com.dalrada.reconcile.process;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.reconcile.integration.ReconcileIntegration;
import com.dalrada.reconcile.integration.beans.ReconcileIntgResponse;
import com.dalrada.reconcile.integration.exception.BusinessException;
import com.dalrada.reconcile.integration.exception.SystemException;
import com.dalrada.reconcile.process.beans.ReconcileProcessResponse;
import com.dalrada.reconcile.process.responseBuilder.ReconcileProcessResponseBuilder;
/**
 * @author Sneha
 *
 */
@Component
public class ReconcileProcess {

	ReconcileIntegration Intg;
	ReconcileProcessResponseBuilder responseBuilder;
	private static final Logger logger = LoggerFactory.getLogger(ReconcileProcess.class);
	// used for automatic dependency injection and  we inject the 
	//class dependencies through spring bean configuration file.
	@Autowired
	public ReconcileProcess(ReconcileIntegration intg,
			ReconcileProcessResponseBuilder responseBuilder) {
		super();
		Intg = intg;
		//It can be used to refer instance variable of current class.
		this.responseBuilder = responseBuilder;
	}

	
	public List<ReconcileProcessResponse> getAllOrders( String startDate ,String endDate) throws BusinessException, SystemException {
		logger.debug("enter into getAllUsers method");
		List<ReconcileIntgResponse> intgRespList = Intg.getAllOrders(startDate , endDate);
		List<ReconcileProcessResponse> processRespList = responseBuilder.buildResponse(intgRespList);
		List<ReconcileProcessResponse> respListWOAvgProfit = processRespList.stream().sorted(Comparator.comparing(resourceResp -> resourceResp.getRespBody().getSrNo()))
				.collect(Collectors.toList());
		List<ReconcileProcessResponse> respList = getListWithAvgProfit(respListWOAvgProfit);
		logger.debug("exit from getAllUsers method");
		
		return respList;
	}


	private List<ReconcileProcessResponse> getListWithAvgProfit(List<ReconcileProcessResponse> respListWOAvgProfit) {
		
		
		Map<String , List<ReconcileProcessResponse>> map = respListWOAvgProfit.parallelStream().collect(Collectors.groupingBy(item -> item.getRespBody().getSku()));
		
		 List<String> skuList = respListWOAvgProfit.parallelStream().map(item -> item.getRespBody().getSku()).distinct().collect(Collectors.toList());
		
		 List<ReconcileProcessResponse> processResponseList = skuList.parallelStream().map(sku ->{
			List<ReconcileProcessResponse> respList = map.get(sku);
			Double avgProfit = respList.stream().mapToDouble(item -> item.getRespBody().getProfit()).average().orElseGet(()->0.0);
			return respList.stream().map(item -> {
			                               item.getRespBody().setAvgProfit(avgProfit*1.235);
			                               return item;
			}).collect(Collectors.toList());
		 }).flatMap(list -> list.stream()).collect(Collectors.toList());		
		return processResponseList;
	}
}

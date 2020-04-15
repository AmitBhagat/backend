/**
 * 
 */
package com.dalrada.upload.intg.responseBuilder;

import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beans.OrderIntgResponse;
import com.dalrada.upload.intg.entity.OrderDetails;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderIntgResponseBuilder {
	/**
	 * @param entity
	 * @return
	 */
	public OrderIntgResponse buildResponse(OrderDetails order) {
		OrderIntgResponse response = new OrderIntgResponse();
		response.setRespCode("200");
		response.setRespMsg("successful");
		return response ;
	}

	public OrderIntgResponse buildResponse(String string, String string2) {
		OrderIntgResponse response = new OrderIntgResponse();
		response.setRespCode("200");
		response.setRespMsg("successful");
		return response ;
	}
}

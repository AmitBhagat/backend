/**
 * 
 */
package com.dalrada.upload.intg.responseBuilder;

import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.beans.WarehouseIntgResponse;
import com.dalrada.upload.intg.entity.OrderDetails;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseIntgResponseBuilder {
	/**
	 * @param entity
	 * @return
	 */
	public WarehouseIntgResponse buildResponse(OrderDetails entity) {
		WarehouseIntgResponse response = new WarehouseIntgResponse();
		response.setRespCode("200");
		response.setRespMsg("successful");
		return response ;
	}

	public WarehouseIntgResponse buildResponse(String respCode, String respMsg) {
		WarehouseIntgResponse response = new WarehouseIntgResponse();
		response.setRespCode(respCode);
		response.setRespMsg(respMsg);
		return response ;
	}
}

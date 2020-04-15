/**
 * 
 */
package com.dalrada.upload.resource.validator;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.dalrada.upload.resource.beans.WarehouseResourceRequest;
import com.dalrada.upload.resource.exception.InvalidRequestException;
import com.dalrada.upload.util.WarehouseConstants;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseResourceValidator {

	public void validate(WarehouseResourceRequest request) throws IllegalStateException, IOException, InvalidRequestException {
		  
		if(request == null) {	  
			  throw new InvalidRequestException("101","Empty request"); 
			  }
		  File file = request.getFile() ;
		  if(request.getFile() == null) {	  
			  throw new InvalidRequestException("102","File Required"); 
			  }
		  if(! file.getName().endsWith(".csv") && ! file.getName().endsWith(".CSV")) {	  
		  throw new InvalidRequestException("103","File format not valid "); 
		  }
		 
		  if(request.getId() != WarehouseConstants.getWareHouseId()) { throw new
		  InvalidRequestException("105","Warehouse Id not matched"); }
		 
	}

}

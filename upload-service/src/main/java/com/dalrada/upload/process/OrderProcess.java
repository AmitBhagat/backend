/**
 * 
 */
package com.dalrada.upload.process;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.dalrada.upload.intg.OrderIntg;
import com.dalrada.upload.intg.beans.OrderIntgRequest;
import com.dalrada.upload.intg.beans.OrderIntgResponse;
import com.dalrada.upload.intg.exception.SystemException;
import com.dalrada.upload.process.beans.OrderProcessRequest;
import com.dalrada.upload.process.beans.OrderProcessResponse;
import com.dalrada.upload.process.requestBuilder.OrderProcessRequestBuilder;
import com.dalrada.upload.process.responseBuilder.OrderProcessResponseBuilder;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderProcess {

	private final OrderProcessResponseBuilder orderRespBuilder ;
	private final OrderProcessRequestBuilder orderReqBuilder ;
	private final OrderIntg orderIntg ;

	public OrderProcess(OrderProcessResponseBuilder orderRespBuilder, OrderProcessRequestBuilder orderReqBuilder,
			OrderIntg orderIntg, OrderProcessResponseBuilder respBuilder, OrderProcessRequestBuilder reqBuilder) {
		super();
		this.orderRespBuilder = orderRespBuilder;
		this.orderReqBuilder = orderReqBuilder;
		this.orderIntg = orderIntg;
	}


	public OrderProcessResponse uploadOrder(@RequestBody OrderProcessRequest request ) throws SystemException{
		OrderIntgRequest intgRequest = orderReqBuilder.buildRequest(request);
		OrderIntgResponse intgResp = orderIntg.uploadOrder(intgRequest);
		OrderProcessResponse response = orderRespBuilder.buildResponse(intgResp);
		return response;

	}
	

	private String readData(MultipartFile file) throws IOException {
		/**
		 * Read the data from the file and store it into the list
		 */
		file.transferTo(Paths.get("classpath:data/resource-data.txt"));
		Stream<String> lines = Files.lines(Paths.get("D:\\Dalrada old\\42_23223_2019112821361.csv"));
		StringBuilder str = lines.collect(StringBuilder :: new , (a,b)-> a.append("~").append(b) , StringBuilder :: append);
		String st = new String(str);

		return st;
	}
}

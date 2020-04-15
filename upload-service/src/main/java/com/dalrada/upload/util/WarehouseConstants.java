package com.dalrada.upload.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseConstants {
	private static Resource resource ;
	private static String wareHouseId ;
	private static String toDate ;
	private static String fromDate ;
	private static String custNumber ;
	private static int lineCount ;

	public static void setConstants(Resource resource , String wareHouseId ) throws IOException {
		setResource(resource);
		setDates(resource);
		setCustNumber(resource);
		setLineCount(resource);
	}
		
	private static void setResource(Resource resource) {
		WarehouseConstants.resource = resource;
	}


	private static void setDates(Resource resource) throws IOException {
		String secondLine = Files.lines(Paths.get(resource.getURI()))
				.skip(1)
				.limit(1)
				.filter(q -> q.contains("Time Period:"))
				.collect(Collectors.toList()).get(0);

		String duration = Arrays.asList(secondLine.split("~+")).stream().filter(q -> q.contains("Time Period:"))
				.map(q ->q.substring(13, 40)).findFirst().get();

		List<String> dates = Arrays.asList(duration.split("to"));

		String firstDate = dates.get(0).trim();
		String lastDate = dates.get(1).trim();
		WarehouseConstants.fromDate =firstDate;
		WarehouseConstants.toDate = lastDate;
	}

	private static void setCustNumber(Resource resource) throws IOException {
		String line = Files.lines(Paths.get(resource.getURI()))
				.skip(2).limit(1).collect(Collectors.toList()).get(0);
		String customerNumber = Arrays.asList(line.split("\\s+")).get(1);
		WarehouseConstants.custNumber = customerNumber ;
		WarehouseConstants.wareHouseId =customerNumber;
	}

	private static void setLineCount(Resource resource) throws IOException {
		int lineCount = (int)Files.lines(Paths.get(resource.getURI())).count();
		WarehouseConstants.lineCount =lineCount ;
		WarehouseConstants.lineCount = lineCount;
	}

	public static String getToDate() {
		return toDate;
	}
	public static String getFromDate() {
		return fromDate;
	}
	public static String getWareHouseId() {
		return wareHouseId;
	}
	public static Resource getResource() {
		return resource;
	}
	public static String getCustNumber() {
		return custNumber;
	}
	public static int getLineCount() {
		return lineCount;
	}

}

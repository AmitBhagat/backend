package com.dalrada.upload.util;

import java.time.LocalDate;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderConstants {
	private static Resource resource ;
	private static LocalDate toDate ;
	private static LocalDate fromDate ;
	public static Resource getResource() {
		return resource;
	}
	public static void setResource(Resource resource) {
		OrderConstants.resource = resource;
	}
	public static LocalDate getToDate() {
		return toDate;
	}
	public static void setToDate(LocalDate toDate) {
		OrderConstants.toDate = toDate;
	}
	public static LocalDate getFromDate() {
		return fromDate;
	}
	public static void setFromDate(LocalDate fromDate) {
		OrderConstants.fromDate = fromDate;
	}
		
	
}

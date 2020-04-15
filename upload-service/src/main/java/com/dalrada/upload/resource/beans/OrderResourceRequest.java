/**
 * 
 */
package com.dalrada.upload.resource.beans;

import java.io.File;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Kavya
 *
 * 06-Jan-2020
 */
public class OrderResourceRequest {

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate lastDate;
	
	private File file ;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getLastDate() {
		return lastDate;
	}

	public void setLastDate(LocalDate lastDate) {
		this.lastDate = lastDate;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderResourceRequest [startDate=").append(startDate).append(", lastDate=").append(lastDate)
				.append(", file=").append(file).append("]");
		return builder.toString();
	}
}

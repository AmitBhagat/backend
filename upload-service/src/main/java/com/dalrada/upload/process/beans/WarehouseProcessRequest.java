/**
 * 
 */
package com.dalrada.upload.process.beans;

import java.io.File;

/**
 * @author Amit
 *
 * 06-Jan-2020
 */
public class WarehouseProcessRequest {

	String id ;
	File file ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		builder.append("WarehouseRequest [id=").append(id).append(", file=").append(file).append("]");
		return builder.toString();
	}
}

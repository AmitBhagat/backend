package com.dalrada.upload.intg.writer;

import java.io.IOException;
import java.util.List;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
public interface Writer {
	public void write(List<String> lines) throws IOException ;
}

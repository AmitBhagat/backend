package com.dalrada.upload.intg.tasklet;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.writer.OrderWriter;
import com.dalrada.upload.util.OrderConstants;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class OrderTasklet{

	@Autowired
	OrderWriter writer;

	public void execute() throws Exception {
		List<String> lines =Files.lines(Paths.get(OrderConstants.getResource().getURI()))
				.skip(1)
				.parallel()
				.collect(Collectors.toList());	
		writer.write(lines);
	}
}
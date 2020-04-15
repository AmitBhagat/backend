package com.dalrada.upload.intg.tasklet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.upload.intg.exception.SystemException;
import com.dalrada.upload.intg.writer.CustomerWriter;
import com.dalrada.upload.intg.writer.InvoiceMasterWriter;
import com.dalrada.upload.intg.writer.InvoiceWriter;
import com.dalrada.upload.intg.writer.ShippingWriter;
import com.dalrada.upload.intg.writer.Writer;
import com.dalrada.upload.util.WarehouseConstants;
/**
 * @author Amit
 *
 * 06-Jan-2020
 */
@Component
public class WarehouseTasklet {

	@Autowired
	InvoiceWriter writer ;
	@Autowired
	InvoiceWriter invoiceWriter ;
	@Autowired
	CustomerWriter customerWriter ;
	@Autowired
	ShippingWriter shippingWriter ;
	@Autowired
	InvoiceMasterWriter invoiceMasterWriter ;

	public void execute() throws Exception {
		List<Writer> writers = new ArrayList<Writer>();
		writers.add(invoiceWriter);
		writers.add(customerWriter);
		writers.add(shippingWriter);
		writers.add(invoiceMasterWriter);
		
		Map< Writer , List<String>> writerMap = new HashMap<Writer, List<String>>();
		
		Map<Boolean, List<String>> lines1 = Files.lines(Paths.get(WarehouseConstants.getResource().getURI()))
				.skip(4)
				.parallel()
				.collect(Collectors.partitioningBy(line -> Stream.of(line.split("~")).count() == 17 && !line.contains("CALCULATED SHIPPING CHARG") && !line.contains("Totals for Invoice Number:")
						 && !line.contains("Totals for Customer:")));
		List<String> invoiceLines = lines1.get(true);
		writerMap.put(invoiceWriter, invoiceLines);
		// invoiceWriter.write(invoiceLines);

		List<String> remainingLines1 = lines1.get(false);
		Map<Boolean, List<String>> lines2 = remainingLines1.parallelStream()
				.collect(Collectors.partitioningBy(line -> line.contains("CALCULATED SHIPPING CHARG") ));

		List<String> shippingLines = lines2.get(true);
		writerMap.put(shippingWriter, shippingLines);
	//	shippingWriter.write(shippingLines);

		List<String> remainingLines2 = lines2.get(false);
		Map<Boolean, List<String>> lines3 = remainingLines2.parallelStream()
				.collect(Collectors.partitioningBy(line -> line.contains("Totals for Invoice Number:")));
		List<String> invoiceMasterLines = lines3.get(true);
		writerMap.put(invoiceMasterWriter, invoiceMasterLines);
	//	invoiceMasterWriter.write(invoiceMasterLines);

		List<String> remainingLines3 = lines3.get(false);
		List<String> customerLines = remainingLines3.parallelStream()
				.filter(line -> line.contains("Totals for Customer:"))
				.collect(Collectors.toList());
		writerMap.put(customerWriter, customerLines);
	//	customerWriter.write(customerLines);
		
		writers.parallelStream().forEach(writer ->{
			List<String> lines = writerMap.get(writer);
			try {
				writer.write(lines);
			} catch (IOException e) {
				
			}
		});
	}
}
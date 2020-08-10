package service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import service.FacturaManagementService;

public class FacturaManagementServiceImpl implements FacturaManagementService{

	private final String FACTURA_PATH = "facturanr.txt";
	
	@Override
	public Integer getFacturaNr() {
		try {
			final FileReader fileReader = new FileReader(FACTURA_PATH);
			final BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			bufferedReader.close();
			return Integer.parseInt(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return 0;
	}

	@Override
	public void updateFacturaNr() {
		try {
			int facturaNr = getFacturaNr();
			FileWriter fileWriter = new FileWriter(FACTURA_PATH);
			final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(new StringBuilder(String.valueOf(facturaNr + 1)).toString());
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

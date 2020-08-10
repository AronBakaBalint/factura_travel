package service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import service.ChitantaManagementService;

public class ChitantaManagementServiceImpl implements ChitantaManagementService {
	
	private final String CHITANTA_PATH = "chitantanr.txt";

	@Override
	public Integer getChitantaNr() {
		try {
			final FileReader fileReader = new FileReader(CHITANTA_PATH);
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
	public void updateChitantaNr() {
		try {
			int chitantaNr = getChitantaNr();
			FileWriter fileWriter = new FileWriter(CHITANTA_PATH);
			final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(new StringBuilder(String.valueOf(chitantaNr + 1)).toString());
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

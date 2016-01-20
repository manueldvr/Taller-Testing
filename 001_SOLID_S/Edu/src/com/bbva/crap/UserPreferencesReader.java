package com.bbva.crap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserPreferencesReader {


	public Position readPreferences(PreferencesFile preferencesFile) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(preferencesFile.getFile())));
		try {

			String lineStr = reader.readLine();

			return processLine(lineStr, preferencesFile);

		} finally {
			reader.close();
		}

	}

	private Position processLine(String lineStr, PreferencesFile preferencesFile) {
		Position location = new Position();
		location.setPositionX(processLocation(lineStr, preferencesFile.getPositionXLocationFrom(), preferencesFile.getPositionXLocationTo()));
		location.setPositionY(processLocation(lineStr, preferencesFile.getPositionYLocationFrom(), preferencesFile.getPositionYLocationTo()));
		return location;
	}

	private int processLocation(String lineStr, int from, int to) {

		validatePositionData(lineStr, from, to);

		String substring = lineStr.substring(from, to);

		int result = 0;
		try {
			result = Integer.parseInt(substring);
		} catch (NumberFormatException e) {
			throw new PreferencesException("NumberFormatException");
		}

		return result;
	}

	private void validatePositionData(String lineStr, int from, int to){
		
		if (to < from) {
			throw new PreferencesException("from < to");
		}

		if (to < lineStr.length()) {
			throw new PreferencesException("to < length");
		}
	}

}

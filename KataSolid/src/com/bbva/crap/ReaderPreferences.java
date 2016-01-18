package com.bbva.crap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderPreferences {

	private File file;
	private UserPreferences userPreferences;
	private UserPreferencePosition userPreferencePosition;
	
	public ReaderPreferences(File file, UserPreferences userPreferences) {
		this.file = file;
		this.userPreferences = userPreferences;
	}
	
	public UserPreferencePosition getUserPreferencePosition() {

		if (this.userPreferencePosition == null) {
			this.userPreferencePosition = new UserPreferencePosition();
			try {
				readPreferences();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this.userPreferencePosition;
	}
	
	private void readPreferences() throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		try {

			String lineStr;
			while ((lineStr = reader.readLine()) != null) {
				processLine(lineStr);
			}
		} finally {
			reader.close();
		}
	}
	
	private void processLine(String lineStr) {
		
		userPreferencePosition.setPositionX(processLocation(lineStr, userPreferences.getPositionXLocationFrom(),
				userPreferences.getPositionXLocationTo()));
		
		userPreferencePosition.setPositionY(processLocation(lineStr, userPreferences.getPositionXLocationFrom(),
				userPreferences.getPositionYLocationTo()));
	}

	private int processLocation(String lineStr, int from, int to) {

		if (from < to) {
			this.userPreferencePosition.addErrorCode("from < to");
		}

		if (to < lineStr.length()) {
			this.userPreferencePosition.addErrorCode("to < length");
		}

		String substring = lineStr.substring(from, to);

		int result = 0;
		try {
			result = Integer.parseInt(substring);
		} catch (NumberFormatException e) {
			this.userPreferencePosition.addErrorCode("NumberFormatException");
		}

		return result;
	}
	
}

package com.bbva.crap;

import java.util.ArrayList;
import java.util.List;

public class UserPreferencePosition {
	
	private List<String> errorCodes = new ArrayList<String>();;

	private int positionX;

	private int positionY;
	
	public List<String> getErrorCodes() {
		return errorCodes;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void addErrorCode(String errorCode) {
		errorCodes.add(errorCode);
	}
}

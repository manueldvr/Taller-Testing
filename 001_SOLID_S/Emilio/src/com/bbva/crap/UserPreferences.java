package com.bbva.crap;


public class UserPreferences {

	private int positionXLocationFrom;

	private int positionXLocationTo;

	private int positionYLocationFrom;

	private int positionYLocationTo;

	

	public UserPreferences(int positionXLocationFrom,
			int positionXLocationTo, int positionYLocationFrom,
			int positionYLocationTo) {
		this.positionXLocationFrom = positionXLocationFrom;
		this.positionXLocationTo = positionXLocationTo;
		this.positionYLocationFrom = positionYLocationFrom;
		this.positionYLocationTo = positionYLocationTo;
	}


	
	public int getPositionXLocationFrom() {
		return positionXLocationFrom;
	}


	public int getPositionXLocationTo() {
		return positionXLocationTo;
	}


	public int getPositionYLocationFrom() {
		return positionYLocationFrom;
	}


	public int getPositionYLocationTo() {
		return positionYLocationTo;
	}

	
}

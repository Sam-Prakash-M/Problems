package com.samprakash.level3.dto;

public class Cab {
   
	private String potition;
    private boolean isAvailable;
	public Cab(String potition) {
		super();
		this.potition = potition;
		this.isAvailable = true;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getPotition() {
		return potition;
	}

	public void setPotition(String potition) {
		this.potition = potition;
	}
}

package com.samprakash.level3.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer extends CabDriver {

	public Customer(String name, String passWord,int age, char gender) {
		super(name, passWord,age,gender);
		
	}

	private List<CustomerRides> rides = new ArrayList<>();

	public List<CustomerRides> getRides() {
		return rides;
	}

	public void setRides(List<CustomerRides> rides) {
		this.rides = rides;
	}
}

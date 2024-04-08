package com.samprakash.level3.dto;

public class CabDriverRide {

	private String source,destination;
	private int customerDetails;
	private float fare,zulaCommission;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public CabDriverRide(String source, String destination, int customerDetails, float fare, float zulaCommission) {
		super();
		this.source = source;
		this.destination = destination;
		this.customerDetails = customerDetails;
		this.fare = fare;
		this.zulaCommission = zulaCommission;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(int customerDetails) {
		this.customerDetails = customerDetails;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	public float getZulaCommission() {
		return zulaCommission;
	}
	public void setZulaCommission(float zulaCommission) {
		this.zulaCommission = zulaCommission;
	}
}

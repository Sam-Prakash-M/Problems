package com.samprakash.level3.dto;

public class CustomerRides {
	
	private String source,destination;
	private int cabDetail;
	private float fare;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getCabDetail() {
		return cabDetail;
	}
	public void setCabDetail(int cabDetail) {
		this.cabDetail = cabDetail;
	}
	public float getFare() {
		return fare;
	}
	public CustomerRides(String source, String destination, int cabDetail, float fare) {
		this.source = source;
		this.destination = destination;
		this.cabDetail = cabDetail;
		this.fare = fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
}

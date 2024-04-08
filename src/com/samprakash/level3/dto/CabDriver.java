package com.samprakash.level3.dto;

import java.util.ArrayList;
import java.util.List;

public class CabDriver {
	private String name, passWord;
	private char gender;
	private int age;
    private List<CabDriverRide> driverSummary = new ArrayList<>();
	public List<CabDriverRide> getDriverSummary() {
		return driverSummary;
	}

	public void setDriverSummary(List<CabDriverRide> driverSummary) {
		this.driverSummary = driverSummary;
	}

	public CabDriver(String name, String passWord,int age,char gender) {
		this.name = name;
		this.passWord = passWord;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

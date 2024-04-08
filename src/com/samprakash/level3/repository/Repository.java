package com.samprakash.level3.repository;

import java.util.HashMap;
import java.util.Map;

import com.samprakash.level3.dto.Cab;
import com.samprakash.level3.dto.CabDriver;
import com.samprakash.level3.dto.Customer;
import com.samprakash.level3.dto.Locations;

public class Repository {

	public static Map<Integer,CabDriver> drivers = new HashMap<>();
	public static Map<Integer,Customer> customers = new HashMap<>();
	public static Map<Integer,Locations> locations = new HashMap<>();
	public static Map<Integer,Cab> cabs = new HashMap<>();
}

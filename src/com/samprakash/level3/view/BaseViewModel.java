package com.samprakash.level3.view;

import java.util.List;
import java.util.Set;

import com.samprakash.level3.dto.Cab;
import com.samprakash.level3.dto.CabDriver;
import com.samprakash.level3.dto.CabDriverRide;
import com.samprakash.level3.dto.Customer;
import com.samprakash.level3.dto.CustomerRides;
import com.samprakash.level3.dto.Locations;
import com.samprakash.level3.repository.Repository;



public class BaseViewModel {

	private final BaseView baseView;

	public BaseViewModel(BaseView baseView) {
		this.baseView = baseView;
	}

	public void addCabDrivers() {
		Repository.drivers.put(1, new CabDriver("aaa", "111", 43, 'M'));
		Repository.drivers.put(2, new CabDriver("bbb", "222", 31, 'M'));
		Repository.drivers.put(3, new CabDriver("ccc", "333", 38, 'F'));
		Repository.drivers.put(4, new CabDriver("ddd", "444", 28, 'F'));
	//	baseView.showStatus("Cab Drivers Details added Successfully...");
		// System.out.println(Repository.drivers);

	}

	public void addCustomers() {
		Repository.customers.put(1, new Customer("zz", "99", 25, 'F'));
		Repository.customers.put(2, new Customer("yy", "88", 61, 'M'));
		Repository.customers.put(3, new Customer("xx", "77", 22, 'M'));
		Repository.customers.put(4, new Customer("ww", "66", 36, 'F'));
		//baseView.showStatus("Customer  Details added Successfully...");
		// System.out.println(Repository.customers);
	}

	public void addLocations() {

		Repository.locations.put(1, new Locations("A", 0));
		Repository.locations.put(3, new Locations("C", 4));
		Repository.locations.put(4, new Locations("D", 7));
		Repository.locations.put(6, new Locations("F", 9));
		Repository.locations.put(2, new Locations("B", 15));
		Repository.locations.put(7, new Locations("G", 18));
		Repository.locations.put(8, new Locations("H", 20));
		Repository.locations.put(5, new Locations("E", 23));
		//baseView.showStatus("Locations Details added Successfully...");
		// System.out.println(Repository.locations);

	}

	public void addCabInitialPositions() {
		Repository.cabs.put(1, new Cab("D"));
		Repository.cabs.put(2, new Cab("G"));
		Repository.cabs.put(3, new Cab("H"));
		Repository.cabs.put(4, new Cab("A"));
		//baseView.showStatus("Cab Position added Successfully...");
		// System.out.println(Repository.cabs);

	}

	public int validCabDrive(String userName, String passWord) {

		Set<Integer> keys = Repository.drivers.keySet();

		for (int key : keys) {
			CabDriver cabDriver = Repository.drivers.get(key);

			if (cabDriver.getName().equals(userName) && cabDriver.getPassWord().equals(passWord)) {
				//System.out.println("Curr Key..." + key);
				return key;
			}
		}
		return -1;
	}

	public int validCustomer(String userName, String passWord) {
		Set<Integer> keys = Repository.customers.keySet();

		for (int key : keys) {
			Customer cabDriver = Repository.customers.get(key);

			if (cabDriver.getName().equals(userName) && cabDriver.getPassWord().equals(passWord)) {
				//System.out.println("Curr Key..." + key);
				return key;
			}
		}
		return -1;
	}

	public void addCurrCustomer(Customer customer) {
		Set<Integer> keys = Repository.customers.keySet();
		int lastId = keys.stream().max((a,b) -> a- b).get();
		Repository.customers.put(lastId + 1, customer);
	}

	public void showAvailableCabs() {
		System.out.println("..................................................");
		Set<Integer> keys = Repository.cabs.keySet();
		for(int key : keys) {
			Cab currCab = Repository.cabs.get(key);
			if(currCab.isAvailable()) {
				System.out.println("location..."+currCab.getPotition());
				System.out.println("Car ID..."+key);
			}
		}
		System.out.println(".....................................................");
		
	}
	public String bookNearestCab(int customerID, String source, String destination) {
		Set<Integer> keys = Repository.cabs.keySet();
		
		int getDistanceFromOrgin = getDistance(source);
		System.out.println(getDistanceFromOrgin+" Distance...");
		int nearestLocation = Integer.MAX_VALUE;
		String nearestCab = "";
		for(int key : keys) {
			Cab currCab = Repository.cabs.get(key);
			if(currCab.isAvailable()) {
				int currDistance = Math.abs(getDistance(currCab.getPotition()) - getDistanceFromOrgin);
				//System.out.println("Current Distance..."+currDistance);
					if(currDistance < nearestLocation) {
						//System.out.println(currCab.getPotition()+" curr position...");
						nearestCab = currCab.getPotition();
						nearestLocation = currDistance;
					}
			}
			
		}
		System.out.println("Nearest Cab is ...."+nearestCab);
		  
		 
		return nearestCab;
	}

	private int getDistance(String source) {
		Set<Integer> keys = Repository.locations.keySet();
		
		for(int key : keys) {
			Locations location = Repository.locations.get(key);
			if(location.getName().equals(source)) {
				return location.getDistFromOrg();
			}
		}
		return -1;
	}

	public void confirmedBooking(String source, String destination, int customerID, String nearestCab) {
		
		int km = Math.abs(getDistance(destination) -  getDistance(source));
		Customer customer = Repository.customers.get(customerID);
		int nearestCabID = getCabID(nearestCab);
		//System.out.println(nearestCabID+" id is ");
		System.out.println("Your current cab is from : "+nearestCab+" To .."+destination);
		System.out.println("your fair is ..."+km*10);
		if(baseView.getConfirmation()) {
			customer.getRides().add(new CustomerRides(source, destination, nearestCabID, km * 10));
			  makeCabUnAvailable(nearestCab);
			  Repository.cabs.get(nearestCabID).setPotition(destination);
			addCarDriverSummary(new CabDriverRide(source,destination,customerID,km*10,(km*10)*(0.30f)),nearestCabID);
			
		}
		
		
	}

	private void addCarDriverSummary(CabDriverRide customerRides, int cabID) {
		
		Repository.drivers.get(cabID).getDriverSummary().add(customerRides);
	}

	private void makeCabUnAvailable(String nearestCab) {
		
		Set<Integer> keys = Repository.cabs.keySet();
		for(int key : keys) {
			Cab currCab = Repository.cabs.get(key);
			if(currCab.getPotition().equals(nearestCab)) {
				currCab.setAvailable(false);
			}
			else {
				currCab.setAvailable(true);
			}
		}
	}

	private int getCabID(String nearestCab) {
		Set<Integer> keys = Repository.cabs.keySet();
		int nearestCabID = Integer.MAX_VALUE;
		for(int key : keys) {
			Cab currCab = Repository.cabs.get(key);
			if(currCab.getPotition().equals(nearestCab)) {
	             if(Repository.drivers.get(key).getDriverSummary().size() < nearestCabID) {
	            	 nearestCabID = key;
	             }
				
			}
		}
		return nearestCabID;
	}

	public void showCustomerSummary(int customerID) {
		List<CustomerRides> rides = Repository.customers.get(customerID).getRides();
		
		for(CustomerRides ride : rides) {
			System.out.println("Source.."+ride.getSource());
			System.out.println("Destination..."+ride.getDestination());
			System.out.println("Cab Details..."+ride.getCabDetail());
			System.out.println("Total Fare..."+ride.getFare());
		}
		
	}

	public void showCarDriverSummary(int cabID) {
		List<CabDriverRide> cabDriver = Repository.drivers.get(cabID).getDriverSummary();
		for( CabDriverRide driver : cabDriver) {
			System.out.println("Source : "+driver.getSource());
			System.out.println("Destination : "+driver.getDestination());
			System.out.println("Customer Details : "+driver.getCustomerDetails());
			System.out.println("Fare..."+driver.getFare());
			System.out.println("Zula Commitions.."+driver.getZulaCommission());
		}
		
	}

}

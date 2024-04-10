package com.samprakash.level3.view;

import java.util.Scanner;

import com.samprakash.level3.dto.Customer;



public class BaseView {
   
	private final BaseViewModel baseViewModel;
	private final Scanner scanner = new Scanner(System.in);
	
	public BaseView() {
		this.baseViewModel = new BaseViewModel(this);
	}
	public void init() {
		
		
		baseViewModel.addCabDrivers();
		baseViewModel.addCustomers();
		baseViewModel.addLocations();
		baseViewModel.addCabInitialPositions();
		showMenu();
		
	}
	private void showMenu() {
		
		System.out.println("Welcome to Sam Prakash Cab Booking Application...");
		
		int choice = 0;
		while(choice != 5) {
			System.out.println("Enter Below Options...\n"
					+ "1) Cab Driver...\n"
					+ "2) Customer...\n"
					+"3) Admin...\n"
					+"4) CabDriver Summary..\n"
					+ "5) Exit..");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			   
			case 1 -> {
				System.out.println("Enter a userName...");
				String userName = scanner.nextLine();
				System.out.println("Enter a PassWord...");
				String passWord = scanner.nextLine();
				int cabDriverID = baseViewModel.validCabDrive(userName,passWord);
				 if(cabDriverID != -1) {
					// System.out.println("User valid SuccessFul...");
					 
					 
				 }
				 else {
					 showStatus("Cab Driver Details are Invalid");
				 }
			}
			case 2-> {
				
				customerUI();
				
			}
			case 3-> {
				
			}
			case 4-> {
				System.out.println("Enter a Car Driver ID...");
				int cabID = scanner.nextInt();
				scanner.nextLine();
				baseViewModel.showCarDriverSummary(cabID);
			}
			default -> {
				System.out.println("Enter a Valid input...");
			}
			
			}
		}
		
		
	}
	
	private void customerUI() {
		
		int choice = 0;
		while(choice != 4) {
			
			System.out.println("1) Log in...\n"
					+"2) Sign Up...\n"
					+ "3) Customer Summary..."+"\n"
							+ "4) Exit ");
			       
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			
			case 1-> {
				System.out.println("Enter a userName...");
				String userName = scanner.nextLine();
				System.out.println("Enter a PassWord...");
				String passWord = scanner.nextLine();
				int customerID = baseViewModel.validCustomer(userName,passWord);
				if(customerID != -1) {
					baseViewModel.showAvailableCabs();
					// System.out.println("Customer valid SuccessFul...");
					 System.out.println("Enter a Source...");
					 String source = scanner.nextLine();
					 System.out.println("Enter a Destination...");
					 String destination = scanner.nextLine();
					 
					 String nearestCab = baseViewModel.bookNearestCab(customerID,source,destination);
					// System.out.println("Confirm You are going to Book...\n\"1 ) book \n"
					 //		+ "2) No");
					
					 
						 baseViewModel.confirmedBooking(source,destination,customerID,nearestCab);
					
					 
					 
				 }
				 else {
					 showStatus("Customer  Details are Invalid");
				 }
			}
			case 2-> {
				
				System.out.println("Enter a Name...");
				String name = scanner.nextLine();
				System.out.println("Enter a PassWord...");
				String passWord = scanner.nextLine();
				System.out.println("Enter a Age...");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter a Gender...");
				char gender = scanner.nextLine().charAt(0);
				baseViewModel.addCurrCustomer(new Customer(name, passWord, age, gender));
			}
			case 3-> {
				System.out.println("Enter a Customer Summary...");
				int customerID = scanner.nextInt();
				scanner.nextLine();
				baseViewModel.showCustomerSummary(customerID);
			}
			case 4-> {
				
			}
			default -> {
				System.out.println("Enter a Valid input...");
			}
			}
		}
		
	}
	public void showStatus(String status) {
		System.out.println(status);
	}
	public boolean getConfirmation() {
		System.out.println("Are you willing to book cab\n1) for book2)2 cancel");
		boolean result = scanner.nextInt() == 1 ? true : false;
		scanner.nextLine();
		return result;
	}

}

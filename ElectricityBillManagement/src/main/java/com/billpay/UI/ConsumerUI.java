package com.billpay.UI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidInputException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;
import com.billpay.Service.ConsumerService;
import com.billpay.Service.ConsumerServiceImpl;
import com.billpay.colors.ColorUI;



public class ConsumerUI {
	
	public static void consumerLogin(Scanner sc) {
		
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Consumer's Username : "+ColorUI.RESET);
		String userName=sc.next();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Consumer's Password : "+ColorUI.RESET);
		sc.nextLine();
		String password=sc.nextLine();
		System.out.println();
		

}



public static void displaySecurityQuestion() {
	System.out.println(ColorUI.BLACK_BOLD+"  Select 1 for : What is your favourite Game?");
	System.out.println("  Select 2 for : What is your High School name?");
	System.out.println("  Select 3 for : What is your favourite Food?");
	System.out.println("  Select 4 for : What is your favourite Color?");
	System.out.println("  Select 5 for : What is your favourite Place?"+ColorUI.RESET);
    System.out.println();
}







public static void consumerRegistration(Scanner sc) {
	
	
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your Username : "+ColorUI.RESET);
		String userName=sc.next();
		sc.nextLine();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your Email : "+ColorUI.RESET);
		String email=sc.nextLine();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your Password : "+ColorUI.RESET);
		String password=sc.nextLine();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your FirstName : "+ColorUI.RESET);
		String fName=sc.nextLine();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your LastName : "+ColorUI.RESET);
		String lName=sc.nextLine();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your Address (city)  : "+ColorUI.RESET);
		String address=sc.nextLine();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your Mobile No. : "+ColorUI.RESET);
		String mob=sc.nextLine();
		
		
		
		ConsumerService conService = new ConsumerServiceImpl();
		
		try {
			conService.registerConsumerData(fName, lName, userName, email, password, address, mob);
			displayConsumerMenu();
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
}



public static void displayConsumerMenu() {
	System.out.println();
	System.out.println(ColorUI.BLUE_BOLD+"  ***ROLE OF CONSUMER : "+ColorUI.RESET);
	System.out.println(ColorUI.BLACK_BOLD+"  Select 0 : To Log Out");
	System.out.println("  Select 1 : To Pay Bills");
	System.out.println("  Select 2 : To View transaction history.");
	System.out.println("  Select 3 : To File a Complaint."+ColorUI.RESET);
	System.out.println();
}



public static void consumerMenu(Scanner sc,ConsumerSave consumer) throws InvalidInputException {
	try {
		int choice=0;
		do {
			displayConsumerMenu();
			System.out.print(ColorUI.YELLOW_BOLD+"  Enter a selection from above : "+ColorUI.RESET);
			choice=Integer.parseInt(sc.next());
			System.out.println();
			
			switch(choice) {
			case 0 :
				System.out.println(ColorUI.GREEN_BOLD+"  ***"+consumer.getFirstName()+" "+consumer.getLastName()+" Logged Out Successfully***"+ColorUI.RESET);
				break;
			case 1 :
				payBills(sc,consumer);
				break;
			case 2 :
				viewTransactionHistory(sc,consumer);
				break;
			case 3 :
				fileComplaint(sc,consumer);
				break;	
			default :
				System.out.println(ColorUI.RED_BOLD+"  ***Invalid Input please try again***"+ColorUI.RESET);
			}
			
		}
		while(choice!=0);
	} catch (Exception e) {
		System.out.println("  ***"+e.getMessage()+"***");
		throw new InvalidInputException("Invalid Input! please enter valid input");
	}
}



public static void showAllPendingBills(Scanner sc,ConsumerSave consumer) {
	
	
	
	ConsumerService conService = new ConsumerServiceImpl();
	
	
}



public static String paymentMethod(Scanner sc) throws InvalidInputException {
	String one="BHIM UPI";
	System.out.println(ColorUI.BLACK_BOLD+"  Select 1 for BHIM UPI");
	String two="Credit Card";
	System.out.println("  Select 2 for Credit Card");
	String three="Debit Card";
	System.out.println("  Select 3 for Debit Card");
	String four="Internet Banking";
	System.out.println("  Select 4 for Internet Banking"+ColorUI.RESET);
	System.out.println();
	System.out.println();
	System.out.print(ColorUI.YELLOW_BOLD+"  Select Payment Method from Above : "+ColorUI.RESET);
	int choice=Integer.parseInt(sc.next());
	System.out.println();
	switch(choice) {
	case 1 :
		return one;
	case 2 :
		return two;
	case 3 :
	    return three;
	case 4 :	
		return four;
	default :
		throw new InvalidInputException(ColorUI.RED_BOLD+"  ***Invalid Input! please try again."+ColorUI.RESET);
	}
	
}



public static void payBills(Scanner sc,ConsumerSave consumer) {
//	showAllPendingBills(sc,consumer);
	
	System.out.print(ColorUI.YELLOW_BOLD+"  Enter Bill Id from above which you have to pay : "+ColorUI.RESET);
	String BillId=sc.next();
	System.out.println();
	
}
	





public static void viewTransactionHistory(Scanner sc,ConsumerSave consumer) {
	
}



public static void forgotPassword(Scanner sc) {
	
		
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your ConsumerId : "+ColorUI.RESET);
		String consId=sc.nextLine();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your old password : "+ColorUI.RESET);
		String oldPass=sc.nextLine();
		System.out.println();
		
		
		System.out.print(ColorUI.BLUE_BOLD+"  Enter New Password : "+ColorUI.RESET);
		String pass=sc.nextLine();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Confirm New Password : "+ColorUI.RESET);
		String conPass=sc.nextLine();
		
			
			
}


public static void displayComplaintType() {
	System.out.println(ColorUI.BLUE_BOLD+"  ***COMPLAINT MENU :- "+ColorUI.RESET);
	System.out.println(ColorUI.BLACK_BOLD+"  Select 1 : Power outages or interruptions");
	System.out.println("  Select 2 : High or fluctuating electricity bills");
	System.out.println("  Select 3 : Voltage or frequency fluctuations");
	System.out.println("  Select 4 : Power surges");
	System.out.println("  Select 5 : Electrical safety concerns");
	System.out.println("  Select 6 : Meter issues");
	System.out.println("  Select 7 : Connection or disconnection issues"+ColorUI.RESET);
	System.out.println();
	System.out.print(ColorUI.YELLOW_BOLD+"  Select Your Complaint Type from above : "+ColorUI.RESET);
	
}



public static String selectComplaint(Scanner sc) {
	String one="Power outages or interruptions";
	String two="High or fluctuating electricity bills";
	String three="Voltage or frequency fluctuations";
	String four="Power surges";
	String five="Electrical safety concerns";
	String six="Meter issues";
	String seven="Connection or disconnection issues";
	
	displayComplaintType();
	int choice=Integer.parseInt(sc.next());
	System.out.println();
	
	switch(choice) {
	case 1 :
		return one;
	case 2 :
		return two;
	case 3 :
		return three;
	case 4 :
		return four;
	case 5 :
		return five;
	case 6 :
		return six;
	case 7 :
		return seven;
	default :
		System.out.println(ColorUI.RED_BOLD+"  Invalid Input! please try again later"+ColorUI.RESET);
	}
	
	return "";
}



public static void fileComplaint(Scanner sc,ConsumerSave consumer) {
	
	
}

}

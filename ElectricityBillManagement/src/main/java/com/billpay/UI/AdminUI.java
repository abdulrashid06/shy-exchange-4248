package com.billpay.UI;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.billpay.DAO.AdminDao;
import com.billpay.DAO.AdminDaoImpl;
import com.billpay.Entity.Admin;
import com.billpay.Entity.Bill;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;
import com.billpay.colors.ColorUI;



public class AdminUI {
	
	public static void adminLogin(Scanner sc) {
		System.out.print(ColorUI.BLUE_BOLD+"  Enter admin's User-Name : "+ColorUI.RESET);
		String username=sc.next();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter admin's Password : "+ColorUI.RESET);
		String Password=sc.next();
		System.out.println();
		
		AdminDao ad = new AdminDaoImpl();
		
		try {
			if(ad.adminLoginDetails(username, Password)) {
				System.out.println(ColorUI.GREEN_BOLD+"  ### Logged in Successfully ###"+ColorUI.RESET);
				System.out.println();
				adminMenu(sc);
			}
		} catch (SomethingWentWrongException | InvalidUsernameOrPasswordException e) {
			System.out.println(ColorUI.RED_BOLD+"  ***"+e.getMessage()+"***"+ColorUI.RESET);
			System.out.println();
		}
		
	}

	
   public static void viewAllConsumers() {
		
	      AdminDao aDao = new AdminDaoImpl();
	      List<ConsumerSave> conList = null;
	      
	      try {
			conList = aDao.viewAllConsumerData();
			
			if(conList != null) {
				
				conList.forEach(c -> {
					System.out.println(ColorUI.PURPLE + "ConsumerId : "+c.getConsumerId() + "  |  FirstName : "+c.getFirstName() + "  |  LastName : "+c.getLastName() 
					+ "  |  UserName : "+c.getUserName() + "  |  Email : "+c.getEmail() + "  |  Address : "+c.getAddress() + "  |  Mobile : "+c.getMobileNum()+ColorUI.RESET);
				});
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		} 
	}

	
	
//	public static void displayAdminMenu() {
//		System.out.println(ColorUI.BLUE_BOLD+"  **ROLE OF THE ADMINISTRATOR :- "+ColorUI.RESET);
//		System.out.println(ColorUI.BLACK_BOLD+"  Select 0 -> To Log Out.");
//		System.out.println("  Select 1 -> To View all Consumers.");
//		System.out.println("  Select 2 -> To View the bill of the consumer by there Id. ");
//		System.out.println("  Select 3 -> To View all the bills.");
//		System.out.println("  Select 4 -> To View all paid bills.");
//		System.out.println("  Select 5 -> To View all pending bills.");
//		System.out.println("  Select 6 -> To Delete Consumer.");
//		System.out.println("  Select 7 -> To Generate Consumers Bill.");
//		System.out.println("  Select 8 -> To Resolve Consumers Complaints."+ColorUI.RESET);
//		System.out.println();
//		System.out.print(ColorUI.YELLOW_BOLD+"  Enter a selection from above: "+ColorUI.RESET);
//	}

	
	
	public static void viewConsumerBillById(Scanner sc) {
		System.out.print(ColorUI.BLUE_BOLD+"  Enter consumerId: "+ColorUI.RESET);
		String conId=sc.next();
		System.out.println();
		
		
		AdminDao aDao = new AdminDaoImpl();
		List<Bill> billList = null;
		try {
			
			billList = aDao.viewConsumerBillDataById(conId);
			
			billList.forEach(b -> {
				System.out.println(ColorUI.ORANGE+"  ConsumerId : "+b.getConsumer());
				System.out.println("  BillingId : "+b.getBillId());
				System.out.println("  Previous Reading : "+b.getPrevReading());
				System.out.println("  Current Reading : "+b.getCurrReading());
				System.out.println("  Units Consumed : "+b.getUnitConsumed());
				System.out.println("  Unit Rate : "+b.getUnitRate());
				System.out.println("  Total Amount : "+b.getTotalAmount());
				System.out.println("  tax : "+b.getTax());
				System.out.println("  Bill Starting Date : "+b.getStartDate());
				System.out.println("  Bill Ending Date : "+b.getEndDate());
				System.out.println("  Billing Date : "+b.getBilling_date());
				System.out.println("  Last Payment Date : "+b.getDueDate());
				System.out.println("  Payment Status : "+(b.getIsPaid() == 0 ? "Payment Is Pending" : "Payment Is Paid"+ColorUI.RESET));
			});
			
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		} 
		
	}

	
	
	public static void viewAllBills() {
		
		
		
	}
	
	
	
    public static void viewAllPaidBills() {
		
		
		
    }
	
    
    
    public static void viewAllPendingBills() {
		
		
    }
    
	
    
    public static void deleteConsumerById(Scanner sc) {
    	System.out.print(ColorUI.BLUE_BOLD+"  Enter consumerId : "+ColorUI.RESET);
    	String consId=sc.next();
    	
    	
    }
    
    
    
    public static void generateConsumersBill(Scanner sc) {
    	
    	
    }
    
    
    
    public static void adminMenu(Scanner sc) {
		int choice=0;
		
		try {
			do {
				
				System.out.println(ColorUI.BLUE_BOLD+"  **ROLE OF THE ADMINISTRATOR :- "+ColorUI.RESET);
				System.out.println(ColorUI.BLACK_BOLD+"  Select 0 -> To Log Out.");
				System.out.println("  Select 1 -> To View all Consumers.");
				System.out.println("  Select 2 -> To View the bill of the consumer by there Id. ");
				System.out.println("  Select 3 -> To View all the bills.");
				System.out.println("  Select 4 -> To View all paid bills.");
				System.out.println("  Select 5 -> To View all pending bills.");
				System.out.println("  Select 6 -> To Delete Consumer.");
				System.out.println("  Select 7 -> To Generate Consumers Bill.");
				System.out.println("  Select 8 -> To Resolve Consumers Complaints."+ColorUI.RESET);
				System.out.println();
				System.out.print(ColorUI.YELLOW_BOLD+"  Enter a selection from above: "+ColorUI.RESET);
				
				
				choice=sc.nextInt();
				System.out.println();
				
				switch(choice) {
				case 0 :
					System.out.println(ColorUI.GREEN_BOLD+"  ***Bye Bye Admin, administrator Logged Out Successfully***"+ColorUI.RESET);
					System.out.println();
					break;
				case 1 :
					viewAllConsumers();
					break;
				case 2 :
				    viewConsumerBillById(sc);
					break;
				case 3 :
					viewAllBills();
					break;
				case 4 :
					viewAllPaidBills();
					break;
				case 5 :
					viewAllPendingBills();
					break;
				case 6 :
					deleteConsumerById(sc);
					break;
				case 7 :
					generateConsumersBill(sc);
					break;
				case 8 :
					resolveComplaints(sc);
					break;
				default :
					System.out.println(ColorUI.RED_BOLD+"  xx> Invalid Input please try again <xx"+ColorUI.RESET);
					System.out.println();
				}
			}
			while(choice!=0);
		} catch (InputMismatchException e) {
			
			System.out.println(ColorUI.RED_BOLD+"  xx> Invalid Input type please enter numerical input <xx"+ColorUI.RESET);
			System.out.println();
		}
		System.out.println();
		System.out.println(ColorUI.BLACK_BOLD+"---x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x----"+ColorUI.RESET);
		System.out.println();
		
	}
    
    public static void resolveComplaints(Scanner sc) {
    	
    
    }
}

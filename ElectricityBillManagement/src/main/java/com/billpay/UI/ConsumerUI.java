package com.billpay.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.billpay.Entity.Bill;
import com.billpay.Entity.Complaint;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Entity.Transaction;
import com.billpay.Exception.InvalidInputException;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;
import com.billpay.Service.ComplaintService;
import com.billpay.Service.ComplaintServiceImpl;
import com.billpay.Service.ConsumerService;
import com.billpay.Service.ConsumerServiceImpl;
import com.billpay.colors.ColorUI;
import com.billpay.DAO.*;



public class ConsumerUI {
	
	public static void consumerLogin(Scanner sc) {
		
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Consumer's Username : "+ColorUI.RESET);
		String userName=sc.next();
		System.out.println();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Consumer's Password : "+ColorUI.RESET);
		sc.nextLine();
		String password=sc.nextLine();
		System.out.println();
		
		ConsumerService cService = new ConsumerServiceImpl();
		
		try {
			ConsumerSave consumer = cService.consumerLoginData(userName, password);
			
			if(consumer.getIsActive()==0) {
				System.out.println();
				System.out.println(ColorUI.GREEN_BOLD+"  ***"+ColorUI.RESET+ColorUI.YELLOW_BOLD+consumer.getFirstName()+" "+consumer.getLastName()+ColorUI.RESET+ColorUI.GREEN_BOLD+" LoggedIn Successfully***"+ColorUI.RESET);
				System.out.println();
				consumerMenu(sc, consumer);
			}
			else {
				System.out.println();
				System.out.println(ColorUI.RED_BOLD+"  *** No account found ***"+ColorUI.RESET);
				System.out.println();
				
			}
			
		} catch (SomethingWentWrongException | InvalidInputException | InvalidUsernameOrPasswordException e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  ***"+e.getMessage()+"***"+ColorUI.RESET);
			System.out.println();
		} catch (Exception e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  ***"+e.getMessage()+"***"+ColorUI.RESET);
			System.out.println();
		}

}


//
//public static void displaySecurityQuestion() {
//	System.out.println(ColorUI.BLACK_BOLD+"  Select 1 for : What is your favourite Game?");
//	System.out.println("  Select 2 for : What is your High School name?");
//	System.out.println("  Select 3 for : What is your favourite Food?");
//	System.out.println("  Select 4 for : What is your favourite Color?");
//	System.out.println("  Select 5 for : What is your favourite Place?"+ColorUI.RESET);
//    System.out.println();
//}







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
		
		
		ConsumerSave con = new ConsumerSave(fName, lName, userName, email, password, address, mob);
		ConsumerService conService = new ConsumerServiceImpl();
		
		try {
			conService.registerConsumerData(fName, lName, userName, email, password, address, mob);
			try {
				consumerMenu(sc, con);
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
}



//public static void displayConsumerMenu() {
//	System.out.println();
//	System.out.println(ColorUI.BLUE_BOLD+"  ***ROLE OF CONSUMER : "+ColorUI.RESET);
//	System.out.println(ColorUI.BLACK_BOLD+"  Select 0 : To Log Out");
//	System.out.println("  Select 1 : To Pay Bills");
//	System.out.println("  Select 2 : To View transaction history.");
//	System.out.println("  Select 3 : To File a Complaint."+ColorUI.RESET);
//	System.out.println();
//}



public static void consumerMenu(Scanner sc,ConsumerSave consumer) throws InvalidInputException {
	try {
		int choice=0;
		do {

			System.out.println();
			System.out.println(ColorUI.BLUE_BOLD+"  ***ROLE OF CONSUMER : "+ColorUI.RESET);
			System.out.println(ColorUI.YELLOW_BOLD+"  Select 0 : To Log Out");
			System.out.println("  Select 1 : To Pay Bills");
			System.out.println("  Select 2 : To View transaction history.");
			System.out.println("  Select 3 : To File a Complaint.");
			System.out.println("  Select 4 : Check Complaint Status."+ColorUI.RESET);
			System.out.println();

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
			case 4 :
				getComplaintStatus(sc,consumer);
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



public static int showAllPendingBills(Scanner sc,ConsumerSave consumer) {
	
	int consId = consumer.getConsumerId();
	System.out.println();
	
	ConsumerService cService = new ConsumerServiceImpl();
	
	try {
		
		List<Bill> billList = cService.showAllPendingBillsData(consId);
		String name = consumer.getFirstName()+" "+consumer.getLastName();
		
		if(billList.size() > 0) {
			
		
		
		System.out.println();
		System.out.println(ColorUI.BLUE_BOLD+"  ***All Pending Electricity Bill of "+ColorUI.RESET+ColorUI.YELLOW_BOLD+name+ColorUI.RESET+" :- ");
		System.out.println();
		
		billList.forEach(s->{
			System.out.println(ColorUI.TEAL+"  ConsumerId : "+s.getConsumer().getConsumerId());
			System.out.println("  BillingId : "+s.getBillId());
			System.out.println("  Previous Reading : "+s.getPrevReading());
			System.out.println("  Current Reading : "+s.getCurrReading());
			System.out.println("  Units Consumed : "+s.getUnitConsumed());
			System.out.println("  Unit Rate : "+s.getUnitRate());
			System.out.println("  Total Amount : "+s.getTotalAmount());
			System.out.println("  tax : "+s.getTax());
			System.out.println("  Bill Starting Date : "+s.getStartDate());
			System.out.println("  Bill Ending Date : "+s.getEndDate());
			System.out.println("  Billing Date : "+s.getBilling_date());
			System.out.println("  Last Payment Date : "+s.getDueDate());
			System.out.println("  Payment Status : "+ColorUI.RESET +ColorUI.RED_BOLD +(s.getIsPaid() == 0 ? "Payment Is Pending" :ColorUI.RESET +ColorUI.GREEN_BOLD + "Payment Is Paid"+ColorUI.RESET));
			System.out.println();
		});
		}
		else {
			System.out.println();
			System.out.println(ColorUI.GREEN_BOLD+ "*** You have no pending bills ***" + ColorUI.RESET);
			System.out.println();
		}
		
		return billList.size();
	} catch (SomethingWentWrongException | NoRecordFoundException e) {
		System.out.println();
		System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		System.out.println();
	} catch (Exception e) {
		System.out.println();
		System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		System.out.println();
	}
	return 0;
	
}


public static void payBills(Scanner sc,ConsumerSave consumer) {
	
//	showAllPendingBills(sc, consumer);
	
//	System.out.print(ColorUI.YELLOW_BOLD+"  Enter Bill Id from above which you have to pay : "+ColorUI.RESET);
//	int BillId=sc.nextInt();
//	System.out.println();
	
	
	ConsumerService cService = new ConsumerServiceImpl();
	
	try {
		if(showAllPendingBills(sc, consumer) > 0) {
//		showAllPendingBills(sc, consumer);
		
		System.out.print(ColorUI.YELLOW_BOLD+"  Enter Bill Id from above which you have to pay : "+ColorUI.RESET);
		int BillId=sc.nextInt();
		System.out.println();
		
		String paymentMode = paymentMethod(sc);
		
		cService.payConsumerBill(BillId);
		TransactionDao tDao = new TransactionDaoImpl();
		Bill billObj = tDao.getBillByBillId(BillId);
		Transaction transaction = new Transaction(billObj.getTotalAmount(), LocalDateTime.now(), paymentMode);
		
		tDao.addTransactionData(transaction, consumer.getConsumerId());
		
		System.out.println();
		System.out.println(ColorUI.GREEN_BOLD+"  *** Payment Successfull ***"+ColorUI.RESET);
		System.out.println();
		}
	} catch (SomethingWentWrongException |InvalidInputException  e) {
		System.out.println();
		System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		System.out.println();
	}catch (Exception e) {
		System.out.println();
		System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		System.out.println();
	}
	
}
	




public static void viewTransactionHistory(Scanner sc,ConsumerSave consumer) {
	
	int consId=consumer.getConsumerId();
	System.out.println();
	TransactionDao tDao=new TransactionDaoImpl();
	String name = consumer.getFirstName()+" "+consumer.getLastName();
	
	try {
		List<Transaction> list=tDao.viewTransactionHistoryData(consId);
		
		Bill billO = tDao.getBillByBillId(consId);
		
		System.out.println();
		System.out.println(ColorUI.BLUE_BOLD+"  ***Transaction details of "+ColorUI.RESET+ColorUI.YELLOW_BOLD+name+ColorUI.RESET+" : ");
		System.out.println();
		list.forEach(s->{
//			System.out.println();
			System.out.println(ColorUI.TEAL+"  Consumer Id : "+s.getConsumer().getConsumerId());
			System.out.println("  Bill Id : "+billO.getBillId());
			System.out.println("  Transaction Id : "+s.getTransactionId());
			System.out.println("  Amount Paid : "+s.getAmountPaid());
			System.out.println("  Payment Date : "+s.getPaymentDate());
			System.out.println("  Payment Mathod : "+s.getPaymentMethod()+ColorUI.RESET);
			
		});
		
	} catch (SomethingWentWrongException | NoRecordFoundException e) {
		System.out.println();
		System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		System.out.println();
	} catch (Exception e) {
		System.out.println();
		System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		System.out.println();
	}
	
}



public static void forgotPassword(Scanner sc) {
	
		sc.nextLine();
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your ConsumerId : "+ColorUI.RESET);
		String consId=sc.nextLine();
		System.out.println();
		
		System.out.print(ColorUI.BLUE_BOLD+"  Enter Your old password : "+ColorUI.RESET);
		String oldPass=sc.nextLine();
		System.out.println();
		
		ConsumerDao cDao = new ConsumerDaoImpl();
		
		try {
			
			boolean result=cDao.verifySecurityCredentials(oldPass, consId);
			
			if(result) {
				System.out.println();
				System.out.print(ColorUI.BLUE_BOLD+"  Enter New Password : "+ColorUI.RESET);
				String pass=sc.nextLine();
				System.out.println();
				
				cDao.updatePassword(pass, consId);
				System.out.println();
				System.out.println(ColorUI.GREEN_BOLD+"  *** Password Updated Successfully ***"+ColorUI.RESET);
				System.out.println();
			}
			else {
				System.out.println();
				System.out.println(ColorUI.RED_BOLD+"  *** Wrong credentials! ***"+ColorUI.RESET);
				System.out.println();
			}
			
		} catch (SomethingWentWrongException | InvalidUsernameOrPasswordException | NoRecordFoundException  e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  ***"+e.getMessage()+"***"+ColorUI.RESET);
			System.out.println();
		} catch (Exception e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  ***"+e.getMessage()+"***"+ColorUI.RESET);
			System.out.println();
		}
			
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
	
	try {
		ComplaintDao cDao = new ComplaintDaoImpl();
		
		int conId = consumer.getConsumerId();
		LocalDateTime compDate = LocalDateTime.now();
		String compType=selectComplaint(sc);
		
		System.out.print(ColorUI.BLUE_BOLD+"  Provide a Short Description about your complaint  : "+ColorUI.RESET);
		sc.nextLine();
		String compDesc=sc.nextLine();
		System.out.println();
		
		String assignTo = "Admin";
		int status=0;
		LocalDateTime resDate = null;
		
		Complaint comp = new Complaint(compDate, compType, compDesc, assignTo, status, resDate);
		
		cDao.fileComplaintData(comp, conId);
		
		System.out.println();
		System.out.println(ColorUI.GREEN_BOLD+"  *** Complaint Filed Successfully ***"+ColorUI.RESET);
		System.out.println();
		
	} catch (Exception e) {
		System.out.println();
		System.out.println(ColorUI.RED_BOLD+"  ***"+e.getMessage()+"***"+ColorUI.RESET);
		System.out.println();
	}
	
}



private static void getComplaintStatus(Scanner sc, ConsumerSave consumer) {
	
	ComplaintDao cDao = new ComplaintDaoImpl();
	
	int conId = consumer.getConsumerId();
	
	try {
		
		List<Complaint> compList = cDao.getComplaintStatus(conId);
		
		if(compList.size() > 0) {
			
			compList.forEach(s->{
				System.out.println();
				System.out.println(ColorUI.TEAL+"  Consumer Id : "+s.getConsumer().getConsumerId());
				System.out.println("  Complaint Id : "+s.getComplaintId());
				System.out.println("  Complaint Date : "+s.getCompDate());
				System.out.println("  Complaint Type : "+s.getCompTypa());
				System.out.println("  Complaint Description : "+s.getCompDesc());
				System.out.println("  Assigned to : "+s.getAssignedTo());
				System.out.println("  Status : "+ColorUI.RESET +ColorUI.RED_BOLD + (s.getStatus()==0 ? "Pending" : ColorUI.RESET +ColorUI.GREEN_BOLD + "Resolved"+ColorUI.RESET));
				
			});
			
		}
		else {
			System.out.println();
			System.out.println(ColorUI.GREEN_BOLD+"  *** You do not have any complaint ***"+ColorUI.RESET);
			System.out.println();
		}
		
	} catch (SomethingWentWrongException | NoRecordFoundException e) {
		System.out.println();
		System.out.println(ColorUI.RED_BOLD+"  ***"+e.getMessage()+"***"+ColorUI.RESET);
		System.out.println();
	} catch (Exception e) {
		System.out.println();
		System.out.println(ColorUI.RED_BOLD+"  ***"+e.getMessage()+"***"+ColorUI.RESET);
		System.out.println();
	}
	
}


}

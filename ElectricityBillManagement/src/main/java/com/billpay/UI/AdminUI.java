package com.billpay.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl;

import com.billpay.DAO.AdminDao;
import com.billpay.DAO.AdminDaoImpl;
import com.billpay.DAO.BillDao;
import com.billpay.DAO.BillDaoImpl;
import com.billpay.DAO.ComplaintDao;
import com.billpay.DAO.ComplaintDaoImpl;
import com.billpay.DAO.TransactionDao;
import com.billpay.DAO.TransactionDaoImpl;
import com.billpay.Entity.Admin;
import com.billpay.Entity.Bill;
import com.billpay.Entity.Complaint;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Entity.Transaction;
import com.billpay.Exception.InvalidInputException;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;
import com.billpay.Service.BillService;
import com.billpay.Service.BillServiceImpl;
import com.billpay.Service.ComplaintService;
import com.billpay.Service.ComplaintServiceImpl;
import com.billpay.Service.ConsumerService;
import com.billpay.Service.ConsumerServiceImpl;
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
		
	      ConsumerService cService = new ConsumerServiceImpl();
	      List<ConsumerSave> conList = null;
	      
	      try {
			conList = cService.viewAllConsumerData();
			
			if(conList != null) {
				
				conList.forEach(c -> {
					System.out.println();
					System.out.println(ColorUI.PURPLE + "ConsumerId : "+c.getConsumerId() + "  |  FirstName : "+c.getFirstName() + "  |  LastName : "+c.getLastName() 
					+ "  |  UserName : "+c.getUserName() + "  |  Email : "+c.getEmail() + "  |  Address : "+c.getAddress() + "  |  Mobile : "+c.getMobileNum()+ColorUI.RESET);
				});
				System.out.println();
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		} catch(Exception ex) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+ex.getMessage()+" <xx"+ColorUI.RESET);
		}
	      System.out.println();
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
		
		
		BillDao billService = new BillDaoImpl();
		List<Bill> billList = new ArrayList<>();
		try {
			
			billList = billService.viewConsumerBillDataById(conId);
			
			billList.forEach(b -> {
//				System.out.println(ColorUI.CYAN+"|  ConsumerId : "+b.getConsumer().getConsumerId() + "|  BillingId : "+b.getBillId()
//				+ "|  Previous Reading : "+b.getPrevReading() + "|  Current Reading : "+b.getCurrReading() + "|  Units Consumed : "+b.getUnitConsumed()
//				+ "|  Unit Rate : "+b.getUnitRate() + "|  Total Amount : "+b.getTotalAmount() + "|  tax : "+b.getTax() 
//				+ "|  Bill Starting Date : "+b.getStartDate() + "|  Bill Ending Date : "+b.getEndDate() + "|  Billing Date : "+b.getBilling_date()
//				+ "|  Last Payment Date : "+b.getDueDate() + "|  Payment Status : "+(b.getIsPaid() == 0 ? "Payment Is Pending  " : "Payment Is Paid"+ColorUI.RESET));
				
				
				System.out.println(ColorUI.CYAN+"  ConsumerId : "+b.getConsumer().getConsumerId());
				System.out.println("  Consumer Name : "+b.getConsumer().getFirstName() +" "+ b.getConsumer().getLastName());
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
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		} catch (Exception ex) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+ex.getMessage()+" <xx"+ColorUI.RESET);
		}
		System.out.println();
		
	}

	
	
	public static void viewAllBills() {
		
		BillService bService = new BillServiceImpl();
		List<Bill> list = new ArrayList<>();
		
		try {
			list = bService.viewAllBillsData();
			list.forEach(b -> {
				
				String name = null;
				
				try {
					name = b.getConsumer().getFirstName()+" "+ b.getConsumer().getLastName();
				} catch ( Exception  e) {
					System.out.println();
					System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
				}
				
				System.out.println();
				System.out.println(ColorUI.BLUE_BOLD+"  ***Bill for "+ColorUI.RESET+ColorUI.YELLOW_BOLD+name+ColorUI.RESET+ColorUI.BLACK+" :- "+ColorUI.RESET);
//				System.out.println();
				
				System.out.println(ColorUI.ROSY_PINK+"  ConsumerId : "+b.getConsumer().getConsumerId());
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
				System.out.println("  Bill Payment Status : "+(b.getIsPaid() == 0 ? "Payment Is Pending" : "Payment Is Paid"+ColorUI.RESET));
				
			});
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		} catch (Exception ex) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+ex.getMessage()+" <xx"+ColorUI.RESET);
		}
		System.out.println();
		
	}
	
	
	
    public static void viewAllPaidBills() {
		
    	BillService bService = new BillServiceImpl();
		List<Bill> list = new ArrayList<>();
		
		try {
			list = bService.viewAllPaidBillsData();
			list.forEach(b -> {
				
				String name = null;
				
				try {
					name = b.getConsumer().getFirstName()+" "+ b.getConsumer().getLastName();
				} catch ( Exception  e) {
					System.out.println();
					System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
				}
				
				System.out.println();
				System.out.println(ColorUI.BLUE_BOLD+"  ***Bill for "+ColorUI.RESET+ColorUI.YELLOW_BOLD+name+ColorUI.RESET+ColorUI.BLACK+" :- "+ColorUI.RESET);
//				System.out.println();
				
				System.out.println(ColorUI.BLACK_BOLD+"  ConsumerId : "+b.getConsumer().getConsumerId());
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
				System.out.println("  Bill Payment Status : "+(b.getIsPaid() == 0 ? "Payment Is Pending" : "Payment Is Paid"+ColorUI.RESET));
				
			});
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		} catch (Exception ex) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+ex.getMessage()+" <xx"+ColorUI.RESET);
		}
		System.out.println();
		
		
    }
	
    
    
    public static void viewAllPendingBills() {
		
    	BillService bService = new BillServiceImpl();
		List<Bill> list = new ArrayList<>();
		
		try {
			list = bService.viewAllPendingBillsData();
			list.forEach(b -> {
				
				String name = null;
				
				try {
					name = b.getConsumer().getFirstName()+" "+ b.getConsumer().getLastName();
				} catch ( Exception  e) {
					System.out.println();
					System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
				}
				
				System.out.println();
				System.out.println(ColorUI.BLUE_BOLD+"  ***Bill for "+ColorUI.RESET+ColorUI.YELLOW_BOLD+name+ColorUI.RESET+ColorUI.BLACK+" :- "+ColorUI.RESET);
//				System.out.println();
				
				System.out.println(ColorUI.BLACK_BOLD+"  ConsumerId : "+b.getConsumer().getConsumerId());
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
				System.out.println("  Bill Payment Status : "+(b.getIsPaid() == 0 ? "Payment Is Pending" : "Payment Is Paid"+ColorUI.RESET));
				
			});
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		} catch (Exception ex) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+ex.getMessage()+" <xx"+ColorUI.RESET);
		}
		System.out.println();
		
    }
    
	
    
    public static void deleteConsumerById(Scanner sc) {
    	System.out.print(ColorUI.BLUE_BOLD+"  Enter consumerId : "+ColorUI.RESET);
    	String consId=sc.next();
    	System.out.println();
    	
    	AdminDao aDao = new AdminDaoImpl();
    	
    	try {
			aDao.deleteConsumerDataById(consId);
			System.out.println();
			System.out.println(ColorUI.GREEN_BOLD+"  ***Consumer with consumerId '"+consId+"' is deleted successfully***"+ColorUI.RESET);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx>"+e.getMessage()+"  <xx"+ColorUI.RESET);
		} catch (Exception ex) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx>"+ex.getMessage()+"  <xx"+ColorUI.RESET);
		}
    	System.out.println();
    	
    }
    
    
    
    public static void generateConsumersBill(Scanner sc) {
    	
    	System.out.print(ColorUI.BLUE_BOLD+"  Enter ConsumerId : "+ColorUI.RESET);
    	int consId=sc.nextInt();
    	
    	System.out.print(ColorUI.BLUE_BOLD+"  Enter Previous Reading : "+ColorUI.RESET);
    	double prevRead=sc.nextDouble();
    	
    	System.out.print(ColorUI.BLUE_BOLD+"  Enter Current Reading : "+ColorUI.RESET);
    	double currRead=sc.nextDouble();
    	
    	System.out.print(ColorUI.BLUE_BOLD+"  Enter Unit Rate : "+ColorUI.RESET);
    	int unitRate=sc.nextInt();
    	
    	System.out.print(ColorUI.BLUE_BOLD+"  Enter Bill Tax : "+ColorUI.RESET);
    	double tax=sc.nextDouble();
    	
    	double unitConsumed=Math.abs(currRead-prevRead);
    	
    	double totalAmt=(unitConsumed*unitRate)+((unitConsumed*unitRate)*(tax/100));
    	
    	System.out.print(ColorUI.BLUE_BOLD+"  Enter StratDate of Reading : "+ColorUI.RESET);
    	LocalDate sDate=LocalDate.parse(sc.next());
    	
    	System.out.print(ColorUI.BLUE_BOLD+"  Enter EndDate of Reading : "+ColorUI.RESET);
    	LocalDate eDate=LocalDate.parse(sc.next());
    	
    	LocalDate billingDate=LocalDate.now();
    	
    	LocalDate dueDate=billingDate.plusDays(10);
    	
    	int isPaid=0;
    	
    	Bill bill = new Bill(prevRead, currRead, unitConsumed, unitRate, totalAmt, tax, sDate, eDate, billingDate, dueDate, isPaid);
    	
    	AdminDao aDao = new AdminDaoImpl();
    	
    	try {
			aDao.generateBillData(consId, bill);
			System.out.println();
        	System.out.println(ColorUI.GREEN_BOLD+"  ***Bill for ConsumerId "+consId+" is generated successfully***"+ColorUI.RESET);
        
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
		} catch (Exception ex) {
			System.out.println();
			System.out.println(ColorUI.RED_BOLD+"  xx> "+ex.getMessage()+" <xx"+ColorUI.RESET);
		}
    	System.out.println();
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
    
    
    
public static int showAllPendingComplaints() {
	
	ComplaintService cService = new ComplaintServiceImpl();
	
	try {
		
		List<Complaint> compList = cService.showAllPendingComplaint();
		
		if(compList.size() > 0) {
			
		
		
		System.out.println();
		System.out.println(ColorUI.BLUE_BOLD+"  ***All Pending Complaints are "+ColorUI.RESET+ColorUI.YELLOW_BOLD+ColorUI.RESET+" :- ");
		System.out.println();
		
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
			System.out.println(ColorUI.GREEN_BOLD+ "*** You have no pending complaints ***" + ColorUI.RESET);
			System.out.println();
		}

		
		return compList.size();
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
    
    
    public static void resolveComplaints(Scanner sc) {
    	
    	ComplaintDao cDao = new ComplaintDaoImpl();
    	
    	try {
    		if(showAllPendingComplaints() > 0) {
    		
    		System.out.print(ColorUI.YELLOW_BOLD+"  Enter Complaint Id from above which you have to resolve : "+ColorUI.RESET);
    		int compId=sc.nextInt();
    		System.out.println();
    		
    		cDao.resolveComplaint(compId);
    		
    		System.out.println();
    		System.out.println(ColorUI.GREEN_BOLD+"  ***Payment Successfull!***"+ColorUI.RESET);
    		System.out.println();
    		}
    	} catch (SomethingWentWrongException |NoRecordFoundException  e) {
    		System.out.println();
    		System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
    		System.out.println();
    	}catch (Exception e) {
    		System.out.println();
    		System.out.println(ColorUI.RED_BOLD+"  xx> "+e.getMessage()+" <xx"+ColorUI.RESET);
    		System.out.println();
    	}
    	
    
    }
}

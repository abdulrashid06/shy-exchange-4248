package com.billpay.UI;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

import com.billpay.DAO.ConsumerDao;
import com.billpay.DAO.ConsumerDaoImpl;
import com.billpay.DAO.EMFUtils;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.SomethingWentWrongException;
import com.billpay.Service.ConsumerService;
import com.billpay.Service.ConsumerServiceImpl;
import com.billpay.colors.ColorUI;

import jakarta.persistence.EntityManager;

public class MainUI {
	
    public static void main( String[] args ){
    	
    
    	System.out.println();
    	System.out.println("   "+ColorUI.WHITE + "-------------------------------------------------------------");
        System.out.println("  |"+ColorUI.WHITE_BACKGROUND_BRIGHT+"                                                             "+ColorUI.WHITE+"|"+ColorUI.RESET);
        System.out.println("  |"+ColorUI.WHITE_BACKGROUND_BRIGHT+"                     "+ColorUI.RED_BACKGROUND_BRIGHT+ColorUI.BLACK_BOLD + "Welcome to BillPay"+ColorUI.RESET+ColorUI.WHITE_BACKGROUND_BRIGHT+"                      "+ColorUI.WHITE+"|"+ColorUI.RESET);
        System.out.println("  |"+ColorUI.WHITE_BACKGROUND_BRIGHT+"           "+ColorUI.RED_BACKGROUND_BRIGHT+ColorUI.BLACK_BOLD + "Electricity Bill Management System"+ColorUI.RESET+ColorUI.WHITE_BACKGROUND_BRIGHT+"                "+ColorUI.WHITE+"|"+ColorUI.RESET);
        System.out.println("  |"+ColorUI.WHITE_BACKGROUND_BRIGHT+"                                                             "+ColorUI.WHITE+"|"+ColorUI.RESET); 
    	System.out.println("   "+ColorUI.WHITE + "-------------------------------------------------------------");
    
    
    	int choice=0;
    	Scanner sc = new Scanner(System.in);
    	
    	try {
    		
    		do {
				
    			System.out.println();
				System.out.println(ColorUI.YELLOW+"  Select 1 -> for Admin's Login.");
				System.out.println("  Select 2 -> for Consumer's Login.");
				System.out.println("  Select 3 -> for Consumer's Registration.");
				System.out.println("  Select 4 -> for Consumer's Forget Password.");
				System.out.println("  Select 0 -> for Exit from system."+ColorUI.RESET);
				System.out.println();
				
				choice = sc.nextInt();
				
				switch(choice) {
				
				case 1 : AdminUI.adminLogin(sc);
					break;
					
				case 2 : 
					break;
					
				case 3 : ConsumerUI.consumerRegistration(sc);
					break;
					
				case 4 : 
					break;
					
				case 0 : System.out.println("  "+ColorUI.BLACK_BOLD+ColorUI.TEAL_BACKGROUND+"***Thanks for visiting BillPay, keep visiting***"+ColorUI.RESET);
					break;
					
				default : System.out.println(" "+ColorUI.RED_BRIGHT+"*** Invalid selection, please try again with correct selection"+ColorUI.RESET);
				
				}
    			
			} while (choice != 0);
			
		} catch (InputMismatchException e) {
			System.out.println("\n");
			System.out.println(" "+ColorUI.RED_BRIGHT+"-+-+-+-+ Invalid input, please enter numerical input and try again +-+-+-+-"+ColorUI.RESET);
		}
    	
    }

//	private static void saveUserUi(Scanner sc) {
//		
//		System.out.println("Enter firstname");
//		 String firstName = sc.next();
//		 System.out.println("Enter lastname");
//		 String lastName = sc.next();
//		 System.out.println("Enter uername");
//		 String userName = sc.next();
//		 System.out.println("Enter email");
//		 String email = sc.next();
//		 System.out.println("Enter passord");
//		 String password = sc.next();
//		 System.out.println("Enter address");
//		 sc.nextLine();
//		 String address = sc.nextLine();
//		 System.out.println("Enter mobile no.");
//		 String mobileNum = sc.next();
//		
//         ConsumerSave consa = new ConsumerSave(firstName, lastName, userName, email, password, address, mobileNum);
//         
//         ConsumerService conService = new ConsumerServiceImpl();
//         
//         try {
//			conService.registerConsumerData(firstName, lastName, userName, email, password, address, mobileNum);
//			
//		} catch (SomethingWentWrongException e) {
//			System.out.println(e.getMessage());
//		}
//         
//		
//	}
    
}

package com.billpay.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.billpay.colors.ColorUI;

public class MainUI {
	
    public static void main( String[] args ){
    	
    	System.out.println();
    	System.out.println("   "+ColorUI.WHITE + "-------------------------------------------------------------");
        System.out.println("  |"+ColorUI.WHITE_BACKGROUND_BRIGHT+"                                                             "+ColorUI.WHITE+"|"+ColorUI.RESET);
        System.out.println("  |"+ColorUI.WHITE_BACKGROUND_BRIGHT+"                     "+ColorUI.RED_BACKGROUND+ColorUI.BLACK_BOLD + "Welcome to BillPay"+ColorUI.RESET+ColorUI.WHITE_BACKGROUND_BRIGHT+"                      "+ColorUI.WHITE+"|"+ColorUI.RESET);
        System.out.println("  |"+ColorUI.WHITE_BACKGROUND_BRIGHT+"           "+ColorUI.RED_BACKGROUND+ColorUI.BLACK_BOLD + "Electricity Bill Management System"+ColorUI.RESET+ColorUI.WHITE_BACKGROUND_BRIGHT+"                "+ColorUI.WHITE+"|"+ColorUI.RESET);
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
				
				case 1 : 
					break;
					
				case 2 : 
					break;
					
				case 3 : 
					break;
					
				case 4 : 
					break;
					
				case 0 : System.out.println("  "+ColorUI.BLACK_BOLD+ColorUI.TEAL_BACKGROUND+"***Thanks for visiting BillPay, keep visiting***"+ColorUI.RESET);

					break;
				
				}
    			
			} while (choice != 0);
			
		} catch (InputMismatchException e) {
			System.out.println("\n");
			System.out.println("-+-+-+-+ Invalid input, please enter numerical input and try again +-+-+-+-");
		}
    	
    }
    
}

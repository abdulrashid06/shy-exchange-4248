package com.billpay.Entity;

import java.time.LocalDate;



public class Transaction {
	
	private String TransactionId;
	
	private String consumerId;
	
	private String billId;
	
	private double amountPaid;
	private LocalDate paymentDate;
	private String paymentMethod;
	
	
	private Consumer consumer;

}

package com.billpay.Entity;

import java.time.LocalDate;

public class Bill {
	
	private String billId;
	
	private String consumerId;
	
	private double prevReading;
	private double currReading;
	private double unitConsumed;
	private int unitRate;
	private double totalAmount;
	private double tax;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate billing_date;
	private LocalDate dueDate;
	private int isPaid;
	
	private Consumer consumer;

}

//package com.billpay.Entity;
//
//import java.time.LocalDate;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//
//@Entity
//public class Transaction {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private String TransactionId;
//	
//	private double amountPaid;
//	private LocalDate paymentDate;
//	private String paymentMethod;
//	
//	@ManyToOne
//    @JoinColumn(name = "consumer_id")
//	private ConsumerSave consumer;
//
//	public Transaction() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Transaction(double amountPaid, LocalDate paymentDate, String paymentMethod, ConsumerSave consumer) {
//		super();
//		this.amountPaid = amountPaid;
//		this.paymentDate = paymentDate;
//		this.paymentMethod = paymentMethod;
//		this.consumer = consumer;
//	}
//
//	public String getTransactionId() {
//		return TransactionId;
//	}
//
//	public void setTransactionId(String transactionId) {
//		TransactionId = transactionId;
//	}
//
//	public double getAmountPaid() {
//		return amountPaid;
//	}
//
//	public void setAmountPaid(double amountPaid) {
//		this.amountPaid = amountPaid;
//	}
//
//	public LocalDate getPaymentDate() {
//		return paymentDate;
//	}
//
//	public void setPaymentDate(LocalDate paymentDate) {
//		this.paymentDate = paymentDate;
//	}
//
//	public String getPaymentMethod() {
//		return paymentMethod;
//	}
//
//	public void setPaymentMethod(String paymentMethod) {
//		this.paymentMethod = paymentMethod;
//	}
//
//	public ConsumerSave getConsumer() {
//		return consumer;
//	}
//
//	public void setConsumer(ConsumerSave consumer) {
//		this.consumer = consumer;
//	}
//
//	@Override
//	public String toString() {
//		return "Transaction [TransactionId=" + TransactionId + ", amountPaid=" + amountPaid + ", paymentDate="
//				+ paymentDate + ", paymentMethod=" + paymentMethod + ", consumer=" + consumer + "]";
//	}
//
//}

package com.billpay.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;


@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	
	@Column(name = "prevReading", nullable = false)
	private double prevReading;
	
	@Column(name = "currReading", nullable = false)
	private double currReading;
	
	@Column(name = "unitConsumed", nullable = false)
	private double unitConsumed;
	
	@Column(name = "unitRate", nullable = false)
	private int unitRate;
	
	@Column(name = "totalAmount", nullable = false)
	private double totalAmount;
	
	@Column(name = "tax", nullable = false)
	private double tax;
	
	@Column(name = "startDate", nullable = false)
	private LocalDate startDate;
	
	@Column(name = "endDate", nullable = false)
	private LocalDate endDate;
	
	@Column(name = "billing_date", nullable = false)
	private LocalDate billing_date;
	
	@Column(name = "dueDate", nullable = false)
	private LocalDate dueDate;
	
	@Column(name = "isPaid", nullable = false)
	private int isPaid;
	
	@ManyToOne
    @JoinColumn(name = "consumer_id")
	private ConsumerSave consumer;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Bill(double prevReading, double currReading, double unitConsumed, int unitRate, double totalAmount,
			double tax, LocalDate startDate, LocalDate endDate, LocalDate billing_date, LocalDate dueDate, int isPaid) {
		super();
		this.prevReading = prevReading;
		this.currReading = currReading;
		this.unitConsumed = unitConsumed;
		this.unitRate = unitRate;
		this.totalAmount = totalAmount;
		this.tax = tax;
		this.startDate = startDate;
		this.endDate = endDate;
		this.billing_date = billing_date;
		this.dueDate = dueDate;
		this.isPaid = isPaid;
	}

	public Bill(double prevReading, double currReading, double unitConsumed, int unitRate, double totalAmount,
			double tax, LocalDate startDate, LocalDate endDate, LocalDate billing_date, LocalDate dueDate, int isPaid,
			ConsumerSave consumer) {
		super();
		this.prevReading = prevReading;
		this.currReading = currReading;
		this.unitConsumed = unitConsumed;
		this.unitRate = unitRate;
		this.totalAmount = totalAmount;
		this.tax = tax;
		this.startDate = startDate;
		this.endDate = endDate;
		this.billing_date = billing_date;
		this.dueDate = dueDate;
		this.isPaid = isPaid;
		this.consumer = consumer;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public double getPrevReading() {
		return prevReading;
	}

	public void setPrevReading(double prevReading) {
		this.prevReading = prevReading;
	}

	public double getCurrReading() {
		return currReading;
	}

	public void setCurrReading(double currReading) {
		this.currReading = currReading;
	}

	public double getUnitConsumed() {
		return unitConsumed;
	}

	public void setUnitConsumed(double unitConsumed) {
		this.unitConsumed = unitConsumed;
	}

	public int getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(int unitRate) {
		this.unitRate = unitRate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getBilling_date() {
		return billing_date;
	}

	public void setBilling_date(LocalDate billing_date) {
		this.billing_date = billing_date;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public int getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(int isPaid) {
		this.isPaid = isPaid;
	}

	public ConsumerSave getConsumer() {
		return consumer;
	}

	public void setConsumer(ConsumerSave consumer) {
		this.consumer = consumer;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", prevReading=" + prevReading + ", currReading=" + currReading
				+ ", unitConsumed=" + unitConsumed + ", unitRate=" + unitRate + ", totalAmount=" + totalAmount
				+ ", tax=" + tax + ", startDate=" + startDate + ", endDate=" + endDate + ", billing_date="
				+ billing_date + ", dueDate=" + dueDate + ", isPaid=" + isPaid + ", consumer=" + consumer + "]";
	}

}

package com.billpay.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaintId;
	
//	private int consId;
	@Column(name = "complaint_Date", nullable = false)
	private LocalDateTime compDate;

	@Column(name = "complaint_Typa", nullable = false)
	private String compTypa;
	
	@Column(name = "complaint_Desc", nullable = false)
	private String compDesc;
	
	@Column(name = "assignedTo", nullable = false)
	private String assignedTo;
	
	@Column(name = "status", nullable = false)
	private int status;
	
//	@Column(name = "response_Date", nullable = false)
	private LocalDateTime resDate;
//	private LocalTime resTime;

	
	@ManyToOne
    @JoinColumn(name = "consumer_id")
	private ConsumerSave consumer;
	
	
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    public Complaint(LocalDateTime compDate, String compTypa, String compDesc, String assignedTo, int status,
		LocalDateTime resDate) {
	super();
	this.compDate = compDate;
	this.compTypa = compTypa;
	this.compDesc = compDesc;
	this.assignedTo = assignedTo;
	this.status = status;
	this.resDate = resDate;
   }


	public int getComplaintId() {
		return complaintId;
	}


	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}


	public LocalDateTime getCompDate() {
		return compDate;
	}


	public void setCompDate(LocalDateTime compDate) {
		this.compDate = compDate;
	}


	public String getCompTypa() {
		return compTypa;
	}


	public void setCompTypa(String compTypa) {
		this.compTypa = compTypa;
	}


	public String getCompDesc() {
		return compDesc;
	}


	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}


	public String getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public LocalDateTime getResDate() {
		return resDate;
	}


	public void setResDate(LocalDateTime resDate) {
		this.resDate = resDate;
	}


	public ConsumerSave getConsumer() {
		return consumer;
	}


	public void setConsumer(ConsumerSave consumer) {
		this.consumer = consumer;
	}


	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", compDate=" + compDate + ", compTypa=" + compTypa
				+ ", compDesc=" + compDesc + ", assignedTo=" + assignedTo + ", status=" + status + ", resDate="
				+ resDate + ", consumer=" + consumer + "]";
	}
	
	
	

}

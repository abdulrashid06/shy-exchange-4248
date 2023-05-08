package com.billpay.Entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ConsumerSave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int consumerId;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "userName", unique = true, nullable = false)
	private String userName;
	
    @Column(name = "email", unique = true, nullable = false)
	private String email;
    
    @Column(name = "password", nullable = false)
	private String password;
    
    @Column(name = "address", nullable = false)
	private String address;
    
    @Column(name = "mobileNum", nullable = false)
	private String mobileNum;
    
    @Column(name = "isActive", nullable = false)
	private int isActive;
	
	@OneToMany(mappedBy = "consumer")
	private List<Bill> billList;
	
	@OneToMany(mappedBy = "consumer")
	private List<Transaction> transactionList;

	@OneToMany(mappedBy = "consumer")
	private List<Complaint> complaintList;
	
	
	
	public ConsumerSave() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ConsumerSave(String firstName, String lastName, String userName, String email, String password, String address,
			String mobileNum, int isActive, List<Bill> billList, List<Transaction> transactionList, List<Complaint> complaintList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileNum = mobileNum;
		this.isActive = isActive;
		this.billList = billList;
		this.transactionList = transactionList;
		this.complaintList = complaintList;
	}

	public ConsumerSave(String firstName, String lastName, String userName, String email, String password,
			String address, String mobileNum) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.mobileNum = mobileNum;
	}



	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public List<Bill> getBillList() {
		return billList;
	}

	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	
	public List<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(List<Complaint> complaintList) {
		this.complaintList = complaintList;
	}



	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", mobileNum=" + mobileNum + ", isActive=" + isActive  + "]";
	}

}

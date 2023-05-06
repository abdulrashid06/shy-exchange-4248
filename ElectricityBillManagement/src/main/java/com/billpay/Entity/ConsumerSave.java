package com.billpay.Entity;

import java.util.List;
import java.util.Set;

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
	
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private String address;
	private String mobileNum;
	private int isActive;
	
//	@OneToMany(mappedBy = "consumer")
//	private Set<Bill> billList;
//	
//	@OneToMany(mappedBy = "consumer")
//	private List<Transaction> transactionList;

	
	
	public ConsumerSave() {
		super();
		// TODO Auto-generated constructor stub
	}



//	public ConsumerSave(String firstName, String lastName, String userName, String email, String password, String address,
//			String mobileNum, int isActive, Set<Bill> billList, List<Transaction> transactionList) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.userName = userName;
//		this.email = email;
//		this.password = password;
//		this.address = address;
//		this.mobileNum = mobileNum;
//		this.isActive = isActive;
//		this.billList = billList;
//		this.transactionList = transactionList;
//	}

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

//	public Set<Bill> getBillList() {
//		return billList;
//	}
//
//	public void setBillList(Set<Bill> billList) {
//		this.billList = billList;
//	}
//
//	public List<Transaction> getTransactionList() {
//		return transactionList;
//	}
//
//	public void setTransactionList(List<Transaction> transactionList) {
//		this.transactionList = transactionList;
//	}

	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", mobileNum=" + mobileNum + ", isActive=" + isActive  + "]";
	}

}

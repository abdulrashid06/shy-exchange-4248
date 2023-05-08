package com.billpay.Service;

import java.util.List;

import com.billpay.Entity.Bill;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

public interface ConsumerService {
	
    public ConsumerSave consumerLoginData(String uName, String pass) throws SomethingWentWrongException, InvalidUsernameOrPasswordException;
	
	public int getLastDataId() throws SomethingWentWrongException,NoRecordFoundException;
	
	public void registerConsumerData(String firstName, String lastName, String userName, String email, String password,
			String address, String mobileNum)throws SomethingWentWrongException;
	
	public List<ConsumerSave> viewAllConsumerData() throws SomethingWentWrongException, NoRecordFoundException; 
	
	public List<Bill> showAllPendingBillsData(int consId)throws SomethingWentWrongException,NoRecordFoundException; 
	
	public void payConsumerBill(int BillId) throws SomethingWentWrongException;
	
//	public boolean verifySecurityCredentials(String opass, String consId)throws SomethingWentWrongException, InvalidUsernameOrPasswordException;
	
	public void updatePassword(String opass, String pass, String consId)throws SomethingWentWrongException, InvalidUsernameOrPasswordException;

}

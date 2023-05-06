package com.billpay.DAO;

import java.util.List;

import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;


public interface ConsumerDao {
	
    public ConsumerSave consumerLoginData(String uName, String pass) throws SomethingWentWrongException, InvalidUsernameOrPasswordException;
	
	public int getLastDataId() throws SomethingWentWrongException,NoRecordFoundException;
	
	public void registerConsumerData(ConsumerSave consumer)throws SomethingWentWrongException;
	
//	public List<Bill> showAllPendingBillsData(String consId)throws SomethingWentWrongException,NoRecordFoundException; 
	
	public void payConsumerBill(String BillId) throws SomethingWentWrongException;
	
	//public boolean verifySecurityCredentials(String ques, String ans, String consId)throws SomethingWentWrongException;
	
	public void updatePassword(String pass, String consId)throws SomethingWentWrongException;

}

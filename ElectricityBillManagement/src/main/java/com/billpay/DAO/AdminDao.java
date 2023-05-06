package com.billpay.DAO;

import java.util.List;

import com.billpay.Entity.Admin;
import com.billpay.Entity.Bill;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;


public interface AdminDao {
	
	public boolean adminLoginDetails(String username, String password) throws SomethingWentWrongException, InvalidUsernameOrPasswordException;
	
	public String getNameById(String consumerId)  throws SomethingWentWrongException,NoRecordFoundException;

	public void deleteConsumerDataById(String consId)throws SomethingWentWrongException,NoRecordFoundException;
	
	public int getLastBillId() throws SomethingWentWrongException, NoRecordFoundException;
	
	public void generateBillData(int conId, Bill bill) throws SomethingWentWrongException, NoRecordFoundException;

}

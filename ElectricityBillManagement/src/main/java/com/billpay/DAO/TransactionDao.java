package com.billpay.DAO;

import java.util.List;

import com.billpay.Entity.Bill;
import com.billpay.Entity.Transaction;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;



public interface TransactionDao {
	
	public int getLastTransactionId()throws SomethingWentWrongException,NoRecordFoundException;
	
	public Bill getBillByBillId(int billId) throws SomethingWentWrongException,NoRecordFoundException;
	
	public void addTransactionData(Transaction trans, int conId)throws SomethingWentWrongException, NoRecordFoundException;
	
	public List<Transaction> viewTransactionHistoryData(int consId)throws SomethingWentWrongException,NoRecordFoundException;
	
	

}

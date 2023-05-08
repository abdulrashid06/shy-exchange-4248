package com.billpay.Service;

import java.util.List;

import com.billpay.Entity.Bill;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

public interface BillService {
	
    public List<Bill> viewConsumerBillDataById(String conId) throws SomethingWentWrongException,NoRecordFoundException;
	
	public List<Bill> viewAllBillsData() throws SomethingWentWrongException,NoRecordFoundException;
	
	public List<Bill> viewAllPaidBillsData() throws SomethingWentWrongException,NoRecordFoundException;

	public List<Bill> viewAllPendingBillsData()throws SomethingWentWrongException,NoRecordFoundException;

}

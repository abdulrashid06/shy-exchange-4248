package com.billpay.Service;

import java.util.List;

import com.billpay.DAO.AdminDao;
import com.billpay.DAO.AdminDaoImpl;
import com.billpay.DAO.BillDao;
import com.billpay.DAO.BillDaoImpl;
import com.billpay.Entity.Bill;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

public class BillServiceImpl implements BillService {

	@Override
	public List<Bill> viewConsumerBillDataById(String conId)
			throws SomethingWentWrongException, NoRecordFoundException {
		
		BillDao bDao = new BillDaoImpl();
		List<Bill> list = null;
		
		try {
			
			list = bDao.viewConsumerBillDataById(conId);
			
			if(list == null) {
				throw new NoRecordFoundException("No record found in data base");
			}
			
		} catch (Exception e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		
		return list;
	}

	
	
	@Override
	public List<Bill> viewAllBillsData() throws SomethingWentWrongException, NoRecordFoundException {
		
		BillDao bDao = new BillDaoImpl();
		List<Bill> list = null;
		
		try {
			
			list = bDao.viewAllBillsData();
			
			if(list == null) {
				throw new NoRecordFoundException("No record found in data base");
			}
			
		} catch (Exception e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		
		return list;
	}

	
	
	@Override
	public List<Bill> viewAllPaidBillsData() throws SomethingWentWrongException, NoRecordFoundException {
		
		BillDao bDao = new BillDaoImpl();
		List<Bill> list = null;
		
		try {
			
			list = bDao.viewAllPaidBillsData();
			
			if(list == null) {
				throw new NoRecordFoundException("No record found in data base");
			}
			
		} catch (Exception e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		
		return list;
	}

	
	
	@Override
	public List<Bill> viewAllPendingBillsData() throws SomethingWentWrongException, NoRecordFoundException {
		
		BillDao bDao = new BillDaoImpl();
		List<Bill> list = null;
		
		try {
			
			list = bDao.viewAllPendingBillsData();
			
			if(list == null) {
				throw new NoRecordFoundException("No record found in data base");
			}
			
		} catch (Exception e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		
		return list;
	}

}

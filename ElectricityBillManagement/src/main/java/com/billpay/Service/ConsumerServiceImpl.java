package com.billpay.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.billpay.DAO.ConsumerDao;
import com.billpay.DAO.ConsumerDaoImpl;
import com.billpay.Entity.Bill;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

public class ConsumerServiceImpl implements ConsumerService {

	@Override
	public ConsumerSave consumerLoginData(String uName, String pass)
			throws SomethingWentWrongException, InvalidUsernameOrPasswordException {
		
		ConsumerDao cDao = new ConsumerDaoImpl();
		ConsumerSave consumer = null;
		
		try {
			consumer = cDao.consumerLoginData(uName, pass);
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		
		return consumer;
	}

	
	
	
	@Override
	public int getLastDataId() throws SomethingWentWrongException, NoRecordFoundException {
		
		ConsumerDao cDao = new ConsumerDaoImpl();
		int conId = 0;
		
		try {
			conId = cDao.getLastDataId();
		} catch (Exception e) {
			throw new NoRecordFoundException("No record found");
		}
		
		
		return conId;
	}

	
	
	
	@Override
	public void registerConsumerData(String firstName, String lastName, String userName, String email, String password,
			String address, String mobileNum) throws SomethingWentWrongException {
		
		ConsumerSave conS = new ConsumerSave(firstName, lastName, userName, email, password, address, mobileNum);
		
		ConsumerDao conDao = new ConsumerDaoImpl();
		conDao.registerConsumerData(conS);
		
	}

	
	
	
	@Override
	public void payConsumerBill(int BillId) throws SomethingWentWrongException {
		
		ConsumerDao cDao = new ConsumerDaoImpl();
		try {
			cDao.payConsumerBill(BillId);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			
		} 
		
	}

	@Override
	public void updatePassword(String Opass, String Npass , String consId) throws SomethingWentWrongException, InvalidUsernameOrPasswordException {
		
//		ConsumerDao cDao = new ConsumerDaoImpl();
//		String oldPass = null;
//		
//		try {
//			
//			if(cDao.verifySecurityCredentials(Opass, consId)) {
//				
//				try {
//					cDao.updatePassword(Npass, consId);
//				} catch (SomethingWentWrongException | NoRecordFoundException e) {
//					System.out.println(e.getMessage());
//				} 
//			}
//			
//		} catch (IllegalArgumentException e) {
//			throw new SomethingWentWrongException("Unable to");
//		}
		
	}

	

	@Override
	public List<ConsumerSave> viewAllConsumerData() throws SomethingWentWrongException, NoRecordFoundException {
		
		ConsumerDao cDao = new ConsumerDaoImpl();
		List<ConsumerSave> list = null;
		
		list = cDao.viewAllConsumerData();
		
		if(list == null) {
			throw new NoRecordFoundException("No record found in database, please try again");
		}
		
		return list;
	}




	@Override
	public List<Bill> showAllPendingBillsData(int consId)
			throws SomethingWentWrongException, NoRecordFoundException {
		
		ConsumerDao cDao = new ConsumerDaoImpl();
		List<Bill> billList = new ArrayList<>();
		
		List<Bill> bill;
		
		try {
			billList = cDao.showAllPendingBillsData(consId);
			if(billList == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		     bill = (List<Bill>) billList.stream().filter(b -> b.getIsPaid()==0).collect(Collectors.toList());
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
//		System.out.println(billList);
		
		return bill;
	}




//	@Override
//	public boolean verifySecurityCredentials(String opass, String consId)
//			throws SomethingWentWrongException, InvalidUsernameOrPasswordException {
//		// TODO Auto-generated method stub
//		return false;
//	}




//	@Override
//	public void updatePassword(String pass, String consId) throws SomethingWentWrongException {
//		// TODO Auto-generated method stub
//		
//	}
//	
	

}

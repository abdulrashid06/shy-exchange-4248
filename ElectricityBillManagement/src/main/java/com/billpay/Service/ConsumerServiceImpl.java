package com.billpay.Service;

import com.billpay.DAO.ConsumerDao;
import com.billpay.DAO.ConsumerDaoImpl;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

public class ConsumerServiceImpl implements ConsumerService {

	@Override
	public void consumerLoginData(String uName, String pass)
			throws SomethingWentWrongException, InvalidUsernameOrPasswordException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLastDataId() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerConsumerData(String firstName, String lastName, String userName, String email, String password,
			String address, String mobileNum) throws SomethingWentWrongException {
		
		ConsumerSave conS = new ConsumerSave(firstName, lastName, userName, email, password, address, mobileNum);
		
		ConsumerDao conDao = new ConsumerDaoImpl();
		conDao.registerConsumerData(conS);
		
	}

	@Override
	public void payConsumerBill(String BillId) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(String pass, String consId) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
	}
	
	

}

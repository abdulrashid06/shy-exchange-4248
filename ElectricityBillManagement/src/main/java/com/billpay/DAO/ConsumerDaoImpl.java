package com.billpay.DAO;

import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ConsumerDaoImpl implements ConsumerDao{

	@Override
	public ConsumerSave consumerLoginData(String uName, String pass)
			throws SomethingWentWrongException, InvalidUsernameOrPasswordException {
		
		
		
		return null;
	}

	@Override
	public int getLastDataId() throws SomethingWentWrongException, NoRecordFoundException {
		
		
		
		return 0;
	}

	@Override
	public void registerConsumerData(ConsumerSave consumer) throws SomethingWentWrongException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			
			et.begin();
			em.persist(consumer);
			
		} catch (Exception e) {
			throw new SomethingWentWrongException("Unable to add consumer");
		}finally {
			et.commit();
			em.close();
			
		}
		
	}

	@Override
	public void payConsumerBill(String BillId) throws SomethingWentWrongException {
		
		
		
	}

	@Override
	public void updatePassword(String pass, String consId) throws SomethingWentWrongException {
		
		
		
	}

	

}

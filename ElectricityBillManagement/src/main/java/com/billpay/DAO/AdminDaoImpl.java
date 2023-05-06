package com.billpay.DAO;

import java.util.List;

import com.billpay.Entity.Admin;
import com.billpay.Entity.Bill;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;
import com.billpay.colors.ColorUI;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class AdminDaoImpl implements AdminDao {

//	String str = "Login sucessfull";
	@Override
	public boolean adminLoginDetails(String username, String password) throws SomethingWentWrongException, InvalidUsernameOrPasswordException {
		
		try {
			
			if(username.equals("Admin") && password.equals("Admin")) {
				return true;
			}
			else {
				throw new InvalidUsernameOrPasswordException("Invalid credentials");
			}
			
		} catch (Exception e) {
			throw new InvalidUsernameOrPasswordException("Wrong credentials");
		}
	}

	@Override
	public List<ConsumerSave> viewAllConsumerData() throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		List<ConsumerSave> consumer = null;
		
		try {
			
			Query query = em.createQuery("SELECT c FROM ConsumerSave c WHERE c.isActive= :activeId");
			query.setParameter("activeId", 0);
			consumer = query.getResultList();
			
			if(consumer == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (Exception e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		finally {
			em.close();
		}
		
		return consumer;
	}

	
	
	@Override
	public List<Bill> viewConsumerBillDataById(String conId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		List<Bill> bill = null;
		
		try {
			
			Query query = em.createQuery("SELECT b FROM Bill b WHERE b.consumerId= :conId");
			query.setParameter("conId", conId);
			bill = query.getResultList();
			
			if(bill == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}finally {
			em.close();
		}
		
		return bill;
	}

	
	
	@Override
	public List<Bill> viewAllBillsData() throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		List<Bill> bill = null;
		
		try {
			
			Query query = em.createQuery("SELECT b FROM Bill b");
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		return null;
	}

	
	
	@Override
	public String getNameById(String ConsumerId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<Bill> viewAllPaidBillsData() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<Bill> viewAllPendingBillsData() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public void deleteConsumerDataById(String consId) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public int getLastBillId() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	@Override
	public void generateBillData(Bill bill) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
	}
	

}
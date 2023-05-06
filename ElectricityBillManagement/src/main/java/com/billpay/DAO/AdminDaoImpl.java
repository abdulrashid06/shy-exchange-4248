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
import jakarta.persistence.PersistenceException;
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
	public String getNameById(String consumerId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		ConsumerSave consumer = null;
		
		try {
			
			consumer = em.find(ConsumerSave.class, consumerId);
			
			if(consumer == null) {
				throw new NoRecordFoundException("No record found with "+consumerId+" in database");
			}
			
			Query query = em.createQuery("SELECT c.firstName, c.lastName FROM ConsumerSave c WHERE c.consumerId= :consumerId");
			query.setParameter("consumerId", consumerId);
			
			et.begin();
			em.persist(query);
			
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Unable to delete consumer, please try again");
		} finally {
			et.commit();
			em.close();
		}
		
		return null;
	}

	
	
	

	@Override
	public void deleteConsumerDataById(String consId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		ConsumerSave consumer = null;
		
		try {
			
			consumer = em.find(ConsumerSave.class, consId);
			
			if(consumer == null) {
				throw new NoRecordFoundException("No record found with "+consId+" in database");
			}
			
			consumer.setIsActive(1);
			
			et.begin();
			em.merge(consumer);
			et.commit();
			
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Unable to delete consumer, please try again");
		} finally {	
			em.close();
		}
		
	}

	
	
	@Override
	public int getLastBillId() throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		int billId = 0;
		
		try {
			
			Query query = em.createQuery("SELECT b.billId FROM Bill b ORDER BY b.billId DESC LIMIT 1");
			billId = (int) query.getSingleResult();
			
			if(billId == 0) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Unable to data, please try again");
		} finally {
			em.close();
		}
		
		return billId;
	}

	
	
	@Override
	public void generateBillData(int conId, Bill bill) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		ConsumerSave consumer = null;
		
		try {
			consumer = em.find(ConsumerSave.class, conId);
			
			if(consumer == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
			List<Bill> billList = consumer.getBillList();
			billList.add(bill);
			consumer.setBillList(billList);
			bill.setConsumer(consumer);
			
			et.begin();
			em.persist(bill);
			em.persist(consumer);
			et.commit();
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}finally {
			em.close();
		}
		
		
		
	}
	

}
package com.billpay.DAO;

import java.util.List;

import com.billpay.Entity.Bill;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Exception.InvalidUsernameOrPasswordException;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class ConsumerDaoImpl implements ConsumerDao{

	@Override
	public ConsumerSave consumerLoginData(String uName, String pass)
			throws SomethingWentWrongException, InvalidUsernameOrPasswordException {
		
		
		
		return null;
	}

	
	
	@Override
	public int getLastDataId() throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		int conId = 0;
		
		try {
			
			Query query = em.createQuery("SELECT c.consumerId FROM ConsumerSave c ORDER BY c.consumerId DESC LIMIT 1");
			conId = (int) query.getSingleResult();
			
			if(conId == 0) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Unable to data, please try again");
		} finally {
			em.close();
		}
		
		return conId;
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
	public void payConsumerBill(String BillId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		Bill bill = null;
		
		try {
			bill = em.find(Bill.class, BillId);
			if(bill == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
			bill.setIsPaid(1);
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}finally {
			em.close();
		}
		
	}

	
	
	
	@Override
	public void updatePassword(String pass, String consId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		ConsumerSave consumer = null;
		
		try {
			consumer = em.find(ConsumerSave.class, consId);
			if(consumer == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
			consumer.setPassword(pass);
			
			et.begin();
			em.persist(consumer);
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}finally {
			et.commit();
			em.close();
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
	public boolean verifySecurityCredentials(String opass, String consId) throws SomethingWentWrongException, InvalidUsernameOrPasswordException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		ConsumerSave consumer = null;
		try {
			
			consumer = em.find(ConsumerSave.class, consId);
			
			if(consumer == null ) {
				throw new NoRecordFoundException("No record found in database");
			}
			if(consumer.getPassword().equals(opass)) {
				return true;
			}
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		return false;
	}
}

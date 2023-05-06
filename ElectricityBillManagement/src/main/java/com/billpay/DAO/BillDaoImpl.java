package com.billpay.DAO;

import java.util.List;

import com.billpay.Entity.Bill;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class BillDaoImpl implements BillDao {

	@Override
	public List<Bill> viewConsumerBillDataById(String conId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		List<Bill> bill = null;
		
		try {
			
			Query query = em.createQuery("SELECT c.billList FROM ConsumerSave c WHERE c.consumerId= :conId");
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
			bill = query.getResultList();
			
			if(bill == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		return bill;
	}

	
	
	
	@Override
	public List<Bill> viewAllPaidBillsData() throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		List<Bill> bill = null;
		
		try {
			
			Query query = em.createQuery("SELECT b FROM Bill b WHERE b.isPaid=1");
			bill = query.getResultList();
			
			if(bill == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		} finally {
			em.close();
		}
		
		return bill;
	}

	
	
	
	@Override
	public List<Bill> viewAllPendingBillsData() throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		List<Bill> bill = null;
		
		try {
			
			Query query = em.createQuery("SELECT b FROM Bill b WHERE b.isPaid=0");
			bill = query.getResultList();
			
			if(bill == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		} finally {
			em.close();
		}
		
		return bill;
	}

}

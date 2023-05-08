package com.billpay.DAO;

import java.util.ArrayList;
import java.util.List;

import com.billpay.Entity.Bill;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Entity.Transaction;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public int getLastTransactionId() throws SomethingWentWrongException, NoRecordFoundException {
		
		
		
		return 0;
	}

	@Override
	public Bill getBillByBillId(int billId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		Bill bill = null;
		
		try {
			bill = em.find(Bill.class, billId);
			
			if(bill == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		return bill;
	}

	@Override
	public void addTransactionData(Transaction trans, int conId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		ConsumerSave consumer = null;
		
		try {
			consumer = em.find(ConsumerSave.class, conId);
			
			if(consumer == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
			List<Transaction> tranList = consumer.getTransactionList();
			tranList.add(trans);
			consumer.setTransactionList(tranList);
			trans.setConsumer(consumer);
			
			et.begin();
			em.persist(trans);
			em.persist(consumer);
			et.commit();
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
	}

	@Override
	public List<Transaction> viewTransactionHistoryData(int consId)
			throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		List<Transaction> transList = new ArrayList<>();
		
		try {
			
			Query query = em.createQuery("SELECT c.transactionList FROM ConsumerSave c WHERE c.consumerId= :consId");
			query.setParameter("consId", consId);
			transList = query.getResultList();
			
			if(transList == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, plese try again");
		}
		
		return transList;
	}

}

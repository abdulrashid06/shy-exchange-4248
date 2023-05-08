package com.billpay.DAO;

import java.util.List;

import com.billpay.Entity.Bill;
import com.billpay.Entity.Complaint;
import com.billpay.Entity.ConsumerSave;
import com.billpay.Entity.Transaction;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class ComplaintDaoImpl implements ComplaintDao {

	@Override
	public int getLastComplaintId() throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		int compId = 0;
		
		try {
			Query query = em.createQuery("SELECT c.complaintId FROM Complaint c ORDER BY c.complaintId DESC LIMIT 1");
			compId = (int) query.getSingleResult();
			
			if(compId == 0) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}finally {
			em.close();
		}
		
		return compId;
	}

	
	
	@Override
	public void fileComplaintData(Complaint comp, int conId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		ConsumerSave consumer = null;
		
		try {
			
            consumer = em.find(ConsumerSave.class, conId);
			
			if(consumer == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
			List<Complaint> compList = consumer.getComplaintList();
			compList.add(comp);
			consumer.setComplaintList(compList);
			comp.setConsumer(consumer);
			
			et.begin();
			em.persist(comp);
			em.persist(consumer);
			et.commit();
			
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}finally {
			em.close();
		}
		
	}

	
	
	
	@Override
	public List<Complaint> viewAllComplaints() throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		List<Complaint> compList = null;
		
		try {
			Query query = em.createQuery("SELECT c FROM Complaint c");
			compList = query.getResultList();
			
			if(compList == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		return compList;
	}

	
	
	@Override
	public void resolveComplaint(int compId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		EntityTransaction et = em.getTransaction();
		Complaint comp = null;
		
		try {
			
			comp = em.find(Complaint.class, compId);
			
			if(comp == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
			comp.setStatus(1);
			
			et.begin();
			em.merge(comp);
			et.commit();
			
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}finally {
			em.close();
		}
		
	}



	@Override
	public List<Complaint> getComplaintStatus(int consId) throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		List<Complaint> list = null;
		
		try {
			
			Query query = em.createQuery("SELECT c.complaintList FROM ConsumerSave c WHERE c.consumerId= :consId");
			query.setParameter("consId", consId);
			list = query.getResultList();
			
			if(list == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}finally {
			em.close();
		}
		
		return list;
	}



	@Override
	public List<Complaint> showAllPendingComplaints()
			throws SomethingWentWrongException, NoRecordFoundException {
		
		EntityManager em = EMFUtils.getAnEntityManager();
		List<Complaint> compList = null;
		
		try {
			Query query = em.createQuery("SELECT c FROM Complaint c");
			compList = query.getResultList();
			
			if(compList == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (PersistenceException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		return compList;
	}
	

}

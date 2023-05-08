package com.billpay.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.billpay.DAO.ComplaintDao;
import com.billpay.DAO.ComplaintDaoImpl;
import com.billpay.Entity.Complaint;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;

public class ComplaintServiceImpl implements ComplaintService {

	@Override
	public int getLastComplaintId() throws SomethingWentWrongException, NoRecordFoundException {
		
		ComplaintDao cDao = new ComplaintDaoImpl();
		int compId = cDao.getLastComplaintId();
		
		return compId;
	}

	@Override
	public void fileComplaintData(Complaint comp, int conId)
			throws SomethingWentWrongException, NoRecordFoundException {
		
		ComplaintDao cDao = new ComplaintDaoImpl();
		cDao.fileComplaintData(comp, conId);
		
	}

	@Override
	public List<Complaint> viewAllComplaints() throws SomethingWentWrongException, NoRecordFoundException {
		
		ComplaintDao cDao = new ComplaintDaoImpl();
		List<Complaint> comp = null;
		
		try {
			
			comp = cDao.viewAllComplaints();
			if(comp == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		return null;
	}

	@Override
	public void resolveComplaint(int compId) throws SomethingWentWrongException, NoRecordFoundException {
		
		ComplaintDao cDao = new ComplaintDaoImpl();
		
		cDao.resolveComplaint(compId);
		
	}

	@Override
	public List<Complaint> showAllPendingComplaint() throws SomethingWentWrongException, NoRecordFoundException {
		
		ComplaintDao cDao = new ComplaintDaoImpl();
		List<Complaint> compList = new ArrayList<>();
		
		List<Complaint> list;
		
		try {
			compList = cDao.showAllPendingComplaints();
			if(compList == null) {
				throw new NoRecordFoundException("No record found in database");
			}
			
			list = compList.stream().filter(c -> c.getStatus()==0).collect(Collectors.toList());
			
		} catch (IllegalArgumentException e) {
			throw new SomethingWentWrongException("Unable to fetch data, please try again");
		}
		
		return list;
	}

}

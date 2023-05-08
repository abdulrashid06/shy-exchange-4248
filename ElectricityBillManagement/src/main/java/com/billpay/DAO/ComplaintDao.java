package com.billpay.DAO;

import java.util.List;

import com.billpay.Entity.Complaint;
import com.billpay.Exception.NoRecordFoundException;
import com.billpay.Exception.SomethingWentWrongException;


public interface ComplaintDao {
	
	public int getLastComplaintId() throws SomethingWentWrongException,NoRecordFoundException;
	
	public void fileComplaintData(Complaint comp, int conId) throws SomethingWentWrongException, NoRecordFoundException;
	
	public List<Complaint> viewAllComplaints() throws SomethingWentWrongException,NoRecordFoundException;
	
	public void resolveComplaint(int compId) throws SomethingWentWrongException, NoRecordFoundException;
	
	public List<Complaint> getComplaintStatus(int consId) throws SomethingWentWrongException, NoRecordFoundException;
	
	public List<Complaint> showAllPendingComplaints() throws SomethingWentWrongException,NoRecordFoundException;

}

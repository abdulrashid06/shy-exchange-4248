package com.billpay.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFUtils {
	
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("electricityConnect");
		
	}
	
		
	public	static EntityManager getAnEntityManager() {
		return emf.createEntityManager();
	}

}

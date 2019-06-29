package com.lti.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Customer;

public class CustomerDao {

	//to insert
	public void databaseIlAddSeiyavum(Customer customer) {
		//Step 1.  Load/Create EntityManagerFactory object
		//During this step, META-INF/persistence.xml is read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-pu");
		
		//Step 2. Load/Create EntityManager object
		EntityManager em = emf.createEntityManager();
		
		//Step 3 Start /Participate in a transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Now we can insert/update/delete/select whatever we want
		//the object (customer) should be an object of an entity class always.
		em.persist(customer); //persist method generates insert query
		
		tx.commit();
		
		//below code should be in finally block
		em.close();
		emf.close();
	}
	
	//to fetch
	public Customer databaseIlVangudhal(int custId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em = emf.createEntityManager();
		
		//find method generates select query
		Customer c = em.find(Customer.class,	custId);
		
		em.close();
		emf.close();
		
		return c;
	}
	
	
	//to update
	public void databaseIlMempaduthu(Customer customer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.merge(customer);
		
		tx.commit();
		em.close();
		emf.close();
	}
}

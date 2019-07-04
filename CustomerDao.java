package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CustomerDao {
	public void databaseAddCustomer(Customer customer) {
		//step1 load/create entitymanagerfactory object
		//during this step META-INF /persistence.xml is read
		EntityManagerFactory emf=null;		
        //step 2.load/create EntityManager Object
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			//step 3.start/participate in transaction
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			//now we can update/select/insert/delete whatever we want
			em.persist(customer);
			tx.commit();
		} finally {
			//below code should be in finally block
			em.close();
			emf.close();
		}
	}

	public List<Customer> databaseFetchEmail(String email) {
		EntityManagerFactory emf= null;
				
		EntityManager em= null;
		List<Customer> list;
				try {
					emf = Persistence.createEntityManagerFactory("oracleTest");
					em = emf.createEntityManager();
					Query q = em.createQuery("select c from Customer as c where c.email like :em");
					q.setParameter("em", "%" + email + "%");
					list = q.getResultList();
					return list;
				} finally {
					em.close();
					emf.close();
					}
	}
	
	public List<Customer> databaseFetchAll() {
		EntityManagerFactory emf= null;
				
		EntityManager em= null;
		List<Customer> list;
				try {
					emf = Persistence.createEntityManagerFactory("oracleTest");
					em = emf.createEntityManager();
					Query q = em.createQuery("select c from Customer as c");
					list = q.getResultList();
					return list;
				} finally {
					em.close();
					emf.close();
					}
	}

	
	public void databaseUpdate(Customer customer) {
		EntityManagerFactory emf= null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.merge(customer);
			tx.commit();
		} finally {
			em.close();
			emf.close();
		}
	}

	public Customer databaseFetchId(int custID) {
		EntityManagerFactory emf= null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			Customer c=em.find(Customer.class,custID);
			tx.commit();
			return c;
		} finally {
			em.close();
			emf.close();
		}
	}

	public void databaseAddMerge(Customer c) {
		EntityManagerFactory emf= null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.merge(c);
			tx.commit();
		} finally {
			em.close();
			emf.close();
		}
	}

	
}



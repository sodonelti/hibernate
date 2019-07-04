package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDao { //BaseDao, CommonDao, SabKaDao
	
	public void databaseSave(Object obj) {
		EntityManagerFactory emf= null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.merge(obj); //merge method is use to insert as well as update
			tx.commit();
			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
				finally {
			em.close();
			emf.close();
		}
	}
	
	public Object databaseFetchId( Class classname,Object id) {
		EntityManagerFactory emf= null;
		EntityManager em=null;
		try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
			em = emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			Object obj=em.find(classname,id);
			return obj;
		} finally {
			em.close();
			emf.close();
		}
	}

	public <E> List<E> databaseFetchAll(Class<E> classname) {
		EntityManagerFactory emf= null;
				
		EntityManager em= null;
		List<E> list;
				try {
					emf = Persistence.createEntityManagerFactory("oracleTest");
					em = emf.createEntityManager();
					Query q = em.createQuery("select obj from "+classname.getName()+" as obj");
					list = q.getResultList();
					return list;
				} finally {
					em.close();
					emf.close();
					}
	}
	

}

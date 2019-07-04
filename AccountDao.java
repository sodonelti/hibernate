package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AccountDao extends GenericDao {

	public List<Transaction> fetchMiniStatement(long acno){
		EntityManagerFactory emf= null;
		
		EntityManager em= null;
				try {
					emf = Persistence.createEntityManagerFactory("oracleTest");
					em = emf.createEntityManager();
					String ql= "select t from Transaction t where t.account.acno = :ac order by t.date desc";
					Query q = em.createQuery(ql);
					q.setParameter("ac", acno);
					q.setMaxResults(5); 
					List<Transaction> list = q.getResultList();
					return list;
				} finally {
					em.close();
					emf.close();
					}
	}
	
	public List<Account> fetchAccountByBalance(double balance){
		EntityManagerFactory emf= null;
		EntityManager em= null;
				try {
					emf = Persistence.createEntityManagerFactory("oracleTest");
					em = emf.createEntityManager();
					String ql= "select a from Account a where a.balance >= :bal";
					Query q = em.createQuery(ql);
					q.setParameter("bal", balance);
					List<Account> list = q.getResultList();
					return list;
				} finally {
					em.close();
					emf.close();
					}
	}
	
	
	public List<Account> fetchAccountByActivity(String type, double amount){
		EntityManagerFactory emf= null;
		EntityManager em= null;
				try {
					emf = Persistence.createEntityManagerFactory("oracleTest");
					em = emf.createEntityManager();
					String ql= "select a from Account a join a.transactions tx where tx.type = :tp and tx.amount >= :amt";
					Query q = em.createQuery(ql);
					q.setParameter("tp", type);
					q.setParameter("amt", amount);
					List<Account> list = q.getResultList();
					return list;
				} finally {
					em.close();
					emf.close();
					}
	}
	
	

}

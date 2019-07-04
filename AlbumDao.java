package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlbumDao extends GenericDao{

	public List<Song> fetchSong(String singer){
		EntityManagerFactory emf= null;
		EntityManager em= null;
				try {
					emf = Persistence.createEntityManagerFactory("oracleTest");
					em = emf.createEntityManager();
					String ql= "select s from Song s where s.singer = :name";
					Query q = em.createQuery(ql);
					q.setParameter("name",singer);
					List<Song> list = q.getResultList();
					return list;
				} finally {
					em.close();
					emf.close();
					}
	}
	
	public List<Album> fetchSongAndAlbum(){
		EntityManagerFactory emf= null;
		EntityManager em= null;
				try {
					emf = Persistence.createEntityManagerFactory("oracleTest");
					em = emf.createEntityManager();
					String ql= "select a from Album a join a.songs s where a.copyRight = s.singer ";
					Query q = em.createQuery(ql);
				//	q.setParameter("bal", balance);
					List<Album> list = q.getResultList();
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

package com.lti.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lti.entity.Account;
import com.lti.entity.AccountDao;
import com.lti.entity.Transaction;

//classes which contain business LOGIC are commonly referred to as service classes
//people also use this naming convention in web services(SOAP/REST)
public class AccountService {
	
	public void openAccount(Account acc) {
		//AccountDao dao = new AccountDao();
		AccountDao dao = new AccountDao();
		dao.databaseSave(acc);
		//apart from this we may write code for sending email to the customer
		
	}

	public void withdraw(long acno, double amount) {
		AccountDao dao = new AccountDao();
		Account acc= (Account)dao.databaseFetchId(Account.class, acno);
		double balance = acc.getBalance();
		
		if(balance>amount) {
			//For Transaction
			Transaction trans = new Transaction();
			trans.setType("WITHDRAW");
			trans.setDate(new Date());
			trans.setAmount(amount);
			trans.setAccount(acc);
			
			//For Account
			double newbal=balance-amount;
			acc.setBalance(newbal);
	
		
			//Saving data in Table
			dao.databaseSave(trans);
			dao.databaseSave(acc);
		}
		else
			System.out.println("Balance insufficient");
	}
	
	public void depositing(long acno, double amount) {
		AccountDao dao = new AccountDao();
		Account acc= (Account)dao.databaseFetchId(Account.class, acno);
		double balance = acc.getBalance();
	
		//For Transaction
			Transaction trans = new Transaction();
			trans.setType("WITHDRAW");
			trans.setDate(new Date());
			trans.setAmount(amount);
			trans.setAccount(acc);
			
			//For Account
			double newbal=balance+amount;
			acc.setBalance(newbal);
	
		
			//Saving data in Table
			dao.databaseSave(trans);
			dao.databaseSave(acc);
	
	}
	
	public void transfer(long fromAcno, long toAcno ,double amount) {

		//Business Logic for transfering data
		AccountDao dao = new AccountDao();
		Account acc1= (Account)dao.databaseFetchId(Account.class, fromAcno);
		Account acc2= (Account)dao.databaseFetchId(Account.class, toAcno);
	
		//For Transaction
		if(checkBalance(fromAcno)>amount) {
			double newbal=acc1.getBalance()-amount;
			acc1.setBalance(newbal);
			
			Transaction trans = new Transaction();
			trans.setType("Transfer-debit");
			trans.setDate(new Date());
			trans.setAmount(amount);
			trans.setAccount(acc1);
			
			double newbal2=acc2.getBalance()+amount;
			acc2.setBalance(newbal2);
			//For Account
			Transaction trans2 = new Transaction();
			trans2.setType("Transfer-credit");
			trans2.setDate(new Date());
			trans2.setAmount(amount);
			trans2.setAccount(acc2);
			
	
		
			//Saving data in Table
			dao.databaseSave(trans);
			dao.databaseSave(acc1);

		
			//Saving data in Table
			dao.databaseSave(trans2);
			dao.databaseSave(acc2);
			
			
		}	
		else
			System.out.println("Balance insufficient");

	}
	
	public double checkBalance(long acno) {
		AccountDao dao=new AccountDao();
		Account acc= (Account)dao.databaseFetchId(Account.class, acno);
		return acc.getBalance();
	}
	
	public List<Transaction> miniStatement(long acno){
		AccountDao dao= new AccountDao();
		List<Transaction> trans= dao.fetchMiniStatement(121);
		return trans;
	}
	
	 public List<Account> FetchAccountByBalance(double balance){
		 AccountDao dao = new  AccountDao();
		 List<Account> acc= dao.fetchAccountByBalance(balance);
		return acc;
	 }
	 
	 public List<Account> FetchAccountByActivity(String type , double amount){
		 AccountDao dao = new  AccountDao();
		 List<Account> acc= dao.fetchAccountByActivity(type, amount);
		return acc;
	 }

	 
}

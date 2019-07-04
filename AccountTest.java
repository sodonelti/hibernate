package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.AccountDao;
import com.lti.entity.Transaction;
import com.lti.service.AccountService;

public class AccountTest {

	@Test
	public void testOpenAccount() {
		AccountService accServ = new AccountService();
		
		Account acc = new Account();
		acc.setName("Keerti");
		acc.setType("Savings");
		acc.setBalance(60000);
		accServ.openAccount(acc);
	}

	@Test
	public void testWithdraw() {
		AccountService accServ = new AccountService();
		accServ.withdraw(121, 10000);
	}
	
	@Test
	public void testDeposite() {
		AccountService accServ = new AccountService();
		accServ.depositing(121, 10000);
	}

	@Test
	public void testTransfer() {
		AccountService accServ = new AccountService();
		accServ.transfer(145, 121, 5000);
	}
	
	@Test
	public void testMiniStatement() {
		AccountService accServ = new AccountService();
		List<Transaction> trans=accServ.miniStatement(121);
		
		for(Transaction tran : trans)
		{
			System.out.println(tran.getTxno());
			System.out.println(tran.getAmount());
			System.out.println(tran.getType());
			System.out.println("************************************");
		}
	}
	
	@Test
	public void testAccountFetchByBalance() {
		AccountService accServ = new AccountService();
		List<Account> acc = accServ.FetchAccountByBalance(1000);
		for(Account ac : acc)
		{
			System.out.println(ac.getAcno());
			System.out.println(ac.getBalance());
			System.out.println("************************************");
		}
	}
	
	@Test
	public void testActivity() {
		AccountService accSer = new AccountService();
		List<Account> acc= accSer.FetchAccountByActivity("Transfer-credit", 1000);
		for(Account ac:acc)
		{
			System.out.println(ac.getAcno());
			System.out.println(ac.getName());
			System.out.println(ac.getType());
			System.out.println(ac.getBalance());
			System.out.println("************************************");

		}
	}
	
}

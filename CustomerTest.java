package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;
;
public class CustomerTest {

	@Test
	public void testAdd() {
	Customer c=new Customer();
	c.setName("Sujit");
	c.setEmail("pandey.sujit@gmail.com");
	c.setCity("Chennai");
	CustomerDao dao=new CustomerDao();
	dao.databaseAddCustomer(c);
	}
	@Test
	public void testFetchID() {
		CustomerDao dao=new CustomerDao();
		Customer cust=dao.databaseFetchId(3);
		System.out.println(cust.getId());
		System.out.println(cust.getName());
		System.out.println(cust.getEmail());
		System.out.println(cust.getCity());
	}
	
	@Test
	public void testUpdate() {
		
		CustomerDao dao=new CustomerDao();
		Customer c=new Customer();
		c=dao.databaseFetchId(1);
		c.setCity("Chennai");
		/*
		 * dao.databaseUpdate(c);
		 */
		dao.databaseAddMerge(c);
	}
	@Test
	public void fetchAll() {
		CustomerDao dao = new CustomerDao();
		List<Customer> cus = dao.databaseFetchAll();
		for(Customer c:cus ) {
			System.out.println(c);
		}
	}
	
	@Test
	public void fetchEmail() {
		CustomerDao dao1 = new CustomerDao();
		List<Customer> cus1 = dao1.databaseFetchEmail("gmail");
		for(Customer c1:cus1) {
			System.out.println(c1.getEmail());
		}
	}
	
	@Test
	public void addCustomer() {
		CustomerDao dao1 = new CustomerDao();
		Customer customer = new Customer();
		customer.setCity("Falooda");
		customer.setEmail("hunter.devil13@gmail.com");
		customer.setName("Saurav");
		dao1.databaseAddMerge(customer);
	}
}

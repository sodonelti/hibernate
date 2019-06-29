package com.lti.test;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.lti.Dao.CustomerDao;
import com.lti.entity.Customer;

public class CustomerDaoTest {

	@Test
	public void test() {
		Customer c = new Customer();
		//INSERT
		c.setName("Srikar");
		c.setEmail("sri@gmail.com");
		c.setCity("Vizag");
		
		//c.setDateOfBirth(dateOfBirth); //try this on your own
		
		CustomerDao dao= new CustomerDao();
		dao.databaseIlAddSeiyavum(c);
	}
	
	@Test
	public void testFetch( ) {
		CustomerDao dao = new CustomerDao();
		Customer cust= dao.databaseIlVangudhal(39);//FETCH
		
		System.out.println(cust.getName());
		System.out.println(cust.getEmail());
		System.out.println(cust.getDateOfBirth());
		System.out.println(cust.getCity());
		
	}
	
	@Test
	public void testUpDate() {
		CustomerDao dao = new CustomerDao();
		Customer cust= dao.databaseIlVangudhal(38);//first fetch then update
		
		cust.setCity("Greece");
		dao.databaseIlMempaduthu(cust); //UPDATE
		
	}
}

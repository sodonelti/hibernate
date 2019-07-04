package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.GenericDao;
import com.lti.entity.Order;
import com.lti.entity.Payment;

public class GenericTest {

	@Test
	public void placeOrder() {
		GenericDao gendao =new GenericDao();
		Customer customer = (Customer) gendao.databaseFetchId(Customer.class, 41);
		Payment payment = (Payment) gendao.databaseFetchId(Payment.class, 101);
		
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setAmount(56000);
		order.setCustomer(customer);
		order.setPayment(payment);
		gendao.databaseSave(order);
	}
	
	@Test
	public void fetchAll() {
		GenericDao gendao =new GenericDao();
		List<Order> list = null;
		list = gendao.databaseFetchAll(Order.class);
		for(Order l:list) {
			System.out.println(l.getOrderDate());
			System.out.println(l.getCustomer().getName());
		}
	}

	
}

package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name= "TBL_PAY")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pay_id;
	private Double amount;
	private String modeOfPayment;
	private String statusOfTransaction;
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	
	public String getStatusOfTransaction() {
		return statusOfTransaction;
	}
	public void setStatusOfTransaction(String statusOfTransaction) {
		this.statusOfTransaction = statusOfTransaction;
	}
	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}

package com.cg.mts.entities;

public class Customer extends AbstractUser {
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public Customer() {
		
	}

	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}
	
}

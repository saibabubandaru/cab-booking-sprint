package com.cg.mts.repository;

import java.util.List;

import com.cg.mts.entities.Customer;
import com.cg.mts.exception.CustomerNotFoundException;

public interface ICustomerRepository {
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
	public List<Customer>viewCustomers() throws CustomerNotFoundException;
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
}
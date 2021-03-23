package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.dao.ICustomerDao;
import com.cg.mts.entities.Customer;
import com.cg.mts.exception.CustomerNotFoundException;

public interface ICustomerRepository extends ICustomerDao, JpaRepository<Customer, Integer>{
	/*
	 * public Customer insertCustomer(Customer customer); public Customer
	 * updateCustomer(Customer customer) throws CustomerNotFoundException; public
	 * Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
	 * public List<Customer>viewCustomers() throws CustomerNotFoundException; public
	 * Customer viewCustomer(int customerId) throws CustomerNotFoundException;
	 * public Customer validateCustomer(String username, String password) throws
	 * CustomerNotFoundException;
	 */}
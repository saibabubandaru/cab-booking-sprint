package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.mts.entities.Customer;
import com.cg.mts.repository.ICustomerRepository;

public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository cDao;

	@Override
	public Customer insertCustomer(Customer customer) {
		cDao.saveAndFlush(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		return null;
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		cDao.delete(customer);
		return customer;
	}

	@Override
	public List<Customer> viewCustomers() {

		return cDao.findAll();
	}

	@Override
	public Customer viewCustomer(int customerId) {
		return cDao.findById(customerId).get();
	}

	@Override
	public Customer validateCustomer(String username, String password) {

		return null;
	}

}

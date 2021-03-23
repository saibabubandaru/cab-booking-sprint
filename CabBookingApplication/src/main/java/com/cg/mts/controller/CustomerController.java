package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Customer;
import com.cg.mts.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService cusService;
	 
	@PostMapping
	public Customer insertCustomer(Customer customer) {
		return cusService.insertCustomer(customer);
	}

	@PutMapping
	public Customer updateCustomer(Customer customer) {
		return cusService.updateCustomer(customer);
	}

	@DeleteMapping
	public Customer deleteCustomer(Customer customer) {
		return cusService.deleteCustomer(customer);
	}

	@GetMapping(value="all")
	public List<Customer> viewCustomers() {
		return cusService.viewCustomers();
	}

	@GetMapping(value = "/{customerId}")
	public Customer viewCustomer(@PathVariable int customerId) {
		return cusService.viewCustomer(customerId);
	}

	public Customer validateCustomer(String username, String password) {
		return null;
	}

}

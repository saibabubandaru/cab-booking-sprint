package com.cg.mts.dao;

import com.cg.mts.entities.Customer;
import com.cg.mts.exception.CustomerNotFoundException;

public interface ICustomerDao {

	 public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
}

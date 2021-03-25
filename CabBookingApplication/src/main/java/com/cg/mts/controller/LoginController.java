package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Admin;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.Driver;
import com.cg.mts.util.LoginServiceImpl;

@RestController
@RequestMapping("/login/")
public class LoginController {
	@Autowired
	LoginServiceImpl lServiceImpl;

	@GetMapping("/customer/{username}/{password}")
	public String customerLogin(@PathVariable("username") String username, @PathVariable("password") String password) {

		Customer customer = new Customer();
		customer.setUsername(username);
		customer.setPassword(password);

		return lServiceImpl.validateCredentials(customer);
	}

	@GetMapping("/admin/{username}/{password}")
	public String adminLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		return lServiceImpl.validateCredentials(admin);

	}

	@GetMapping("/driver/{username}/{password}")
	public String driverLogin(@PathVariable("username") String username, @PathVariable("password") String password) {

		Driver driver = new Driver();
		driver.setUsername(username);
		driver.setPassword(password);
		return lServiceImpl.validateCredentials(driver);

	}
}

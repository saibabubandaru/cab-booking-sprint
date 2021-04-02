package com.cg.mts.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Admin;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.TripBooking;
import com.cg.mts.exception.AdminNotFoundException;
import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.exception.InvalidUserOrPasswordException;
import com.cg.mts.service.IAdminService;
import com.cg.mts.service.ICustomerService;
import com.cg.mts.util.LoginService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService ias;

	@Autowired
	LoginService ls;

	@Autowired
	ICustomerService cusService;

	/**
	 * 
	 * @param admin
	 * @return String
	 * @throws InvalidUserOrPasswordException
	 */
	@PostMapping("/login")
	public String validateAdmin(@RequestBody Admin admin) throws InvalidUserOrPasswordException {
		String response;
		try {
			response = ls.validateCredintials(admin);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Username/Password");
		}
		return response;
	}
	/**
	 * 
	 * @return List<Admin>
	 */

	@GetMapping
	public List<Admin> viewALlAdmin() {
		return ias.viewALlAdmin();
	}
	/**
	 * 
	 * @param admin
	 * @return Admin
	 */

	@PostMapping
	public Admin insertAdmin(@RequestBody Admin admin) {
		return ias.insertAdmin(admin);
	}
	
	/**
	 * 
	 * @param adminId
	 * @return List<Admin>
	 * @throws AdminNotFoundException
	 */

	@DeleteMapping("/{adminId}")
	public List<Admin> deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException {
		List<Admin> s = null;
		try {
			s = ias.deleteAdmin(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with given ID: " + adminId + " Not Found to Delete");
		}
		return s;

	}
	/**
	 * 
	 * @param admin
	 * @return Admin
	 * @throws AdminNotFoundException
	 */

	@PutMapping
	public Admin updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
		Admin a = null;

		try {
			a = ias.getAdminById(admin.getAdminId());
			ias.updateAdmin(admin);
		} catch (Exception e) {
			throw new AdminNotFoundException("Admin Not Found to Update");
		}
		return a;
	}

	/**
	 * 
	 * @param adminId
	 * @return Admin
	 * @throws AdminNotFoundException
	 */
	@GetMapping("/{adminId}")
	public Admin GetAdminById(@PathVariable int adminId) throws AdminNotFoundException {
		Admin a = null;

		try {
			a = ias.getAdminById(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with ID: " + adminId + " not found!");
		}
		return a;
	}
	/**
	 * 
	 * @param customerId
	 * @return List<TripBooking>
	 * @throws CustomerNotFoundException
	 */

	@SuppressWarnings("unused")
	@GetMapping("/alltrips/{customerId}")
	public List<TripBooking> getAllTrips(@PathVariable int customerId) throws CustomerNotFoundException {

		Customer c = null;
		List<TripBooking> t = null;
		try {
			c = cusService.viewCustomer(customerId);
			t = ias.getAllTrips(customerId);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Can not find trips of Customer ID: " + customerId);
		}
		return t;
	}
	/**
	 * 
	 * @return List<TripBooking>
	 */

	@GetMapping("/cabwise")
	public List<TripBooking> getTripsCabwise() {
		return ias.getTripsCabwise();
	}
	/**
	 * 
	 * @return List<TripBooking>
	 */

	@GetMapping("/customerwise")
	public List<TripBooking> getTripsCustomerwise() {
		return ias.getTripsCustomerwise();
	}
	
	/**
	 * 
	 * @return List<TripBooking> 
	 */

	@GetMapping("/datewise")
	public List<TripBooking> getTripsDatewise() {
		return ias.getTripsDatewise();
	}
	/**
	 * 
	 * @param customerId
	 * @param fromDate
	 * @param toDate
	 * @return List<TripBooking>
	 * @throws CustomerNotFoundException
	 */

	@GetMapping("fordays/{customerId}/{fromDate}/{toDate}")
	public List<TripBooking> getAllTripsForDays(@PathVariable("customerId") int customerId,
			@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
			@PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate)
			throws CustomerNotFoundException {
		return ias.getAllTripsForDays(customerId, fromDate, toDate);
	}

}
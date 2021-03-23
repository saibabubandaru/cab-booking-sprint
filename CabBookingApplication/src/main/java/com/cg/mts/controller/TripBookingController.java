package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.repository.ITripBookingRepository;
import com.cg.mts.service.ITripBookingService;

@RestController
@RequestMapping("/tripbooking")
public class TripBookingController {

	@Autowired
	ITripBookingService itbs;

	@PostMapping
	public TripBooking insertTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.insertTripBooking(tripBooking);
	}

	@PutMapping
	public TripBooking updateTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.updateTripBooking(tripBooking);
	}

	@DeleteMapping
	public List<TripBooking> deleteTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.deleteTripBooking(tripBooking);
	}

	
	@GetMapping("/{customerId}")
	public List<TripBooking> viewAllTripsCustomer(@PathVariable int customerId) {
		return itbs.viewAllTripsCustomer(customerId);
	}

	@GetMapping("/calculate/{customerId}")
	public float calculateBill(@PathVariable int customerId) {
		return itbs.calculateBill(customerId);
	}
	 

}

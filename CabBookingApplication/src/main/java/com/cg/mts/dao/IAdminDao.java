package com.cg.mts.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.exception.CustomerNotFoundException;

public interface IAdminDao {

	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException;

	public List<TripBooking> getTripsCabwise();

	public List<TripBooking> getTripsCustomerwise();

	public List<TripBooking> getTripsDatewise();

	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws CustomerNotFoundException;

}

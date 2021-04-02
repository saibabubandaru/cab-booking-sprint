package com.cg.mts.dao;
import java.util.List;

import com.cg.mts.entities.TripBooking;

public interface ITripBookingDao {

	public List<TripBooking> viewAllTripsCustomer(int customerId);
	public float calculateBill(int customerId);
	public List<TripBooking> viewAllTripsById(int tripbookingId);
}

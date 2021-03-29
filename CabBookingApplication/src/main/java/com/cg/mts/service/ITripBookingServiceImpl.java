package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.repository.ITripBookingRepository;

@Service("itbs")
public class ITripBookingServiceImpl implements ITripBookingService {

	@Autowired
	ITripBookingRepository tbDao;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		tbDao.saveAndFlush(tripBooking);
		return tripBooking;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		return tbDao.saveAndFlush(tripBooking);
	}

	@Override
	public List<TripBooking> deleteTripBooking(TripBooking tripBooking) {
		tbDao.deleteById(tripBooking.getTripBookingId());
		return tbDao.findAll();
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		return tbDao.viewAllTripsCustomer(customerId);
	}

	@Override
	public float calculateBill(int customerId) {
		return tbDao.calculateBill(customerId);
	}

}

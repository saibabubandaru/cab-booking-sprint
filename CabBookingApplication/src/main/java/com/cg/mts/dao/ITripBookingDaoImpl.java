package com.cg.mts.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.mts.entities.TripBooking;

@Repository
@Transactional
public class ITripBookingDaoImpl implements ITripBookingDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		TypedQuery<TripBooking> q = em.createQuery(
				"select tb from TripBooking tb where tb.customer.customerId=:customerId", TripBooking.class);
		q.setParameter("customerId", customerId);
		List<TripBooking> result = q.getResultList();
		return result;
	}

	@Override
	public float calculateBill(int customerId) {
		TypedQuery<TripBooking> q = em.createQuery(
				"select tb from TripBooking tb where tb.customer.customerId=:customerId", TripBooking.class);
		q.setParameter("customerId", customerId);
		List<TripBooking> list = q.getResultList();
		Optional<Float> result = list.stream().map((tb) -> tb.getBill()).reduce((a, b) -> a + b);
		return result.get();
	}

}

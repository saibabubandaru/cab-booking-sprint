package com.cg.mts.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.exception.CustomerNotFoundException;

@Repository
@Transactional
public class IAdminDaoImpl implements IAdminDao{

	@PersistenceContext
	EntityManager em;
	/**
	 * @return List<TripBooking>
	 * @param customerId
	 * @throws CustomerNotFoundException
	 */
	
	
	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException {
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb where tb.customer.customerId=:cId",TripBooking.class);
		q.setParameter("cId", customerId);
		List<TripBooking> result = q.getResultList();
		return result;
	}
	/**
	 * @return List<TripBooking>
	 */
	

	@Override
	public List<TripBooking> getTripsCabwise() {
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb",TripBooking.class);
		List<TripBooking> trips = q.getResultList();
		trips = trips.stream().sorted((a,b)->a.getDriver().getCab().getCabId()-b.getDriver().getCab().getCabId()).collect(Collectors.toList());
		return trips;
	}
	/**
	 * @param List<TripBooking>
	 */

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb",TripBooking.class);
		List<TripBooking> trips = q.getResultList();
		trips = trips.stream().sorted((a,b)->a.getCustomer().getCustomerId()-b.getCustomer().getCustomerId()).collect(Collectors.toList());
		return trips;
	}
	/**
	 * @param List<TripBooking>
	 */

	@Override
	public List<TripBooking> getTripsDatewise() {
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb",TripBooking.class);
		List<TripBooking> trips = q.getResultList();
		trips = trips.stream().sorted((a,b)->a.getFromDateTime().compareTo(b.getFromDateTime())).collect(Collectors.toList());
		return trips;
	}
	/**
	 * 
	 * @param customerId
	 * @param fromDate
	 * @param toDate
	 * @return List<TripBooking>
	 * @throws CustomerNotFoundException
	 */

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws CustomerNotFoundException {
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb where tb.customer.customerId=:cId and tb.fromDateTime between :start and :end",TripBooking.class);
		q.setParameter("cId", customerId);
		q.setParameter("start", fromDate);
		q.setParameter("end", toDate);
		List<TripBooking> trips = q.getResultList();
		return trips;
	}


}
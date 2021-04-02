package com.cg.mts.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admin;
import com.cg.mts.entities.TripBooking;
import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.repository.IAdminRepository;

@Service("ias")
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository aDao;

	/**
	 * @return List<Admin>
	 */
	@Override
	public List<Admin> viewALlAdmin() {

		return aDao.findAll();
	}

	/**
	 * @return Admin
	 * @param admin
	 */

	@Override
	public Admin insertAdmin(Admin admin) {
		aDao.saveAndFlush(admin);
		return admin;
	}

	/**
	 * @return Admin
	 * @param admin
	 */

	@Override
	public Admin updateAdmin(Admin admin) {
		aDao.saveAndFlush(admin);
		return admin;
	}

	/**
	 * @return adminId
	 * @param List<Admin>
	 */

	@Override
	public List<Admin> deleteAdmin(int adminId) {
		aDao.deleteById(adminId);
		return aDao.findAll();
	}

	/**
	 * @return List<TripBooking>
	 * @param customerId
	 * @throws CustomerNotFoundException
	 */

	@Override
	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException {
		return aDao.getAllTrips(customerId);
	}

	/**
	 * @return List<TripBooking>
	 */

	@Override
	public List<TripBooking> getTripsCabwise() {
		return aDao.getTripsCabwise();
	}

	/**
	 * @return List<TripBooking>
	 */

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		return aDao.getTripsCustomerwise();
	}

	/**
	 * @return List<TripBooking>
	 */

	@Override
	public List<TripBooking> getTripsDatewise() {
		return aDao.getTripsDatewise();
	}

	/**
	 * @return List<TripBooking>
	 * @param customerId
	 * @param fromDate
	 * @param toDate
	 * @return List<TripBooking>
	 * @throws CustomerNotFoundException
	 */

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws CustomerNotFoundException {
		return aDao.getAllTripsForDays(customerId, fromDate, toDate);
	}

	/**
	 * @param adminId
	 * @return Admin
	 * @throws CustomerNotFoundException
	 */

	@Override
	public Admin getAdminById(int adminId) {

		return aDao.findById(adminId).get();
	}

}
package com.cg.mts.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

@Repository("idr")
@Transactional
public class IDriverRepositoryImpl implements IDriverRepository {


	@PersistenceContext
	EntityManager em;
	
	@Override
	public Driver insertDriver(Driver driver) {
		em.persist(driver);
		return driver;
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverNotFoundException {
		Driver updateDriver = em.find(Driver.class, driver.getDriverId());
		updateDriver.setLicenseNo(driver.getLicenseNo());
		updateDriver.setCab(driver.getCab());
		updateDriver.setRating(driver.getRating());
		em.merge(updateDriver);
		return updateDriver;
	}

	@Override
	public Driver deleteDriver(int driverId) throws DriverNotFoundException {
		Driver deleteDriver = em.find(Driver.class, driverId);
		em.remove(deleteDriver);
		return deleteDriver;
	}

	@Override
	public Driver viewDriver(int driverId) throws DriverNotFoundException {
		Driver viewDriver = em.find(Driver.class, driverId);
		return viewDriver;
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		Query q = em.createNativeQuery("select * from Driver where rating>=4.5",Driver.class);
		List<Driver> allBestDrivers = (List<Driver>)q.getResultList();
		return allBestDrivers;
	}

}

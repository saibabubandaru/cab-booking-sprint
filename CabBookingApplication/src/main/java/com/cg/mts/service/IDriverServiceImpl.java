package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;
import com.cg.mts.repository.IDriverRepository;

@Service("ids")
public class IDriverServiceImpl implements IDriverService {
	@Autowired
	IDriverRepository dDao;
	 

	@Override
	public List<Driver> insertDriver(Driver driver) {
		dDao.saveAndFlush(driver);
		return dDao.findAll();
	}

	@Override
	public List<Driver> updateDriver(Driver driver) throws DriverNotFoundException {
		 
		return null;
	}

	@Override
	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver viewDriver(int driverId) throws DriverNotFoundException {
		
		
		return dDao.findById(driverId).get();
	}

	@Override
	public List<Driver> displayAllDriver() {
		 
		return dDao.findAll();
	}
	
	 
/*
	@Autowired
	IDriverRepository idr;
	
	@Override
	public Driver insertDriver(Driver driver) {
		return idr.insertDriver(driver);
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverNotFoundException {
		return idr.updateDriver(driver);
	}

	@Override
	public Driver deleteDriver(int driverId) throws DriverNotFoundException {
		return idr.deleteDriver(driverId);
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		return idr.viewBestDrivers();
	}

	@Override
	public Driver viewDriver(int driverId) throws DriverNotFoundException {
		return idr.viewDriver(driverId);
	}
	*/
	
}

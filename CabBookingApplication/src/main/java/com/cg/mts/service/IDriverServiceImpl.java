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
	
}

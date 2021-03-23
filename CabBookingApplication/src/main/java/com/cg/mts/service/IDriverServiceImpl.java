package com.cg.mts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.AbstractUser;
import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;
import com.cg.mts.repository.IDriverRepository;

@Service("ids")
public class IDriverServiceImpl implements IDriverService {
	@Autowired
	IDriverRepository dDao;

	@Override
	public List<Driver> displayAllDriver() {
		return dDao.findAll();
	}

	@Override
	public Driver viewDriver(int driverId) throws DriverNotFoundException {
		return dDao.findById(driverId).get();
	}

	@Override
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		List<Driver> bestDrivers = dDao.findAll();
		return bestDrivers.stream().filter((d)->d.getRating()>=4.5).collect(Collectors.toList());
	}

	@Override
	public List<Driver> insertDriver(Driver driver) {
		dDao.saveAndFlush(driver);
		return dDao.findAll();
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverNotFoundException {
		return dDao.saveAndFlush(driver);
	}

	@Override
	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException {
		dDao.deleteById(driverId);
		return dDao.findAll();
	}
	 
	
}

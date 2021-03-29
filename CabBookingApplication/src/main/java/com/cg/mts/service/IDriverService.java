package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.AbstractUser;
import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

public interface IDriverService {
	public List<Driver> displayAllDriver();

	public Driver viewDriver(int driverId) throws DriverNotFoundException;

	public List<Driver> viewBestDrivers() throws DriverNotFoundException;

	public List<Driver> insertDriver(Driver driver);

	public Driver updateDriver(Driver driver) throws DriverNotFoundException;

	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException;

}
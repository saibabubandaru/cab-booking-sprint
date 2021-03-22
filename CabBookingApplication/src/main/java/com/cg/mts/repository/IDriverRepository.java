package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

public interface IDriverRepository{
	public Driver insertDriver(Driver driver);
	public Driver updateDriver(Driver driver)throws DriverNotFoundException;
	public Driver deleteDriver(int driverId)throws DriverNotFoundException;
	public Driver viewDriver(int driverId)throws DriverNotFoundException;
	public List<Driver>viewBestDrivers()throws DriverNotFoundException;
}
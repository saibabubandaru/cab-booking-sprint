package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

public interface IDriverDao {

	public List<Driver> viewBestDrivers() throws DriverNotFoundException;

}

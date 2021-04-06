package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;
import com.cg.mts.exception.InvalidUserOrPasswordException;
import com.cg.mts.service.IDriverService;
import com.cg.mts.util.LoginService;

/**
 * @author Ganesh 
 * @version 1.0
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	IDriverService ids;

	@Autowired
	LoginService ls;

	/**
	 * validateDriver
	 * @param driver
	 * @return String
	 * @throws InvalidUserOrPasswordException
	 */

	@PostMapping("/login")
	public String validateDriver(@RequestBody Driver driver) throws InvalidUserOrPasswordException {
		String response;
		try {
			response = ls.validateCredintials(driver);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Username/Password");
		}
		return response;
	}

	/**
	 * displayAllDrivers
	 * @return List<Driver>
	 */

	@GetMapping
	public List<Driver> displayAllDrivers() {
		return ids.displayAllDriver();
	}

	/**
	 * viewDriver 
	 * @param driverId
	 * @return Driver
	 * @throws DriverNotFoundException
	 */

	@GetMapping("/{driverId}")
	public Driver viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
		Driver driver = null;
		try {
			driver = ids.viewDriver(driverId);

		} catch (Exception e) {
			throw new DriverNotFoundException("Driver with Id: " + driverId + " Not Found!");
		}
		return driver;
	}

	/**
	 * viewBestDrivers
	 * @return List<Driver>
	 * @throws DriverNotFoundException
	 */

	@GetMapping("/bestdrivers")
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		List<Driver> lis = null;
		try {
			lis = ids.viewBestDrivers();
		} catch (Exception e) {
			throw new DriverNotFoundException("Best Drivers List is Empty");
		}
		return lis;
	}

	/**
	 * insertDriver
	 * @param driver
	 * @return List<Driver>
	 */

	@PostMapping
	public List<Driver> insertDriver(@RequestBody Driver driver) {
		return ids.insertDriver(driver);
	}

	/**
	 * updateDriver
	 * @param driver
	 * @return Driver
	 * @throws DriverNotFoundException
	 */
	@SuppressWarnings("unused")
	@PutMapping
	public Driver updateDriver(@RequestBody Driver driver) throws DriverNotFoundException {
		Driver driverCheck = null;
		Driver d = null;
		try {
			driverCheck = viewDriver(driver.getDriverId());
			d = ids.updateDriver(driver);
		} catch (Exception e) {
			throw new DriverNotFoundException("Driver with Id: " + driver.getDriverId() + " Not Found to Update!");
		}
		return d;
	}

	/**
	 * deleteDriver
	 * @param driverId
	 * @return List<Driver>
	 * @throws DriverNotFoundException
	 */

	@DeleteMapping("/{driverId}")
	public List<Driver> deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
		List<Driver> d = null;
		try {
			d = ids.deleteDriver(driverId);
		} catch (Exception e) {
			throw new DriverNotFoundException("Driver with Id: " + driverId + " Not FOund To Delete!");
		}
		return d;
	}

}

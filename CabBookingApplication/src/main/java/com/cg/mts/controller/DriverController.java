package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.cg.mts.service.IDriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	IDriverService ids;
	
	@GetMapping
	public List<Driver> displayAllDrivers(){
		return ids.displayAllDriver();
	}
	
	@GetMapping("/{driverId}")
	public Driver viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
		return ids.viewDriver(driverId);
	}
	
	@GetMapping("/bestdrivers")
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		return ids.viewBestDrivers();
	}
	
	@PostMapping
	public List<Driver> insertDriver(@RequestBody Driver driver){
		return ids.insertDriver(driver);
	}
	
	@PutMapping
	public Driver updateDriver(@RequestBody Driver driver) throws DriverNotFoundException {
		return ids.updateDriver(driver);
	}
	
	@DeleteMapping("/{driverId}")
	public List<Driver> deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
		return ids.deleteDriver(driverId);
	}

	
}

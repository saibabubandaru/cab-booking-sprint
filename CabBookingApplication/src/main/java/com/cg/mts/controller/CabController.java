package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.service.ICabService;

@RestController
@RequestMapping("/cab")
public class CabController {

	@Autowired
	ICabService iCabService;

	/**
	 * 
	 * @param cab
	 * @return Cab
	 */

	public Cab insertCab(@RequestBody Cab cab) {
		return iCabService.insertCab(cab);
	}

	/**
	 * 
	 * @param cab
	 * @return Cab
	 * @throws CabNotFoundException
	 */

	@PutMapping
	public Cab updateCab(@RequestBody Cab cab) throws CabNotFoundException {
		@SuppressWarnings("unused")
		Cab cabCheck = null;
		Cab c = null;
		try {
			cabCheck = iCabService.getCabById(cab.getCabId());
			c = iCabService.updateCab(cab);
		} catch (Exception e) {
			throw new CabNotFoundException("Cab not found to Update");
		}
		return c;
	}

	/**
	 * 
	 * @param cab
	 * @return Cab
	 * @throws CabNotFoundException
	 */

	@DeleteMapping
	public Cab deleteCab(Cab cab) throws CabNotFoundException {
		@SuppressWarnings("unused")
		Cab cabCheck = null;
		Cab c = null;
		try {
			cabCheck = iCabService.getCabById(cab.getCabId());
			c = iCabService.deleteCab(cab);
		} catch (Exception e) {
			throw new CabNotFoundException("Cab not found to Delete");
		}
		return c;
	}

	@DeleteMapping(value = "/{cabId}")
	public List<Cab> deleteCabById(@PathVariable int cabId) throws CabNotFoundException {
		try {
			return iCabService.deleteCabById(cabId);
		} catch (Exception e) {
			throw new CabNotFoundException("Cab not found to Delete");
		}

	}

	/**
	 * 
	 * @param carType
	 * @return List<Cab>
	 */

	@GetMapping(value = "type/{carType}")
	public List<Cab> viewCabsOfType(String carType) {
		return iCabService.viewCabsOfType(carType);
	}

	/**
	 * 
	 * @param carType
	 * @return
	 */

	@GetMapping(value = "/count/{carType}")
	public int countCabsOfType(@PathVariable String carType) {
		return iCabService.countCabsOfType(carType);
	}

}
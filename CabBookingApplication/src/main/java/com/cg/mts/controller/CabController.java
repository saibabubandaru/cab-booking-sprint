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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Cab;
import com.cg.mts.service.ICabService;

@RestController
@RequestMapping("/cab")
public class CabController {

	@Autowired
	ICabService iCabService;

	@PostMapping
	public Cab insertCab(@RequestBody Cab cab) {
		return iCabService.insertCab(cab);
	}

	@PutMapping
	public Cab updateCab(@RequestBody Cab cab) {
		return iCabService.updateCab(cab);
	}

	@DeleteMapping
	public Cab deleteCab(Cab cab) {
		return iCabService.deleteCab(cab);
	}
	
	@DeleteMapping(value="/id/{cabId}")
	public String deletedBycCabId(@PathVariable int cabId) {
		return iCabService.deleteCabById(cabId);
	}

	@GetMapping(value = "type/{carType}")
	public List<Cab> viewCabsOfType(String carType) {
		return iCabService.viewCabsOfType(carType);
	}

	@GetMapping(value = "/count/{carType}")
	public int countCabsOfType(@PathVariable String carType) {
		return iCabService.countCabsOfType(carType);
	}

}

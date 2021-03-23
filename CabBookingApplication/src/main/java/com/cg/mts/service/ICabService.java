package com.cg.mts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.mts.entities.Cab;

public interface ICabService {
	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab);
	public Cab deleteCab(Cab cab);
	public List<Cab> viewCabsOfType(String carType);
	public int countCabsOfType(String carType);
	public String deleteCabById(int cabId);
}
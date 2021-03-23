package com.cg.mts.dao;

import java.util.List;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;

public interface ICabDao {

	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;

	public int countCabsOfType(String carType) throws CabNotFoundException;

}

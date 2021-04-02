package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.dao.ICabDao;
import com.cg.mts.entities.Cab;

public interface ICabRepository extends ICabDao, JpaRepository<Cab, Integer> {
	/*
	 * public Cab insertCab(Cab cab); public Cab updateCab(Cab cab) throws
	 * CabNotFoundException; public Cab deleteCab(Cab cab) throws
	 * CabNotFoundException; public List<Cab> viewCabsOfType(String carType) throws
	 * CabNotFoundException; public int countCabsOfType(String carType) throws
	 * CabNotFoundException;
	 */

}
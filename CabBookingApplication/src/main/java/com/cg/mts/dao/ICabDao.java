package com.cg.mts.dao;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;

public interface ICabDao {

	public Cab updateCab(Cab cab) throws CabNotFoundException;
	
}

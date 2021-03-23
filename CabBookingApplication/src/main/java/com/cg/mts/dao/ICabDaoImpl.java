package com.cg.mts.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Cab;
import com.cg.mts.entities.Driver;
import com.cg.mts.exception.CabNotFoundException;

@Repository
@Transactional
public class ICabDaoImpl implements ICabDao {


	@PersistenceContext
	EntityManager em;
	
	@Override
	public Cab updateCab(Cab cab) throws CabNotFoundException {
		
		return null;
	}

}

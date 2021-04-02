package com.cg.mts.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;

@Repository
@Transactional
public class ICabDaoImpl implements ICabDao {

	@PersistenceContext
	EntityManager em;

	/**
	 * @param carType
	 * @return List<cab>
	 * @throws CabNotFoundException
	 */

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException {
		TypedQuery<Cab> q = em.createQuery("select c from Cab c where carType = :n", Cab.class);
		q.setParameter("n", carType);

		return q.getResultList();
	}

	/**
	 * @param carType
	 * @return integer
	 * @throws CabNotFoundException
	 */

	@Override
	public int countCabsOfType(String carType) throws CabNotFoundException {
		// int q = (int)em.createQuery("SELECT COUNT(c) FROM Cab c where carType =
		// :n").setParameter("n", carType).getSingleResult();
		// TypedQuery<Cab> q = em.createQuery("select count(c) from Cab c where
		// c.carType = :n", Cab.class);
		/*
		 * TypedQuery<Cab> q =
		 * em.createQuery("select COUNT(c) from Cab c where carType = :n", Cab.class);
		 * q.setParameter("n", carType);
		 */
		List<Cab> lisCabs = viewCabsOfType(carType);
		return lisCabs.size();
	}

}

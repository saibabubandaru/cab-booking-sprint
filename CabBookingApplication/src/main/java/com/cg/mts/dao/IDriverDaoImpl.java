package com.cg.mts.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

@Repository
@Transactional
public class IDriverDaoImpl implements IDriverDao {

	@PersistenceContext
	EntityManager em;
	


	@Override
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		TypedQuery<Driver> q= em.createQuery("select d from Driver d where d.rating >=4.5",Driver.class);
		return q.getResultList();
	}

}

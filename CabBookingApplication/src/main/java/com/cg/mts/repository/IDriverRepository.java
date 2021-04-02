package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.dao.IDriverDao;
import com.cg.mts.entities.Driver;

@Repository("dDao")
public interface IDriverRepository extends IDriverDao, JpaRepository<Driver, Integer> {

}
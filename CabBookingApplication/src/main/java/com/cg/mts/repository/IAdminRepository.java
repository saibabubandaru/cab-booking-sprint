package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.dao.IAdminDao;
import com.cg.mts.entities.Admin;

@Repository("aDao")
public interface IAdminRepository extends IAdminDao, JpaRepository<Admin, Integer> {

}
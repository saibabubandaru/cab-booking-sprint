package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.dao.ICustomerDao;
import com.cg.mts.entities.Customer;

@Repository("cDao")
public interface ICustomerRepository extends ICustomerDao, JpaRepository<Customer, Integer> {


}
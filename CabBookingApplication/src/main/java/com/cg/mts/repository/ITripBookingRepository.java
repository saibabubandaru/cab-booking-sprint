package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.dao.IDriverDao;
import com.cg.mts.dao.ITripBookingDao;
import com.cg.mts.entities.Driver;
import com.cg.mts.entities.TripBooking;

@Repository("tbDao")
public interface ITripBookingRepository extends ITripBookingDao, JpaRepository<TripBooking, Integer> {

}
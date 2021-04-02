package com.cg.mts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.repository.ICabRepository;

@Service("iCabService")
public class ICabServiceImpl implements ICabService {

	@Autowired
	ICabRepository cabDao;

	/**
	 * @param cab
	 * @return Cab
	 */

	@Override
	public Cab insertCab(Cab cab) {
		cabDao.saveAndFlush(cab);
		return cab;
	}

	/**
	 * @param cab
	 * @return Cab
	 */

	@Override
	public Cab updateCab(Cab cab) {
		Cab tempCab = cabDao.findById(cab.getCabId()).get();
		if (tempCab != null) {
			tempCab.setCarType(cab.getCarType());
			tempCab.setPerKmRate(cab.getPerKmRate());
			cabDao.save(tempCab);
		}
		return tempCab;
	}

	/**
	 * @param cab
	 * @return Cab
	 */

	@Override
	public Cab deleteCab(Cab cab) {
		cabDao.delete(cab);
		return cab;
	}

	/**
	 * @param carType
	 * @return List<Cab>
	 */

	@Override
	public List<Cab> viewCabsOfType(String carType) {

		try {
			return cabDao.viewCabsOfType(carType);
		} catch (CabNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param carType
	 * @return integer
	 */

	@Override
	public int countCabsOfType(String carType) {

		try {
			return cabDao.countCabsOfType(carType);
		} catch (CabNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param cabId
	 * @return Cab
	 */

	@Override
	public Cab getCabById(int cabID) {

		return cabDao.findById(cabID).get();
	}

}

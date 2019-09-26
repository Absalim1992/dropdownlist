package com.cruds.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.dao.CityDAO;
import com.cruds.model.CityEntity;
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDAO cityDAO;
	
	@Override
	public List<CityEntity> findByState(int stateId) {
		return cityDAO.findByState(stateId); 
	}

}

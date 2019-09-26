package com.cruds.dao;

import java.util.List;

import com.cruds.model.CityEntity;

public interface CityDAO {
	
	public List<CityEntity> findByState(int stateId);
}

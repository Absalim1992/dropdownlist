package com.cruds.dao;

import java.util.List;

import com.cruds.model.StateEntity;

public interface StateDAO {

	
	public List<StateEntity> findByCountry(int countryId); 
}

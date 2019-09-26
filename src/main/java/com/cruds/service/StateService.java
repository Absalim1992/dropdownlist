package com.cruds.service;

import java.util.List;

import com.cruds.model.StateEntity;

public interface StateService {

	public List<StateEntity> findByCountry(int countryId); 
}

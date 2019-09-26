package com.cruds.service;

import java.util.List;

import com.cruds.model.CityEntity;

public interface CityService {

	public List<CityEntity> findByState(int stateId);
}

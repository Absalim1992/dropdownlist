package com.cruds.service;

import java.util.List;

import com.cruds.model.Country;

public interface CountryService {

	public List<Country> findAll();
	
	public Country find(int id);
}

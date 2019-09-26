package com.cruds.dao;

import java.util.List;

import com.cruds.model.Country;

public interface CountryDAO {
	
	public List<Country> findAll();
	
	public Country find(int id);
}

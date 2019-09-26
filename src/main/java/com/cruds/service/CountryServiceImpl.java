package com.cruds.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.dao.CountryDAO;
import com.cruds.model.Country;

@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService	{

	@Autowired
	private CountryDAO countryDAO; 
	
	@Override
	public List<Country> findAll() {
		return countryDAO.findAll();
	}

	@Override
	public Country find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

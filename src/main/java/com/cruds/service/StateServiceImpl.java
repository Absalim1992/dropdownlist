package com.cruds.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.dao.StateDAO;
import com.cruds.model.StateEntity;
@Service("stateService")
@Transactional
public class StateServiceImpl implements StateService{

	@Autowired
	private StateDAO stateDAO;
	
	@Override
	public List<StateEntity> findByCountry(int countryId) {
		return stateDAO.findByCountry(countryId);
	}

}

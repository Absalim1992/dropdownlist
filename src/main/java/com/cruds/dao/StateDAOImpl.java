package com.cruds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.model.Country;
import com.cruds.model.StateEntity;

@Repository("stateDAO")
public class StateDAOImpl implements StateDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StateEntity> findByCountry(int countryId) {
		System.out.println("Inside FindByCountry Function");
		List<StateEntity> stateEntities = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			System.out.println("In Try Block");
			transaction = session.beginTransaction();
			//stateEntities = session.createQuery("select s.id as id, s.name as name from state s where country.id = :countryId")
			stateEntities = session.createQuery("select s.id, s.name from state s where s.countryId = :countryId")
					.setInteger("countryId", countryId)
					.setResultTransformer(Transformers.aliasToBean(StateEntity.class))
					.list();
			transaction.commit();
		}
		catch (Exception e) {
			stateEntities = null;
			if(transaction!=null){
				transaction.rollback();
			}
		}finally{
			session.close();
		}
		System.out.println(stateEntities);
		return stateEntities;
	}

}

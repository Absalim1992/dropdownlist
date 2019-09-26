package com.cruds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.model.CityEntity;
import com.cruds.model.StateEntity;
@Repository("cityDAO")
public class CityDAOImpl implements CityDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CityEntity> findByState(int stateId) {
		List<CityEntity> cityEntities = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			cityEntities = session.createQuery("select c.id as id, c.name as name from city c where state.id = :stateId")
					.setInteger("stateId", stateId)
					.setResultTransformer(Transformers.aliasToBean(CityEntity.class))
					.list();
			transaction.commit();
		}
		catch (Exception e) {
			cityEntities = null;
			if(transaction!=null){
				transaction.rollback();
			}
		}finally{
			session.close();
		}
		
		return cityEntities;
	}

}

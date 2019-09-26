package com.cruds.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.model.Country;

@Repository("countryDAO")
public class CountryDAOImpl extends AbstractDao<Integer, Country> implements CountryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> findAll() {
		
		Criteria criteria = createEntityCriteria();
		return (List<Country>) criteria.list();
		
		/*List<Country> countries = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			countries = session.createQuery("from country").list();
			transaction.commit();
		}
		catch (Exception e) {
			countries = null;
			if(transaction!=null){
				transaction.rollback();
			}
		}finally{
			session.close();
		}
		
		return countries;*/
	}

	@Override
	public Country find(int id) {

		Country country = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			country = (Country) session.createQuery("from Country where id = :id")
					.setInteger("id", id)
					.uniqueResult();
			transaction.commit();
		}catch (Exception e) {
			country = null;
				if(transaction != null){
					transaction.rollback();
				}
		}finally {
			session.close();
		}
		
		return country;
	}

}

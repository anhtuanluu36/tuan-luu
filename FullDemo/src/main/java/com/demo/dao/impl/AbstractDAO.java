package com.demo.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.exception.CustomException;

public abstract class AbstractDAO<E> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<E> persistentClass;

	@SuppressWarnings({ "unchecked" })
	public AbstractDAO() {
		this.persistentClass = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<E> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings({ "unchecked" })
	public List<E> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(persistentClass);
		return criteria.list();
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<E> findAll(int firstResult, int pageSize) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(persistentClass);
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	
	public void saveOrUpdate(E entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(E entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}
	
	@SuppressWarnings({ "unchecked" })
	public E findByPrimaryKey(Integer id) throws CustomException {
	    return (E) sessionFactory.getCurrentSession().load(persistentClass, id);
	}

    protected SessionFactory getSessionFactory() {
      return sessionFactory;
    }
}

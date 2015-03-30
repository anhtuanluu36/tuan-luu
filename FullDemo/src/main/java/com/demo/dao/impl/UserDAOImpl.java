package com.demo.dao.impl;


import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.demo.dao.UserDAO;
import com.demo.model.User;

@Component
public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

	@Override
	public User findUser(String userName, String password) {
		String hql = "from User where userName = :userName and password = :password";
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		return (User) query.uniqueResult();
	}

}

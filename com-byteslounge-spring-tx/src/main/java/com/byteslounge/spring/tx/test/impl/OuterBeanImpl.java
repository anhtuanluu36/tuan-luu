package com.byteslounge.spring.tx.test.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.byteslounge.spring.tx.dao.TestDAO;
import com.byteslounge.spring.tx.model.User;
import com.byteslounge.spring.tx.test.InnerBean;
import com.byteslounge.spring.tx.test.OuterBean;

@Service("outerBeanImpl")
public class OuterBeanImpl implements OuterBean {

	@Autowired
	private TestDAO testDAO;
	
	@Autowired
	private InnerBean innerBean;
	
	@Autowired
	private ApplicationContext appContext;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequired(User user) {
		testDAO.insertUser(user);
		try{
			innerBean.testRequired();
		} catch(RuntimeException e){
			// handle exception
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequiresNew(User user) {
		testDAO.insertUser(user);
		try{
			innerBean.testRequiresNew();
		} catch(Exception e){
			// handle exception
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void testMandatory(User user) {
		testDAO.insertUser(user);
		try{
			innerBean.testMandatory();
		} catch(Exception e){
			// handle exception
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void testSupport(User user) {
		testDAO.insertUser(user);
		try{
			innerBean.testSupport();
		} catch(Exception e){
			// handle exception
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void testInner(User user) {
		testDAO.insertUser(user);
		try{
			getService().testInnerRequired();
		} catch(Exception e){
			// handle exception
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void testInnerRequired() {
		throw new RuntimeException("Rollback this transaction!");
	}
	
	private OuterBean getService() {
		return (OuterBean) appContext.getBean("outerBeanImpl"); 
	}
}

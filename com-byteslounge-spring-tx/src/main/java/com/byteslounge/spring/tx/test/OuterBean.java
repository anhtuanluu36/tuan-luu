package com.byteslounge.spring.tx.test;

import com.byteslounge.spring.tx.model.User;

public interface OuterBean {

	void testRequired(User user);
	
	void testRequiresNew(User user);
	
	void testMandatory(User user);
	
	void testSupport(User user);
	
	void testInner(User user);
	
	void testInnerRequired();

}

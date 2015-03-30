package com.demo.dao;

import com.demo.model.User;

public interface UserDAO {
	public User findUser(String userName, String password); 
}

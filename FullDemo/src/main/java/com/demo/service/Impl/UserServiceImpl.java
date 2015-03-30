package com.demo.service.Impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserDAO;
import com.demo.dto.UserDTO;
import com.demo.model.User;
import com.demo.service.UserService;

@Service
@Transactional(propagation=Propagation.SUPPORTS,rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDTO findUser(String userName, String password) {
		User user = userDAO.findUser(userName, password);
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
	}

}

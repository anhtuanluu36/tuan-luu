package com.demo.service;

import com.demo.dto.UserDTO;

public interface UserService {
	
	public UserDTO findUser(String userName, String password);

}

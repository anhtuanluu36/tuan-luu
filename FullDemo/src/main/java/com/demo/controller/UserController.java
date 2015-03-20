package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserDetailsService userService;

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/authenticated/retrieve", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public UserDetails authenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication == null || !(authentication.getPrincipal() instanceof UserDetails)) {
			return null;
		}

		return (UserDetails)authentication.getPrincipal();
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void authenticate() {
		// endpoint for the basic authentication request to pass
	}
}

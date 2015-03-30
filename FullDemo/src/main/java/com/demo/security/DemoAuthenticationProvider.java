package com.demo.security;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import com.demo.dto.UserDTO;
import com.demo.service.UserService;


/**
 * @author tuan.luu
 */
public class DemoAuthenticationProvider implements AuthenticationProvider {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoAuthenticationProvider.class);

	public static final String USER_AGENT = "User-Agent";
	public static final String LOGIN_EXCEPTION_KEY = "login_error_message";

	@Autowired
	private UserService userService;
	@Autowired
	protected HttpServletRequest httpServletRequest;

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		if (authentication.getDetails() != null) {
			if (authentication.getDetails() instanceof UserDTO) {
				UserDTO userDTO = (UserDTO) authentication.getDetails();
				if (userDTO != null) {
					username = userDTO.getUserName();
					password = userDTO.getPassword();
				}
			}
		}

		if (StringUtils.hasLength(username) == false) {
			final BadCredentialsException e = new BadCredentialsException("username.required");
			httpServletRequest.getSession().setAttribute(LOGIN_EXCEPTION_KEY, e);
			throw e;
		}

		if (StringUtils.hasLength(password) == false) {
			final BadCredentialsException e = new BadCredentialsException("password.required");
			httpServletRequest.getSession().setAttribute(LOGIN_EXCEPTION_KEY, e);
			throw e;
		}

		UserDTO userDTO;
		try {
			userDTO = userService.findUser(authentication.getName(), (String) authentication.getCredentials());
		} catch (final Exception ex) {
			final BadCredentialsException e = new BadCredentialsException("badpassword");
			httpServletRequest.getSession().setAttribute(LOGIN_EXCEPTION_KEY, e);
			throw e;
		}

		
		final Set<GrantedAuthority> roles = new LinkedHashSet<GrantedAuthority>();
		GrantedAuthority role = new SimpleGrantedAuthority(userDTO.getRole());
		roles.add(role);

		// Init authentication object
		final DemoAuthentication dashboardAuthentication = new DemoAuthentication(roles);
		dashboardAuthentication.setAuthenticated(true);
		
		dashboardAuthentication.setDetails(userDTO);
		SecurityContextHolder.getContext().setAuthentication(dashboardAuthentication);

		return dashboardAuthentication;
	}

	@Override
	public boolean supports(final Class<? extends Object> clazz) {
		if (UsernamePasswordAuthenticationToken.class.isAssignableFrom(clazz) || DemoAuthentication.class.isAssignableFrom(clazz)) {
			return true;
		}
		return false;
	}

	/**
	 * Initial idea is for subclass to override
	 * 
	 * @param dashboardAuthentication
	 * @throws AuthenticationException
	 */
	protected void extraChecking(DemoAuthentication demoAuthentication) throws AuthenticationException {
	}

}

package com.demo.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class DemoAuthentication  extends AbstractAuthenticationToken {

	private static final long serialVersionUID = -8354881075981382334L;

	public DemoAuthentication(Collection<? extends GrantedAuthority> arg0) {
		super(arg0);
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return getDetails();
	}

}

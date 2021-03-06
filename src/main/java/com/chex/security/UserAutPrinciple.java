package com.chex.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chex.model.UserAuth;

public class UserAutPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;
	UserAuth userAuth;
	
	public UserAutPrinciple(UserAuth userAuth) {
		this.userAuth = userAuth;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+ userAuth.getRole());
		authorities.add(authority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return userAuth.getPassword();
	}

	@Override
	public String getUsername() {
		return userAuth.getUsername();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if(userAuth != null)
			return userAuth.getActive() == 1;
		else 
			return false;
	}

}

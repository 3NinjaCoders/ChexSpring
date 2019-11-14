package com.chex.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chex.db.UserAuthRepository;
import com.chex.model.UserAuth;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	private UserAuthRepository userAuthRepository;
	
	public UserPrincipalDetailsService(UserAuthRepository userAuthRepository) {
		this.userAuthRepository = userAuthRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		UserAuth user = this.userAuthRepository.findByUsername(s);
		UserAutPrinciple up = new UserAutPrinciple(user);
		return up;
	}
	
}

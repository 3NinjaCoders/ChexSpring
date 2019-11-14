package com.chex.db;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chex.model.UserAuth;

@Service
public class DbInit implements CommandLineRunner {
	private UserAuthRepository userRepository;
	private PasswordEncoder passwordEndcoder;
	
	public DbInit(UserAuthRepository userRepository, PasswordEncoder passwordEndcoder) {
		this.userRepository = userRepository;
		this.passwordEndcoder = passwordEndcoder;
	}

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.deleteAll();
		
		UserAuth pk = new UserAuth(1, "pk", passwordEndcoder.encode("123"), "USER");
		UserAuth admin = new UserAuth(0,"admin", passwordEndcoder.encode("123"), "ADMIN");	
		
		List<UserAuth> users = Arrays.asList(pk, admin);
		
		this.userRepository.saveAll(users);
	}
}

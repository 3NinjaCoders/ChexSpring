package com.chex.db;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chex.model.User;
import com.chex.model.UserAuth;

@Service
public class DbInit implements CommandLineRunner {
	private UserAuthRepository userRepository;
	private PasswordEncoder passwordEndcoder;
	private UserDAO userDAO;
	
	public DbInit(UserAuthRepository userRepository, PasswordEncoder passwordEndcoder, UserDAO userDAO) {
		this.userRepository = userRepository;
		this.passwordEndcoder = passwordEndcoder;
		this.userDAO = userDAO;
	}

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.deleteAll();
		this.userDAO.deleteAll();
		
		UserAuth admin = new UserAuth("admin", passwordEndcoder.encode("123"), "ADMIN");
		UserAuth pk = new UserAuth("p@k", passwordEndcoder.encode("123"), "USER");
			
		
		List<UserAuth> users = Arrays.asList(admin, pk);
		this.userRepository.saveAll(users);
		
		User upk = new User();
		upk.setUserId(pk.getUserId());
		upk.setFirst_name("Piotr");
		upk.setLast_name("Konicki");
		upk.setPublic_name("Piotr Konicki");
		upk.setDate_of_registration(new Date(System.currentTimeMillis()));
		
		this.userDAO.save(upk);
		
		
	}
}

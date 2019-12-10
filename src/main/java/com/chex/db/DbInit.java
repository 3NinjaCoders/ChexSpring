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
		UserAuth ua1 = new UserAuth("p@k", passwordEndcoder.encode("123"), "USER");
		UserAuth ua2 = new UserAuth("a@n", passwordEndcoder.encode("123"), "USER");
		UserAuth ua3 = new UserAuth("z@h", passwordEndcoder.encode("123"), "USER");
		UserAuth ua4 = new UserAuth("k@s", passwordEndcoder.encode("123"), "USER");
			
		
		List<UserAuth> users = Arrays.asList(admin, ua1, ua2, ua3, ua4);
		this.userRepository.saveAll(users);
		
		User uu1 = new User();
		uu1.setUserId(ua1.getUserId());
		uu1.setFirst_name("Piotr");
		uu1.setLast_name("Konicki");
		uu1.setPublic_name("Piotr Konicki");
		uu1.setSex(0);
		uu1.setDate_of_registration(new Date(System.currentTimeMillis()));
		
		User uu2 = new User();
		uu2.setUserId(ua2.getUserId());
		uu2.setFirst_name("Adam");
		uu2.setLast_name("Nowak");
		uu2.setSex(0);
		uu2.setPublic_name(uu2.getFirst_name() + " " + uu2.getLast_name());
		uu2.setDate_of_registration(new Date(System.currentTimeMillis()));
		
		User uu3 = new User();
		uu3.setUserId(ua3.getUserId());
		uu3.setFirst_name("Zuzanna");
		uu3.setLast_name("Harnas");
		uu3.setSex(1);
		uu3.setPublic_name(uu3.getFirst_name() + " " + uu3.getLast_name());
		uu3.setDate_of_registration(new Date(System.currentTimeMillis()));
		
		User uu4 = new User();
		uu4.setUserId(ua4.getUserId());
		uu4.setFirst_name("Katarzyna");
		uu4.setLast_name("Shmit");
		uu4.setSex(1);
		uu4.setPublic_name(uu4.getFirst_name() + " " + uu4.getLast_name());
		uu4.setDate_of_registration(new Date(System.currentTimeMillis()));
		
		this.userDAO.saveAll(Arrays.asList(uu1, uu2, uu3, uu4));
		
		
	}
}

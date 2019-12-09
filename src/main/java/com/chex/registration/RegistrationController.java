package com.chex.registration;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chex.db.MyFriendsDAO;
import com.chex.db.UserAuthRepository;
import com.chex.db.UserDAO;
import com.chex.model.MyFriends;
import com.chex.model.RegistrationModel;
import com.chex.model.User;
import com.chex.model.UserAuth;

@Controller
public class RegistrationController {
	
	@Autowired
	UserAuthRepository userAutreop;
	@Autowired
	UserDAO userDAO;
	@Autowired
	private PasswordEncoder passwordEndcoder;
	@Autowired
	private MyFriendsDAO myFriendsDAO;
	
	@RequestMapping("/registration")
	public ModelAndView registration(RegistrationModel regModel) {
		ModelAndView mv = new ModelAndView();
		RegistrationMessageBuilder messageBuilder = new RegistrationMessageBuilder();
		boolean correct_data = data_is_correct(messageBuilder, regModel);
		String message = messageBuilder.build_message();

		if(!correct_data) {
			mv.addObject("wrong_message", message);
			mv.setViewName("registration");
			return mv;
		}
		
		UserAuth userA = buildUserAuth(regModel);
		userAutreop.save(userA);
		
		User user = buildUser(regModel);
		user.setUserId(userA.getUserId());
		userDAO.save(user);
		
		MyFriends mf = new MyFriends(userA.getUserId(), "");
		
		mv.addObject("info_message", message);
		mv.setViewName("index");
		return mv;
	}
	
	private User buildUser(RegistrationModel regModel) {
		User user = new User();
		user.setFirst_name(regModel.getFirstName());
		user.setLast_name(regModel.getLastName());
		user.setPublic_name(user.getFirst_name() + " " + user.getLast_name());
		int isex = 0;
		if(regModel.getSex().equals("F"))
			isex = 1;
		user.setSex(isex);
		long milis = System.currentTimeMillis();
		Date date_of_reg = new Date(milis);
		
		user.setDate_of_registration(date_of_reg);
		
		Date date_of_birth = new Date(0);
		user.setDate_of_birth(date_of_birth);
		user.setProfil_photo("");
		user.setCity("");
		user.setCountry("");
		user.setExp(0);
		user.setUlevel(1);
		return user;
	}
	
	private UserAuth buildUserAuth(RegistrationModel regModel) {
		UserAuth userA = new UserAuth();
		userA.setPassword(passwordEndcoder.encode(regModel.getPassword()));
		userA.setUsername(regModel.getUsername());
		userA.setRole("USER");
		userA.setActive(0);
		return userA;
	}
	
	private boolean data_is_correct(RegistrationMessageBuilder messageBuilder, RegistrationModel regModel) {
		messageBuilder.check_firstname(regModel.getFirstName());
		messageBuilder.check_lastname(regModel.getLastName());
		messageBuilder.check_login(regModel.getUsername());
		messageBuilder.check_password(regModel.getPassword());
		messageBuilder.check_two_password(regModel.getPassword(), regModel.getPassword2());
		UserAuth u = userAutreop.findByUsername(regModel.getUsername());
		if(u != null)
			messageBuilder.check_isnt_exist(false);
		
		return messageBuilder.data_is_correct();
	}
}

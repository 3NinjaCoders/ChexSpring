package com.chex.user.friends;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chex.db.InvitationDAO;
import com.chex.db.MyFriendsDAO;
import com.chex.db.UserAuthRepository;
import com.chex.db.UserDAO;
import com.chex.model.User;

@Controller
public class SearchController {
	@Autowired 
	private UserAuthRepository userAuthDAO;
	@Autowired
	private InvitationDAO invitationDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private MyFriendsDAO myFriendsDAO;
	
	@GetMapping(value = "/user/searchpeople")
	public String searchPeople(@RequestParam("search") String search, Principal principal, Model model) {
		List<User> findUser = userDAO.findAllContainPublicName(search);
		return "user/friends/showsearched";
	}
}

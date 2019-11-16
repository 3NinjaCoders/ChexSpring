package com.chex.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FriendsController {

	@RequestMapping("/user/friendsC")
	public String displayFriends()
	{
		return "/user/friend.html";
	}
}

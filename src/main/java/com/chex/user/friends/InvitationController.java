package com.chex.user.friends;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chex.db.InvitationDAO;
import com.chex.db.MyFriendsDAO;
import com.chex.db.UserAuthRepository;
import com.chex.model.Invitation;
import com.chex.model.MyFriends;

@Controller
@Transactional
public class InvitationController {

	@Autowired
	private InvitationDAO invitationDAO;
	@Autowired
	private UserAuthRepository userAuthDAO;
	@Autowired
	private MyFriendsDAO myFriendsDAO;
	
	@RequestMapping(value = "/user/friends/sendInv", method = RequestMethod.POST)
	public String sendInvitation(@RequestParam("id") Long id, Principal principal) {
		Long myId = userAuthDAO.findByUsername(principal.getName()).getUserId();
		Invitation inv = new Invitation(myId, id);
		invitationDAO.save(inv);
		return "user/friends/showfriends";
	}
	
	@RequestMapping(value = "/user/firiends/acceptInv")
	public String acceptInvitation(@RequestParam("id") Long id, Principal principal) {
		Long myId = userAuthDAO.findByUsername(principal.getName()).getUserId();
		MyFriends myFriends = myFriendsDAO.findById(myId).orElse(null);
		if(myFriends == null)
			return "user/friends/showfriends";
		myFriends.addFriendId(id);
		myFriendsDAO.save(myFriends);
		
		Invitation inv = invitationDAO.findByUserIdAndInviters(myId, id);
		invitationDAO.delete(inv);
		return "user/friends/showfriends";
	}
	
	@RequestMapping(value = "/user/firiends/rejectInv")
	public String rejecttInvitation(@RequestParam("id") Long id, Principal principal) {
		Long myId = userAuthDAO.findByUsername(principal.getName()).getUserId();		
		Invitation inv = invitationDAO.findByUserIdAndInviters(myId, id);
		invitationDAO.delete(inv);
		return "user/friends/showfriends";
	}
	
	@RequestMapping(value = "/user/firiends/deletetInv")
	public String deletetInvitation(@RequestParam("id") Long id, Principal principal) {
		Long myId = userAuthDAO.findByUsername(principal.getName()).getUserId();		
		Invitation inv = invitationDAO.findByUserIdAndInviters(id, myId);
		invitationDAO.delete(inv);
		return "user/friends/showfriends";
	}
}

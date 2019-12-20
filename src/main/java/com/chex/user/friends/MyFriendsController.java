package com.chex.user.friends;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chex.db.InvitationDAO;
import com.chex.db.MyFriendsDAO;
import com.chex.db.UserAuthRepository;
import com.chex.db.UserDAO;
import com.chex.enums.PersonStatus;
import com.chex.model.Invitation;
import com.chex.model.MyFriends;
import com.chex.model.User;

@Controller
public class MyFriendsController {
	
	@Autowired 
	private UserAuthRepository userAuthDAO;
	@Autowired
	private InvitationDAO invitationDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private MyFriendsDAO myFriendsDAO;
	
	@GetMapping("/user/friend")
	public String userfriend(Principal principal, Model model) {
		long myId = userAuthDAO.findByUsername(principal.getName()).getUserId();
		List<User> invitePerson = getUserList(myId);
		List<MiniPerson> inviteByPersonList = prepareMiniPerosnList(invitePerson);
		
		MyFriends fm =  myFriendsDAO.findById(myId).orElse(new MyFriends());
		List<Long> myFriendsId = fm.toList();
		List<User> myFriendsUsers =  userDAO.findAllById(myFriendsId);
		List<MiniPerson> miniListFriends = pereperMiniPersonListForFriends(myFriendsUsers);
		
		model.addAttribute("miniListFriends", miniListFriends);
		model.addAttribute("inviteByPersonList", inviteByPersonList);
		return "user/friends/showfriends";
	}
	
	@GetMapping(value = "/user/friends/deletetFriend/{id}")
	public String deletetFriend(@PathVariable("id") Long id, Principal principal) {
		Long myId = userAuthDAO.findByUsername(principal.getName()).getUserId();	
		MyFriends mf = myFriendsDAO.findById(myId).orElse(null);
		
		if(mf != null) {
			mf.removeFriend(id);
			myFriendsDAO.save(mf);
		}
		return "redirect:/user/friend";
	}
	
	private List<MiniPerson> pereperMiniPersonListForFriends(List<User> myFriendsUsers){
		if(myFriendsUsers.isEmpty()) return new ArrayList<>();
		List<MiniPerson> list = new ArrayList<>();
		for(User u : myFriendsUsers) {
			MiniPerson mp = new MiniPerson();
			mp.setUser_id(u.getUserId());
			mp.setPhoto(u.getProfil_photo());
			mp.setPublic_name(u.getPublic_name());
			mp.setPersonStatus("IsFriend");
			list.add(mp);
		}
		return list;		
	}
	
	private List<MiniPerson> prepareMiniPerosnList(List<User> invitePerson){
		if(invitePerson.isEmpty()) return new ArrayList<>();
		List<MiniPerson> inviteByPersonList = new ArrayList<>();
		for(User u : invitePerson) {
			MiniPerson miniP = new MiniPerson();
			miniP.setUser_id(u.getUserId());
			miniP.setPhoto(u.getProfil_photo());
			miniP.setPublic_name(u.getPublic_name());
			miniP.setPersonStatus("Invited");
			inviteByPersonList.add(miniP);
		}
		return inviteByPersonList;
	}
	
	private List<User> getUserList(Long myId) {
		List<Invitation> invitation = invitationDAO.findByUserId(myId);
		List<Long> id_list = new ArrayList<>();
		for(Invitation i : invitation)
			id_list.add(i.getInviters());
		List<User> invitePerson = userDAO.findAllById(id_list);
		
		if(invitation == null || invitation.isEmpty())
			return new ArrayList<>();
		
		return invitePerson;
	}
}

package com.chex.user.friends;

import java.security.Principal;
import java.util.ArrayList;
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
import com.chex.enums.PersonStatus;
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
		List<User> foundUsers = userDAO.findAllContainPublicName(search);
		Long myId = userAuthDAO.findByUsername(principal.getName()).getUserId();
		List<MiniPerson> mini_list = getSearchedMiniPersonList(foundUsers, myId);
		
		System.out.println(mini_list);
		model.addAttribute("seach_list", mini_list);
		return "user/friends/showsearched";
	}
	
	private List<MiniPerson> getSearchedMiniPersonList(List<User> foundUsers, Long myId){
		List<MiniPerson> mini_list = new ArrayList<>();

		for(User u : foundUsers) {
			MiniPerson pm = new MiniPerson();
			pm.setUser_id(u.getUserId());
			pm.setPhoto(u.getProfil_photo());
			pm.setPublic_name(u.getPublic_name());
			
			if(invitationDAO.isUserIdAndInviters(myId, u.getUserId())){
				System.out.println(invitationDAO.isUserIdAndInviters(myId, u.getUserId()));
				pm.setPersonStatus("Invited");
			}
			else if(invitationDAO.isUserIdAndInviters(u.getUserId() , myId)){
				System.out.println(invitationDAO.isUserIdAndInviters(u.getUserId() , myId));
				pm.setPersonStatus("IsInvited");
			}
			else if(myFriendsDAO.isMyFriend(myId, Long.toString(u.getUserId()))) {
				pm.setPersonStatus("IsFriend");
			}else {
				pm.setPersonStatus("Unknown");
			}
			
			mini_list.add(pm);
		}
		return mini_list;
	}
}

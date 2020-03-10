package com.chex.myplaces;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chex.db.UserAuthRepository;
import com.chex.db.VisitedPlaceDAO;
import com.chex.model.UserAuth;
import com.chex.model.VisitedPlace;

@Controller
public class MyPlacesController {
	
	@Autowired
	private VisitedPlaceDAO visitedPlaceDAO;
	@Autowired
	private UserAuthRepository userAuthDAO;
	
	@GetMapping(value = "/user/myplaces")
	public String myplaces(Principal principal, Model model) {
		
		UserAuth me = userAuthDAO.findByUsername(principal.getName());
		List<VisitedPlace> vp_list = visitedPlaceDAO.findByUserId(me.getUserId());
		model.addAttribute("visitedList", vp_list);
		
		return "user/places/myplaces";
	}
	
	@GetMapping(value = "/user/place/profil/{id}")
	String dispalyProfil(@PathVariable("id") Long id, Model model) {
		VisitedPlace vp = visitedPlaceDAO.findById(id).orElse(null);
		model.addAttribute("vp", vp);
		return "user/places/placeprofil";
	}

}

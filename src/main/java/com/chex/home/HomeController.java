package com.chex.home;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chex.db.UserAuthRepository;
import com.chex.db.VisitedPlaceDAO;
import com.chex.model.UserAuth;
import com.chex.model.VisitedPlace;

@Controller
public class HomeController {
	
	@Autowired
	private UserAuthRepository userAuthDAO;
	@Autowired
	private VisitedPlaceDAO visitedPlaceDAO; 
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("wrong_message", "");
		mv.addObject("info_message", "");
		return mv;
	}
	
	@GetMapping("/toregistration")
	public String toRegistration() {
		return "registration";
	}
	
	@GetMapping("/recoverpassword")
	public String toRecoverpassword() {
		return "/recoverpassword";
	}
	
	@RequestMapping("/invalidcredential")
	public ModelAndView invalidcredential() {
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("wrong_message", "Niepoprawne dane");
		return mv;
	}
	
   @RequestMapping("/admin/home")
    public String adminhome() {
    	return "admin/home";
    }
   
   @RequestMapping("/user/home")
   public String userhome(Principal principal, Model model) {
	   	Long myId = userAuthDAO.findByUsername(principal.getName()).getUserid();
	   	List<VisitedPlace> lasttwenty =  visitedPlaceDAO.findTopByOrderByPkAsc();
	   	model.addAttribute("vp_list", lasttwenty);
   		return "user/home";
   }
}

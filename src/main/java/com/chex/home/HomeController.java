package com.chex.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "");
		return mv;
	}
	
	@GetMapping("/registration")
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
		mv.addObject("message", "Niepoprawne dane");
		return mv;
	}
	
   @RequestMapping("/admin/home")
    public String adminhome() {
    	return "admin/home";
    }
   
   @RequestMapping("/user/home")
   public String userhome() {
   	return "user/home";
   }
}

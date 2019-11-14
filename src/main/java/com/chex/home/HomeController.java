package com.chex.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
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

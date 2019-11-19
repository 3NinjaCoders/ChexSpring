package com.chex.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PasswordRecoverController {

	@RequestMapping("/recoverPassword")
	public ModelAndView recoverPassword(@RequestParam("username") String email) {
		ModelAndView mv = new ModelAndView("index");
		String message = "Instrukcja zmiany hasała została wysłana na email: " + email;
		mv.addObject("info_message", message);
		return mv;
	}
}

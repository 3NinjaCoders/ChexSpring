package com.chex.myplaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPlacesController {
	
	@GetMapping(value = "/user/myplaces")
	public String myplaces() {
		return "user/places/myplaces";
	}

}

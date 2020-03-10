package com.chex.admin.achievement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewAchievment {

	@GetMapping("/admin/newachivement")
	public String newachievement() {
		return "admin/newachievement";
	}
}

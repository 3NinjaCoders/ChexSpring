package com.chex.myplaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chex.db.PlaceDAO;
import com.chex.model.Place;

@Controller
public class AddPlaceController {
	
	@Autowired
	private PlaceDAO placeDAO;
	
	@GetMapping(value = "/user/addmyplace")
	public String addmyplace() {
		return "user/places/addmyplace";
	}
	
	@GetMapping(value = "/user/addmyplace/country/{id}")
	public String addmyplacecountry(@PathVariable("id") String id, Model model) {
		List<Place> lp = placeDAO.uniqe_countries(id);
		model.addAttribute("lp", lp);
		return "user/places/addmyplacecountry";
	}
	
	@GetMapping(value = "/user/addmyplace/regio/{id}")
	public String addmyplaceregio(@PathVariable("id") String id, Model model) {
		id = id.substring(0, 5);
		System.out.println(id);
		List<Place> lp = placeDAO.uniqe_regions(id);
		System.out.println(lp);
		model.addAttribute("lp", lp);
		return "user/places/addmyplaceregio";
	}
	
	@GetMapping(value = "/user/addmyplace/subregio/{id}")
	public String addmyplacesubregio(@PathVariable("id") String id, Model model) {
		id = id.substring(0, 8);
		System.out.println("addsubreg" + id);
		List<Place> lp = placeDAO.uniqe_subreg(id);
		model.addAttribute("lp", lp);
		return "user/places/addmyplaceplace";
	}
	
	@GetMapping(value = "/user/addmyplace/place/{id}")
	public String addmyplaceplace(@PathVariable("id") String id, Model model) {
		id = id.substring(0, 11);
		System.out.println("addplace " + id);
		List<Place> lp = placeDAO.uniqe_place(id);
		for(Place p : lp) {
			System.out.println(p);
		}
		model.addAttribute("lp", lp);
		return "user/places/addmyplaceplaceplace";
	}
	
	@GetMapping(value = "/user/addmyplace/addplace/{id}")
	public String addmyplaceadd(@PathVariable("id") String placeid, Model model) {
		Place place = placeDAO.findByPlaceid(placeid);
		if(place == null) {
			//TODO
			return "user/places";
		}
		model.addAttribute("place", place);
		System.out.println("add " + placeid);

		return "user/places/addmyplacefill";
	}
}



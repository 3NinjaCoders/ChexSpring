package com.chex.model.admin.newplace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chex.db.CategoryDAO;
import com.chex.db.PlaceDAO;
import com.chex.model.Category;
import com.chex.model.DoubleObject;
import com.chex.model.Place;

@Controller
public class NewPlaceController {

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	PlaceDAO placeDAO;
	
	@RequestMapping("admin/newplace")
	public String selectContinent(Model model) {
		model.addAttribute("id", "00000000000000");
		return "admin/newplace/selectcontinent";
	}
	
	@RequestMapping(value = "admin/newplace/continentsController", method = RequestMethod.POST)
	public String continentsController(@RequestParam("continent") String continent, Model model) {
		List<Place> countr = placeDAO.uniqe_countries(continent);
		List<DoubleObject> countries = new ArrayList<>();
		countries.add(new DoubleObject("NN", "Nowy"));
		for(Place p : countr) {
			countries.add(new DoubleObject(p.getPlaceid(), p.getName()));
		}
		String id = continent + "000000000000";
		model.addAttribute("countries", countries);
		model.addAttribute("id", id);
		return "admin/newplace/selectcountry";
	}
	
	@RequestMapping(value = "admin/newplace/countriesController", method = RequestMethod.POST)
	public String countriesController(PlaceData country,String id, Model model) {
		if("NN".equals(country.getPlace())) {
			List<Category> categories = categoryDAO.findAll();
			DoubleObject place = new DoubleObject();
			String cid = id.substring(0, 2) + country.getId_place() + "000000000";
			place.setId(cid);
			place.setName(country.getNew_place());
			model.addAttribute("place", place);
			model.addAttribute("categories", categories);
			model.addAttribute("id", cid);
			model.addAttribute("path", preparePath(cid));
			model.addAttribute("formPlace", new FormPlace());
			return "admin/newplace/fillplace";
		}
		List<Place> reg = placeDAO.uniqe_regions(country.getPlace().substring(0,5));
		List<DoubleObject> regions = new ArrayList<>();
		regions.add(new DoubleObject("NN", "Nowy"));
		for(Place p : reg) {
			regions.add(new DoubleObject(p.getPlaceid(), p.getName()));
		}
		String newid = country.getPlace().substring(0,5)+ "000000000";
		model.addAttribute("regions", regions);
		model.addAttribute("id", newid);
		return "admin/newplace/selectregion";
	}
	
	@RequestMapping(value = "admin/newplace/regionsController", method = RequestMethod.POST)
	public String regionsController(PlaceData region,String id, Model model) {

		if("NN".equals(region.getPlace())) {
			List<Category> categories = categoryDAO.findAll();
			DoubleObject place = new DoubleObject();
			String cid = id.substring(0, 5) + region.getId_place() + "000000";
			place.setId(cid);
			place.setName(region.getNew_place());
			model.addAttribute("place", place);
			model.addAttribute("categories", categories);
			model.addAttribute("id", cid);
			model.addAttribute("path", preparePath(cid));
			model.addAttribute("formPlace", new FormPlace());
			return "admin/newplace/fillplace";
		}
		List<Place> subreg = placeDAO.uniqe_subreg(region.getPlace().substring(0,8));
		List<DoubleObject> subregions = new ArrayList<>();
		subregions.add(new DoubleObject("NN", "Nowy"));
		for(Place p : subreg) {
			subregions.add(new DoubleObject(p.getPlaceid(), p.getName()));
		}
		String newid = region.getPlace().substring(0,8)+ "000000";
		model.addAttribute("subregions", subregions);
		model.addAttribute("id", newid);
		return "admin/newplace/selectcityprovine";
	}
	
	@RequestMapping(value = "admin/newplace/placeController", method = RequestMethod.POST)
	public String placeController(PlaceData subregion,String id, Model model) {
		FormPlace formplace = new FormPlace();
		if("NN".equals(subregion.getPlace())) {
			List<Category> categories = categoryDAO.findAll();
			DoubleObject place = new DoubleObject();
			String cid = id.substring(0, 8) + subregion.getId_place() + "000";
			place.setId(cid);
			place.setName(subregion.getNew_place());
			model.addAttribute("place", place);
			model.addAttribute("categories", categories);
			model.addAttribute("id", cid);
			model.addAttribute("path", preparePath(cid));
			model.addAttribute("formPlace", formplace);
			return "admin/newplace/fillplace";
		}
		String sid = subregion.getPlace().substring(0,11);
		List<Category> categories = categoryDAO.findAll();
		String newid = generateID(sid);
		System.out.println("--> " + newid);
		
		model.addAttribute("id", newid);
		model.addAttribute("categories", categories);
		model.addAttribute("path", preparePath(sid + "000"));
		model.addAttribute("formPlace", formplace);
		return "admin/newplace/fillplace";
	}
	
	private String preparePath(String id) {
		Place continent = placeDAO.findByPlaceid(id.substring(0,2) + "000000000000");
		Place country = placeDAO.findByPlaceid(id.substring(0,5) + "000000000");
		Place region = placeDAO.findByPlaceid(id.substring(0,8) + "000000");
		Place subregion = placeDAO.findByPlaceid(id);
		
		String path = continent.getName();
		
		if(country == null) {
			return path;
		}else {
			path += " -> " + country.getName();
		}
		
		if(region == null) {
			return path;
		}else {
			path += " -> " + region.getName();
		}
		
		if(subregion == null) {
			return path;
		}else {
			path += " -> " + subregion.getName();
		}

		return path;
	}
	
	private String generateID(String id) {
		Random rand = new Random();
		String sid = "";
		do {
			int nid = rand.nextInt(999)+1;
			sid = Integer.toString(nid);
			sid = id + sid;
			System.out.println(sid);
		}while(placeDAO.existsByPlaceid(sid));
		return sid;
	}
	
	@RequestMapping(value = "admin/newplace/addplace", method = RequestMethod.POST)
	public ModelAndView addplaceController(@RequestParam("place_photo") MultipartFile photo, 
											FormPlace formplace,
											String id, 
											Model model, 
											BindingResult errors, 
											HttpServletRequest request) {
		System.out.println(formplace);
		ModelAndView mv = new ModelAndView();
		new NewPlaceValidator().validate(formplace, errors);
		
		if(placeDAO.existsByPlaceid(formplace.getPlaceid())) {
			errors.rejectValue("placeid", "addnewplace.validation.id.exist");
		}
		
		if(errors.hasErrors()) {
			System.out.println("są errory");
			mv.addObject("formPlace", formplace);
			mv.setViewName("admin/newplace/fillplace");
			return mv;
		}
		
		Place place = fillPlace(formplace);
		try {
			uploadPlace_photo(photo, place, request);
		} catch (IllegalStateException | IOException e) {
			place.setPhoto_url("");
		}
		
		placeDAO.save(place);
		mv.setViewName("admin/newplace/summary");
		mv.addObject("place", place);
		return mv;
	}
	
	private Place fillPlace(FormPlace fp) {
		System.out.println(fp);
		Place place = new Place();
		place.setPlaceid(fp.getPlaceid());
		place.setName(fp.getName());
		place.setX(Double.parseDouble(fp.getX()));
		place.setY(Double.parseDouble(fp.getY()));
		place.setDescription(fp.getDescription());
		place.setPhoto_url(fp.getPhoto_url());
		place.setCategory(fp.getCategory());
		place.setPoints(Integer.parseInt(fp.getPoints()));
		place.setNumpositive(0);
		place.setNumvote(0);
		System.out.println(place);
		return place;
	}
	
	private void uploadPlace_photo(MultipartFile photo, Place place, HttpServletRequest request ) throws IllegalStateException, IOException {
		if(photo.isEmpty()) return;
		Path currentPath = Paths.get(".");

		String orginalname = StringUtils.cleanPath(photo.getOriginalFilename());
		String p = "/uploadfiles/placephoto/";

		Path absolutePath = currentPath.toAbsolutePath();
		String path1 = absolutePath + "/src/main/resources/static/uploadfiles/placephoto/"+ place.getPlaceid() + "." + orginalname.substring(orginalname.length()-3, orginalname.length());
		//byte[] bytes = photo.getBytes();
		Path path = Paths.get(path1);
		//Files.write(path, bytes);
		
		
		try {
			Files.copy(photo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		place.setPhoto_url(p + photo.getOriginalFilename());
	}
	
//	
//	@RequestMapping("admin/newplace/country")
//	public String counties(@RequestParam("continent") String continent) {
//		ModelAndView mv = new ModelAndView("admin/new_place");
//		mv.addObject("level", "b");
//		List<Place> places =placeDAO.uniqe_countries(continent);
//		List<DoubleObject> countries = new ArrayList<>();
//		countries.add(new DoubleObject("NN", "Nowy"));
//		for(Place p: places) {
//			countries.add(new DoubleObject(p.getPlace_id(), p.getName()));
//		}
//		mv.addObject("countries_list",countries);
//		String id = continent + "000000000000";
//		mv.addObject("id", id);
//		return mv;
//		
//	}
//	
//	@RequestMapping(value = "/admin/newplace/toregion", method=RequestMethod.GET)
//	@ResponseBody
//	public ModelAndView toregion(PlaceData country,String id) {
//		System.out.println(country);
//		System.err.println("id: "+ id);
//		ModelAndView mv = new ModelAndView("admin/new_place");
//		if(country.getCountry().equals("NN")) {
//			List<Category> categories = categoryDAO.findAll();
//			Place place = new Place();
//			String cid = id.substring(0, 2) + country.getId_country() + "000000000";
//			place.setPlace_id(cid);
//			place.setName(country.getNew_country());
//			mv.addObject("place", place);
//			mv.addObject("level", "c2");
//			mv.addObject("categories", categories);
//			return mv;
//		}
//		System.out.println(country.getCountry());
//		mv.addObject("level", "c1");
//		String c = country.getCountry().substring(0, 5);
//		System.out.println(">>>" + c);
//		List<Place> regions = placeDAO.uniqe_regions(c);
//		List<DoubleObject> reg = new ArrayList<>();
//		reg.add(new DoubleObject("NN", "Nowy"));
//		for(Place r : regions) {
//			reg.add(new DoubleObject(r.getPlace_id(), r.getName()));
//		}
//		mv.addObject("regions", reg);
//		mv.addObject("id", id);
//		return mv;		
//	}
//	
//	@RequestMapping(value = "/admin/newplace/regioncont", method=RequestMethod.GET)
//	public ModelAndView regioncont(PlaceData regio,String id) {
//		System.out.println("regioncont");
//		System.out.println(regio);
//		System.out.println(id);
//		ModelAndView mv = new ModelAndView("admin/new_place");
//		if(regio.getCountry().equals("NN")) {
//			List<Category> categories = categoryDAO.findAll();
//			Place place = new Place();
//			String cid = id.substring(0, 8) + regio.getId_country() + "000000";
//			place.setPlace_id(cid);
//			place.setName(regio.getNew_country());
//			mv.addObject("place", place);
//			mv.addObject("level", "c2");
//			mv.addObject("categories", categories);
//			return mv;
//		}
//		System.out.println(regio.getCountry());
//		mv.addObject("level", "d");
//		String c = regio.getCountry().substring(0, 8);
//		System.out.println( "tu ->"  + c);
//		List<Place> places = placeDAO.uniqe_subreg(c);
//		List<DoubleObject> reg = new ArrayList<>();
//		reg.add(new DoubleObject("NN", "Nowy"));
//		for(Place r : places) {
//			reg.add(new DoubleObject(r.getPlace_id(), r.getName()));
//		}
//		mv.addObject("places", reg);
//		return mv;
//	}
//	
//	@RequestMapping(value = "/admin/newplace/toplace", method=RequestMethod.GET)
//	public ModelAndView toplace(PlaceData p,String id) {
//		System.out.println("regioncont");
//		System.out.println(p);
//		ModelAndView mv = new ModelAndView("admin/new_place");
//		mv.addObject("level", "c2");
//		List<Category> categories = categoryDAO.findAll();
//		
//		Place place = new Place();
//		
//		if(p.getCountry().equals("NN")) {
//			place.setName(p.getNew_country());
//			place.setPlace_id(id + p.getId_country()+ "000");
//		}else {
//			place.setPlace_id(p.getCountry());
//			place.setName("-");
//		}
//		
//		mv.addObject("place", place);
//		mv.addObject("categories", categories);
//		return mv;
//
//	}
}

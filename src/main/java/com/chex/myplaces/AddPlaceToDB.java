package com.chex.myplaces;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chex.db.AlbumDAO;
import com.chex.db.PlaceDAO;
import com.chex.db.UserAuthRepository;
import com.chex.model.Place;

@Controller
public class AddPlaceToDB {
	
	@Autowired
	private PlaceDAO placeDAO;
	@Autowired
	private UserAuthRepository userAuthDAO;
	@Autowired
	private AlbumDAO albumDAO;

	@PostMapping(value = "/user/addmyplace/addtodb")
	public String addnewplacetodb(@RequestParam("description") String description,
			@RequestParam("id") String id,
			@RequestParam("photos") MultipartFile[] uploadingFiles,
			Principal principal
			) {
		
		Long myId = userAuthDAO.findByUsername(principal.getName()).getUserId();
		uploadPhotos(uploadingFiles, myId);
		
		
		Place place = placeDAO.findById(id).orElse(null);
		
		if(place == null) {
			//TODO
		}
		
		
		return "redirect:/user/addmyplace";
	}
	
	private void uploadPhotos(MultipartFile[] photos, Long userId) {
		if(photos[0].isEmpty()) return;
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		
		String p = "/uploadfiles/useralbums";
		Long albumId = genereateUniqeAlbumId(userId);
		
		List<String> namelist = new ArrayList<>();
		List<String> pathlist = new ArrayList<>();
		int counter = 0;
		for(MultipartFile mf : photos) {
			
			String newpath = absolutePath + "/src/main/resources/static/uploadfiles/useralbums/" + userId + "_" + albumId + "_" + counter++;
			System.out.println(newpath);
			pathlist.add(newpath);
			namelist.add(StringUtils.cleanPath(mf.getOriginalFilename().substring(mf.getOriginalFilename().length()-3)));

			
		}
		String orginalName = StringUtils.cleanPath(photos[0].getOriginalFilename());
		System.out.println(orginalName);
		

//		try {
//			Files.copy(photo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	private Long genereateUniqeAlbumId(Long user_id) {
		Random rand = new Random();
		Long id = rand.nextLong();
		while(albumDAO.isAlbumForUserExist(user_id, id)) {
			id = rand.nextLong();
		}
		return id;
	}
}

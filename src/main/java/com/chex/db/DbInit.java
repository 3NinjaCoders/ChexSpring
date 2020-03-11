package com.chex.db;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chex.model.Invitation;
import com.chex.model.MyFriends;
import com.chex.model.Place;
import com.chex.model.User;
import com.chex.model.UserAuth;
import com.chex.model.VisitedPlace;

@Service
public class DbInit implements CommandLineRunner {
	private UserAuthRepository userRepository;
	private PasswordEncoder passwordEndcoder;
	private UserDAO userDAO;
	private InvitationDAO invitationDAO;
	private MyFriendsDAO myFriendDAO;
	private PlaceDAO placeDAO;
	@Autowired
	private VisitedPlaceDAO visitedplaceDAO;
	
	
	public DbInit(UserAuthRepository userRepository, PasswordEncoder passwordEndcoder, UserDAO userDAO,
			InvitationDAO invitationDAO, MyFriendsDAO myFriendDAO, PlaceDAO placeDAO) {
		super();
		this.userRepository = userRepository;
		this.passwordEndcoder = passwordEndcoder;
		this.userDAO = userDAO;
		this.invitationDAO = invitationDAO;
		this.myFriendDAO = myFriendDAO;
		this.placeDAO = placeDAO;
	}


	@Override
	public void run(String... args) throws Exception {
		this.userRepository.deleteAll();
		this.userDAO.deleteAll();
		this.invitationDAO.deleteAll();
		this.myFriendDAO.deleteAll();
		this.placeDAO.deleteAll();
		this.visitedplaceDAO.deleteAll();
		
		Place cont1 = new Place("EU000000000000", "Europa", 4, 5, "", "Europa",0,	0, 10, "continent");
		Place cont2 = new Place("AN000000000000", "Ameryka Pd", 4, 5, "", "Ameryka Pd",0,	0, 10, "continent");
		Place cont3 = new Place("AS000000000000", "Ameryka Pł", 4, 5, "", "Ameryka Pł",0,	0, 10, "continent");
		Place cont4 = new Place("AZ000000000000", "Azia", 4, 5, "", "Azia",0,	0, 10, "continent");
		
		Place c1 = new Place("EU0PL000000000", "Polska", 4, 5, "", "Polska",0,	0, 10, "country");
		Place c2 = new Place("EUGER000000000", "Niemcy", 4, 5, "", "Niemcy",0,	0, 10, "country");
		
		Place r1 = new Place("EU0PLDLS000000", "Dolnysląski", 4, 5, "", "Dolnysląski",0,	0, 10, "region");
		Place r2 = new Place("EU0PLMAP000000", "Małopolskie", 4, 5, "", "Małopolskie",0,	0, 10, "region");
		
		Place sr1 = new Place("EU0PLDLSREG000", "Region", 4, 5, "", "Region",0,	0, 10, "reg");
		Place sr2 = new Place("EU0PLDLSWRO000", "Wrocław", 4, 5, "", "Wrocław",0,	0, 10, "city");
		
		Place p1 = new Place("EU0PLDLSWRO001", "rynek", 4, 5, "", "Rynek wrocławski",0,	0, 10, "zabytek");
		Place p2 = new Place("EU0PLDLS000001", "Śnieżka", 10, 34, "", "Śniezka śnieżka",0,	0, 10, "szczyt");
		this.placeDAO.saveAll(Arrays.asList(cont1,cont2,cont3,cont4, c1, c2, p1, p2, r1, r2, sr1, sr2));
		
		UserAuth admin = new UserAuth("admin", passwordEndcoder.encode("123"), "ADMIN");
		UserAuth ua1 = new UserAuth("p@k", passwordEndcoder.encode("123"), "USER");
		UserAuth ua2 = new UserAuth("a@n", passwordEndcoder.encode("123"), "USER");
		UserAuth ua3 = new UserAuth("z@h", passwordEndcoder.encode("123"), "USER");
		UserAuth ua4 = new UserAuth("k@s", passwordEndcoder.encode("123"), "USER");
			
		
		List<UserAuth> users = Arrays.asList(admin, ua1, ua2, ua3, ua4);
		this.userRepository.saveAll(users);
		
		User uu1 = new User();
		uu1.setUserid(ua1.getUserid());
		uu1.setFirstname("Piotr");
		uu1.setLastname("Konicki");
		uu1.setPublicname("Piotr Konicki");
		uu1.setSex(0);
		uu1.setDateofregistration(new Date(System.currentTimeMillis()));
		
		User uu2 = new User();
		uu2.setUserid(ua2.getUserid());
		uu2.setFirstname("Adam");
		uu2.setLastname("Nowak");
		uu2.setSex(0);
		uu2.setPublicname(uu2.getFirstname() + " " + uu2.getLastname());
		uu2.setDateofregistration(new Date(System.currentTimeMillis()));
		
		User uu3 = new User();
		uu3.setUserid(ua3.getUserid());
		uu3.setFirstname("Zuzanna");
		uu3.setLastname("Harnas");
		uu3.setSex(1);
		uu3.setPublicname(uu3.getFirstname() + " " + uu3.getLastname());
		uu3.setDateofregistration(new Date(System.currentTimeMillis()));
		
		User uu4 = new User();
		uu4.setUserid(ua4.getUserid());
		uu4.setFirstname("Katarzyna");
		uu4.setLastname("Shmit");
		uu4.setSex(1);
		uu4.setPublicname(uu4.getFirstname() + " " + uu4.getLastname());
		uu4.setDateofregistration(new Date(System.currentTimeMillis()));
		
		Invitation i1 = new Invitation(ua1.getUserid(), ua3.getUserid());
		Invitation i2 = new Invitation(ua1.getUserid(), ua2.getUserid());
		this.invitationDAO.saveAll(Arrays.asList(i1, i2));
		
		String fid4 = Long.toString(ua4.getUserid());
		String fid1 = Long.toString(ua1.getUserid());
		MyFriends mf1 = new MyFriends(uu1.getUserid(), fid4);
		MyFriends mf2 = new MyFriends(uu2.getUserid(), "");
		MyFriends mf3 = new MyFriends(uu3.getUserid(), "");
		MyFriends mf4 = new MyFriends(uu4.getUserid(), fid1);
		this.myFriendDAO.saveAll(Arrays.asList(mf1, mf2, mf3, mf4));
		
		this.userDAO.saveAll(Arrays.asList(uu1, uu2, uu3, uu4));
		
		VisitedPlace vp1 = new VisitedPlace();
		vp1.setUserid(uu1.getUserid());
		vp1.setPlacename("Rynek");
		vp1.setPlaceid(p1.getPlaceid());
		vp1.setDescription("Bla bla");
		this.visitedplaceDAO.save(vp1);
		
	}
}

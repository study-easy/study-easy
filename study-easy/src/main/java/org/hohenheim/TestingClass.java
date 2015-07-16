package org.hohenheim;

import java.util.List;

import dao.RegUserDAOImpl;
import service.RegUserServiceImpl;
import users.RegUser;

public class TestingClass {

	public static void main(String[] args) {
		
		RegUser user = new RegUser();
		user.setName("testHugo");
		user.setPassword("12345");
		user.setEmail("no@lol.de");
		RegUserDAOImpl userServ = new RegUserDAOImpl();
		userServ.addRegUser(user);
		for(RegUser testuser : userServ.listRegUsers())
			System.out.println(testuser.getName());
		
	}

}

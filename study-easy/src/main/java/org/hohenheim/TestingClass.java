package org.hohenheim;

import java.util.List;

import dao.RegUserDAOImpl;
import users.RegUser;

public class TestingClass {

	public static void main(String[] args) {
		
		RegUserDAOImpl regUserDao = new RegUserDAOImpl();
		regUserDao.addRegUser("testHugo", "123", "nonono@nono.de");
		List<RegUser> list = regUserDao.listRegUsers();
		for(RegUser user : list)
			System.out.println(user.getName());
		
	}

}

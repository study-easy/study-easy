package Users;

import java.util.List;

import System.System;

public class RegUser extends User {

	String school;
	String hobby;
	int xpPoints;
	int level;
	String[] quotes;

	public static void register(String password, String testPassword, String name) {
		List<User> userlist = System.getSystem().getUserList();
		boolean nameOccupied = false;
		for (User user : userlist) {
			if (user.name == name)
				nameOccupied = true;
		}
		
		if (nameOccupied = false) {
			if (password == testPassword) {
				RegUser regUser = new RegUser();
				regUser.name = name;
				regUser.password = password;
				System.getSystem().getUserList().add(regUser);
			}
		}
	}

}

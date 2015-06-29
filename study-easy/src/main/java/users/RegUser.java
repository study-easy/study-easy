package users;

import java.util.Date;
import java.util.List;

import system.System;

public class RegUser extends User {

	String school;
	String hobby;
	int xpPoints;
	int level;
	String[] quotes;
	Date birthDate;
	boolean banned;

	public static void register(String password, String testPassword, String name) {
		List<RegUser> userlist = System.getSystem().getUserList();
		boolean nameOccupied = false;
		for (User user : userlist) {
			if (user.name == name)
				nameOccupied = true;
		}
		
		if (nameOccupied == false) {
			if (password == testPassword) {
				RegUser regUser = new RegUser();
				regUser.name = name;
				regUser.password = password;
				regUser.banned = false;
				System.getSystem().getUserList().add(regUser);
			}
		}
	}

	public int getXpPoints() {
		return xpPoints;
	}

	public void setXpPoints(int xpPoints) {
		this.xpPoints = xpPoints;
	}

	public int getLevel() {
		return level;
	}

}

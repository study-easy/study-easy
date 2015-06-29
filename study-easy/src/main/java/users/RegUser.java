package Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import shareAttributes.Badge;
import System.System;


public class RegUser extends User {

	String school;
	String hobby;
	int xpPoints;
	int level;
	String[] quotes;
	Date birthDate;
	boolean banned;
	List<Badge> earnedBadges;

	public boolean register(String password, String testPassword, String name) {
		RegUser regUser = null;
		List<RegUser> userlist = System.getSystem().getUserList();
		boolean nameOccupied = false;
		for (User user : userlist) {
			if (user.name == name) {
				nameOccupied = true;
			}
		}

		if (nameOccupied == false) {
			if (password == testPassword) {
				regUser = new RegUser();
				regUser.name = name;
				regUser.password = password;
				regUser.banned = false;
				regUser.earnedBadges = new ArrayList<Badge>();
				System.getSystem().getUserList().add(regUser);
				
			}
		}
		if(regUser != null)
			return true;
		else
			return false;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
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

	public void setLevel(int level) {
		this.level = level;
	}

	public String[] getQuotes() {
		return quotes;
	}

	public void setQuotes(String[] quotes) {
		this.quotes = quotes;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int year, int month, int day) {

	}

	public List<Badge> getEarnedBadges() {
		return earnedBadges;
	}

}

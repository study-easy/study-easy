package users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import sharedAttributes.Badge;
import sharedAttributes.UserPinn;
import system.Controller;

@Entity@Table(name = "RegUser")
public class RegUser extends User {

	@Column(name = "school")
	private String school;
	@Column(name = "hobby")
	private String hobby;
	@Column(name = "xpPoints")
	private int xpPoints;
	@Column(name = "level")
	private int level;
	@Column(name = "quotes")
	private String[] quotes;
	@Column(name = "banned")
	private boolean banned;
	@Column(name = "earnedBadges")
	private List<Badge> earnedBadges;
	private UserPinn pinn;

	public static RegUser register(String name, String password, String testPassword) {
		boolean nameOccupied = false;
		for (User user : Controller.getSystem().getUserList()) {
			if (user.name == name) {
				nameOccupied = true;
			}
		}
		for (User user : Controller.getSystem().getAdminList()) {
			if (user.name == name) {
				nameOccupied = true;
			}
		}

		if (nameOccupied) {
			return null;
		}else if (password == testPassword) {
				RegUser regUser = new RegUser(name, password);
				UserPinn pinn = new UserPinn();
				pinn.setOwner(regUser);
				regUser.pinn = pinn;
				Controller.getSystem().getUserList().add(regUser);
				return regUser;
			}else{
				return null;
		}		
	}
	
	public RegUser(){};
	
	public RegUser(String name, String password){
		this.name = name;
		this.password = password;
		this.banned = false;
		this.earnedBadges = new ArrayList<Badge>();
		this.registeredSince = new Date();
		this.level = 0;
		this.xpPoints = 0;
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

	public List<Badge> getEarnedBadges() {
		return earnedBadges;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	
	public UserPinn getPinn(){
		return this.pinn;
	}

}

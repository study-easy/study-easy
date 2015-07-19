package users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import service.RegUserServiceImpl;
import sharedAttributes.Badge;
import sharedAttributes.UserPinn;
import system.Controller;

@Entity
public class RegUser extends User {

	
	private String school;
	
	private String hobby;
	@NotNull
	private int xpPoints;
	@NotNull
	private int level;
	private String[] quotes;
	private Date birthDate;
	@NotNull
	private boolean banned;
	@OneToMany
	private List<Badge> earnedBadges;
	private UserPinn pinn;

	public boolean register(String password, String testPassword, String name) {
		List<RegUser> userlist = Controller.getSystem().getUserList();
		boolean nameOccupied = false;
		for (User user : userlist) {
			if (user.name == name)
				nameOccupied = true;
		}
		if (nameOccupied == true) {
			return false;
		}else if (password.equals(testPassword)) {
				RegUser regUser = new RegUser();
				regUser.name = name;
				regUser.password = password;
				regUser.banned = false;
				regUser.earnedBadges = new ArrayList<Badge>();
				regUser.registeredSince = new Date();
				UserPinn pinn = new UserPinn();
				pinn.setOwner(regUser.name);
				regUser.pinn = pinn;
				Controller.getSystem().getUserList().add(regUser);
				return true;
			}else{
				return false;
		}		
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
		RegUserServiceImpl RUS = new RegUserServiceImpl();
		RUS.updateRegUserSchool(this.name, this.school);
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
		RegUserServiceImpl RUS = new RegUserServiceImpl();
		RUS.updateRegUserHobby(this.name, this.hobby);
	}

	public int getXpPoints() {
		return xpPoints;
	}

	public void setXpPoints(int xpPoints) {
		this.xpPoints = xpPoints;
		RegUserServiceImpl RUS = new RegUserServiceImpl();
		RUS.updateRegUserXP(this.name, this.xpPoints);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
		RegUserServiceImpl RUS = new RegUserServiceImpl();
		//TODO dao/service um Methode erweitern
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

	public boolean isBanned() {
		return banned;
	}

	public void addBadges(Badge badges) {
		this.earnedBadges.add(badges);
		RegUserServiceImpl RUS = new RegUserServiceImpl();
		//TODO dao/service um Methode erweitern
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
		RegUserServiceImpl RUS = new RegUserServiceImpl();
		//TODO dao/service um Methode erweitern
	}

	public UserPinn getPinn() {
		return this.pinn;
	}

}

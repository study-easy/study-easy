package study_easy.users;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import study_easy.service.RegUserServiceImpl;
import study_easy.sharedAttributes.Badge;
import study_easy.sharedAttributes.UserPinn;
import study_easy.system.Controller;

@Entity
@Table(name = "RegUser")
public class RegUser extends User {

	@Column
	private String school;
	@Column
	private String hobby;
	@NotNull
	@Column
	private int xpPoints;
	@NotNull
	@Column
	private int level;
	@ElementCollection
	private Set<String> quotes = new HashSet<String>();
	@Column
	private Date birthDate;
	@NotNull
	@Column
	private boolean banned;
	@ElementCollection
	private Set<Badge> earnedBadges;
	@OneToOne
	private UserPinn pinn;
	@ElementCollection
	public Set<String> groups = new HashSet<String>();

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
				regUser.earnedBadges = new HashSet<Badge>();
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
	
	public Set<String> getGroups(){
		return this.groups;
	}
	
	public void addGroup(String name){
		this.groups.add(name);
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

	public Set<String> getQuotes() {
		return quotes;
	}

	public void addQuotes(String quotes) {
		this.quotes.add(quotes);
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int year, int month, int day) {

	}

	public Set<Badge> getEarnedBadges() {
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

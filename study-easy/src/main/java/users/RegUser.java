package users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import sharedAttributes.Badge;
import sharedAttributes.UserPinn;
import system.Controller;

@Entity
public class RegUser extends User {
	@NotNull
	private String school;
	@NotNull
	private String hobby;
	@NotNull
	private int xpPoints;
	@NotNull
	private int level;

	private String[] quotes;
	@NotNull
	private Date birthDate;
	@NotNull
	private boolean banned;
	private List<Badge> earnedBadges;
	private UserPinn pinn;
	private String problem;
	private String problemort;

	public boolean register(String password, String testPassword, String name) {
		List<RegUser> userlist = Controller.getSystem().getUserList();
		boolean nameOccupied = false;
		for (User user : userlist) {
			if (user.name == name) {
				nameOccupied = true;
			}
		}

		if (nameOccupied == true) {
			return false;
		}else if (password.equals(testPassword)) {
			System.out.println("REJJJJ");
				RegUser regUser = new RegUser();
				regUser.name = name;
				regUser.password = password;
				regUser.banned = false;
				regUser.earnedBadges = new ArrayList<Badge>();
				regUser.registeredSince = new Date();
				UserPinn pinn = new UserPinn();
				pinn.setOwner(regUser);
				regUser.pinn = pinn;
				Controller.getSystem().getUserList().add(regUser);
				return true;
			}else{
				System.out.println("RENNNNN");
				return false;
		}		
	}

	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getProblemort() {
		return problem;
	}
	public void setProblemort(String problemort) {
		this.problemort = problemort;
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

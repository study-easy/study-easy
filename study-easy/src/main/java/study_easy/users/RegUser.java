package study_easy.users;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
<<<<<<< HEAD
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.RegUserServiceImpl;
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
import study_easy.sharedAttributes.Badge;
import study_easy.sharedAttributes.UserPinn;

@Entity
@Table(name = "RegUser")
@Component
public class RegUser extends User {

	@Column
	private String school;
	@Column
	private String hobby;
	@Column
	private int xpPoints;
	@Column
	private int level;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> quotes = new HashSet<String>();
	@Column
	private Date birthDate;
	@Column
	private boolean banned;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Badge> earnedBadges = new HashSet<Badge>();
	@OneToOne(fetch = FetchType.EAGER)
	private UserPinn pinn;
	@ElementCollection(fetch = FetchType.EAGER)
	public Set<String> groups = new HashSet<String>();
	@Autowired
	private static RegUserServiceImpl RUS;
	

	

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
<<<<<<< HEAD
		RUS.updateRegUserSchool(this.name, this.school);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
<<<<<<< HEAD
		RUS.updateRegUserHobby(this.name, this.hobby);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public int getXpPoints() {
		return xpPoints;
	}

	public void setXpPoints(int xpPoints) {
		this.xpPoints = xpPoints;
<<<<<<< HEAD
		RUS.updateRegUserXP(this.name, this.xpPoints);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
<<<<<<< HEAD
		//TODO dao/service um Methode erweitern
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
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
<<<<<<< HEAD
		//TODO dao/service um Methode erweitern
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
<<<<<<< HEAD
		//TODO dao/service um Methode erweitern
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public UserPinn getPinn() {
		return this.pinn;
	}
	
	public void setPinn(UserPinn pinn){
		this.pinn = pinn;
	}

}

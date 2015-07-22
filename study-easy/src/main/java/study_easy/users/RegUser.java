package study_easy.users;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import study_easy.sharedAttributes.Badge;
import study_easy.sharedAttributes.UserPinn;

@Entity
@Table(name = "RegUser")
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
	@Embedded
	private UserPinn pinn;
	@ElementCollection(fetch = FetchType.EAGER)
	public Set<String> groups = new HashSet<String>();

	

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
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public UserPinn getPinn() {
		return this.pinn;
	}
	
	public void setPinn(UserPinn pinn){
		this.pinn = pinn;
	}

}

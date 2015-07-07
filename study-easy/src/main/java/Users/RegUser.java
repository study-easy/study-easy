package Users;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import SharedAttributes.Badge;
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
	/*
	 *  ###### Gehört zur Post Methode der index.html ####
	 *  Referenzen auf andere Dateien src/main/java/org.hohenheim/GrettingController.java
	 *  src/main/webapp/web-inf/templates/index.html
	 */
	@Size(min=2, max=30)
	public
	String name;
	
	@NotNull
    @Min(18)
    Integer age;
	@Size(min=4, max=10)
	String passwordcheck;
	@AssertTrue
	Boolean check;
	public Boolean getCheck() {
        return this.check;
    }
	@NotNull
	String sicherheitsfrage;
	
	public String getSicherheitsfrage() {
        return this.sicherheitsfrage;
    }

    public void setSicherheitsfrage(String sicherheitsfrage) {
        this.name = sicherheitsfrage;
    }
    public void setCheck(Boolean check) {
        this.check = check;
    }
	public String getPasswordcheck() {
        return this.passwordcheck;
    }

    public void setPasswordcheck(String passwortcheck) {
        this.name = passwortcheck;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //public String toString() {
    //    return "Person(Name: " + this.name + ", Age: " + this.age + ")";
   // }

    /*
	 *  ###### bis hier ####
	 *  die Nachfolgenden Mehtoden sind ausgekommeniert weil sie schon vorher da waren und nicht mit dieser Post
	 *  Methode in berührung kommen
	 */
	
	
/*
 * 
 
	
	
	
	
	
	

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
*/
	public List<Badge> getEarnedBadges() {
		return earnedBadges;
	}

}

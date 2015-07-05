package groupFunctions;

import java.util.ArrayList;

import javax.persistence.Entity;

import sharedAttributes.Achievement;
import sharedAttributes.GroupPinn;
import users.RegUser;

@Entity 
public class Group {
	
	private String name;
	private ArrayList<RegUser> userList = new ArrayList<RegUser>();
	private String description;
	private RegUser admin;
	//private GroupDataBase dataBase;
	private int wins;
	private int losses;
	private float winToLoss;
	private int winStreak;
	private ArrayList<Combat> currentCombats = new ArrayList<Combat>();
	private GroupPinn pinnwall;
	private ArrayList<Achievement> achievements = new ArrayList<Achievement>();
	
	public void addUser(RegUser user) {
		userList.add(user);
	}
	
	public ArrayList<Combat> getCurrentCombats() {
		return currentCombats;
	}

	public void reasignAdmin() {
		//ToDo1
	}
	
	public void startChallenge() {
		//ToDo2
	}
	
	public void finishCombat() {
		//ToDo3
	}
	
	public void startCombat() {
		//ToDo4
	}
	
	public float getWinToLoss(){
		return winToLoss;
	}

}

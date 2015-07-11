package groupFunctions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


import sharedAttributes.Achievement;
import sharedAttributes.GroupPinn;
import users.RegUser;

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
	private ArrayList<String> combatNotifications = new ArrayList<String>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<RegUser> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<RegUser> userList) {
		this.userList = userList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RegUser getAdmin() {
		return admin;
	}

	public void setAdmin(RegUser admin) {
		this.admin = admin;
	}

	public GroupPinn getPinnwall() {
		return pinnwall;
	}

	public void setPinnwall(GroupPinn pinnwall) {
		this.pinnwall = pinnwall;
	}

	public ArrayList<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(ArrayList<Achievement> achievements) {
		this.achievements = achievements;
	}

	public ArrayList<String> getCombatNotifications() {
		return combatNotifications;
	}

	public void setCombatNotifications(ArrayList<String> combatNotifications) {
		this.combatNotifications = combatNotifications;
	}

	public void setCurrentCombats(ArrayList<Combat> currentCombats) {
		this.currentCombats = currentCombats;
	}

	public void addUser(RegUser user) {
		userList.add(user);
	}
	
	public int getWinStreak() {
		return winStreak;
	}

	public void setWinStreak(int winStreak) {
		this.winStreak = winStreak;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public void setWinToLoss(float winToLoss) {
		this.winToLoss = winToLoss;
	}

	public void reasignAdmin(String name) {
		for(RegUser user : this.userList)
			if(user.getName() == name){
				this.admin = user;
				break;
			}
	}
	
	public void startChallenge() {
		//ToDo2
	}
	
	public void finishCombat(Combat combat) {
		//ToDo3
	}
	
	public void startCombat() {
		//ToDo4
	}
	
	public float getWinToLoss(){
		return winToLoss;
	}
	
	public ArrayList<Combat> getCurrentCombats(){
		return this.currentCombats;
	}
	
	public void copyFile(String sourcePath, String destPath) throws Exception{
				
		Path source = Paths.get(sourcePath);
		Path destination = Paths.get(destPath);
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
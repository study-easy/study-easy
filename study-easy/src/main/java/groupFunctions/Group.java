package groupFunctions;

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
	
	public void startChallenge(Group opponent, Group corrector) {
		//not TODO
	}
	
	public void finishCombat(Combat combat) {
		if(this == combat.getCorrector()){
			//TODO
		}
		
	}
	
	public void startCombat(Group opponent, Group corrector) {
		Combat combat = new Combat(this, opponent);
		this.getCurrentCombats().add(combat);
		opponent.getCurrentCombats().add(combat);
		corrector.getCurrentCombats().add(combat);
		//TODO
	}
	
	public float getWinToLoss(){
		return winToLoss;
	}
	
	public ArrayList<Combat> getCurrentCombats(){
		return this.currentCombats;
	}

}
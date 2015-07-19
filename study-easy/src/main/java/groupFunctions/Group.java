package groupFunctions;

import java.util.ArrayList;

import javax.persistence.*;

import service.CombatServiceImpl;
import service.GroupServiceImpl;
import sharedAttributes.Achievement;
import sharedAttributes.Badge;
import sharedAttributes.GroupPinn;
import sharedAttributes.HistoryElement;
import system.Controller;
import users.RegUser;

@Entity
public class Group {

	@Id
	private String name;
	@ManyToMany
	private ArrayList<RegUser> userList = new ArrayList<RegUser>();
	private String description;
	private RegUser admin;
	private int wins;
	private int losses;
	private float winToLoss;
	private int winStreak;
	@ManyToMany
	private ArrayList<Combat> currentCombats = new ArrayList<Combat>();
	private GroupPinn pinnwall;
	@ManyToMany
	private ArrayList<Achievement> achievements = new ArrayList<Achievement>();

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
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupUserList(this.name, this.userList);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupDescription(this.name, this.description);
	}

	public RegUser getAdmin() {
		return admin;
	}

	public void setAdmin(RegUser admin) {
		this.admin = admin;
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupAdmin(this.name, this.admin);
	}

	public GroupPinn getPinnwall() {
		return pinnwall;
	}

	public void setPinnwall(GroupPinn pinnwall) {
		this.pinnwall = pinnwall;
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupPinnwall(this.name, this.pinnwall);
	}

	public ArrayList<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(ArrayList<Achievement> achievements) {
		this.achievements = achievements;
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupAchievements(this.name, this.achievements);
	}

	public void setCurrentCombats(ArrayList<Combat> currentCombats) {
		this.currentCombats = currentCombats;
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupCurrentCombats(this.name, this.currentCombats);
	}

	public void addUser(RegUser user) {
		userList.add(user);
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupUserList(this.name, this.userList);
	}

	public int getWinStreak() {
		return winStreak;
	}

	public void setWinStreak(int winStreak) {
		this.winStreak = winStreak;
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupWinStreak(this.name, this.winStreak);
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupWins(this.name, this.wins);
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupLosses(this.name, this.losses);
	}

	public void setWinToLoss(float winToLoss) {
		this.winToLoss = winToLoss;
		GroupServiceImpl GS = new GroupServiceImpl();
		GS.updateGroupWinToLoss(this.name, this.winToLoss);
	}

	public void reasignAdmin(String name) {
		for (RegUser user : this.userList)
			if (user.getName() == name) {
				this.admin = user;
				GroupServiceImpl GS = new GroupServiceImpl();
				GS.updateGroupAdmin(this.name, user);
				break;
			}
	}

	public void startChallenge(Group opponent, Group corrector) {
		// not TODO
	}

	public void finishCombat(Combat combat) {
		// TODO fertig?
		if (combat.getChallengerNames().isEmpty() && combat.getOpponentNames().isEmpty()) {
			combat.getChallenger().getCurrentCombats().remove(combat);
			for (RegUser user : combat.getChallenger().getUserList()) {
				for (Badge badge : Controller.getSystem().getBadgeList()) {
					Controller.awardBadge(badge, user);
				}
				Controller.giveXP(user, combat.getChallengerRight());
				Controller.levelUpUser(user);

			}
			for (Achievement achievement : Controller.getSystem().getAchievementList()) {
				if (achievement.conditionsTrue(combat.getChallenger()))
					combat.getChallenger().achievements.add(achievement);
				// TODO speichern
			}

			combat.getOpponent().getCurrentCombats().remove(combat);

			for (RegUser user : combat.getOpponent().getUserList()) {
				for (Badge badge : Controller.getSystem().getBadgeList()) {
					Controller.awardBadge(badge, user);
				}
				Controller.giveXP(user, combat.getOpponentRight());
				Controller.levelUpUser(user);
			}
			for (Achievement achievement : Controller.getSystem().getAchievementList()) {
				if (achievement.conditionsTrue(combat.getOpponent()))
					combat.getOpponent().achievements.add(achievement);
				// TODO speichern
			}
			HistoryElement element = new HistoryElement(combat);

			CombatServiceImpl CS = new CombatServiceImpl();
			CS.deleteCombat(combat.getId());
			combat = null;
		}
	}

	public void startCombat(Group opponent, Test test) {
		Combat combat = new Combat(this, opponent, test);
	}

	public float getWinToLoss() {
		return winToLoss;
	}

	public ArrayList<Combat> getCurrentCombats() {
		return this.currentCombats;
	}

}
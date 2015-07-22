package study_easy.groupFunctions;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.CombatServiceImpl;
import study_easy.service.GroupServiceImpl;
import study_easy.service.RegUserServiceImpl;
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.GroupPinn;
import study_easy.sharedAttributes.HistoryElement;
import study_easy.users.RegUser;

@Entity
@Table(name = "Group")
@Component
public class Group {

	@Id
	@Column
	private String name;
	@ManyToMany
	@JoinTable(name = "Gruppenmitglieder", joinColumns = @JoinColumn(name = "name") , inverseJoinColumns = @JoinColumn(name = "userName") )
	private Set<RegUser> userList = new HashSet<RegUser>();
	@Column
	private String description;
	@OneToOne
	private RegUser admin;
	@Column
	private int wins;
	@Column
	private int losses;
	@Column
	private float winToLoss;
	@Column
	private int winStreak;
	@OneToMany
	@JoinTable(name = "Combats", joinColumns = @JoinColumn(name = "name") , inverseJoinColumns = @JoinColumn(name = "id") )
	private Set<Combat> currentCombats = new HashSet<Combat>();
	@OneToOne
	private GroupPinn pinnwall;
	@ElementCollection
	private Set<Achievement> achievements = new HashSet<Achievement>();
	@Autowired
	private static GroupServiceImpl GS;
	@Autowired
	private static RegUserServiceImpl RUS;
	@Autowired
	private static CombatServiceImpl CS;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RegUser> getUserList() {
		return userList;
	}

	public void setUserList(Set<RegUser> userList) {
		this.userList = userList;
<<<<<<< HEAD
		//GS.updateGroupUserList(this.name, this.userList);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
<<<<<<< HEAD
		GS.updateGroupDescription(this.name, this.description);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public RegUser getAdmin() {
		return admin;
	}

	public void setAdmin(RegUser admin) {
		this.admin = admin;
<<<<<<< HEAD
		GS.updateGroupAdmin(this.name, this.admin);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public GroupPinn getPinnwall() {
		return pinnwall;
	}

	public void setPinnwall(GroupPinn pinnwall) {
		this.pinnwall = pinnwall;
<<<<<<< HEAD
		GS.updateGroupPinnwall(this.name, this.pinnwall);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public Set<Achievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(HashSet<Achievement> achievements) {
		this.achievements = achievements;
<<<<<<< HEAD
		//GS.updateGroupAchievements(this.name, this.achievements);
	}

	public void setCurrentCombats(Set<Combat> list) {
		this.currentCombats = list;
		//GS.updateGroupCurrentCombats(this.name, this.currentCombats);
=======
	}

	public void setCurrentCombats(HashSet<Combat> currentCombats) {
		this.currentCombats = currentCombats;
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public void addUser(RegUser user) {
		this.userList.add(user);
		user.getGroups().add(this.name);
<<<<<<< HEAD
		//GS.updateGroupUserList(this.name, this.userList);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public void deleteUser(RegUser user) {
		this.userList.remove(user);
		user.getGroups().remove(this.name);
	}

	public int getWinStreak() {
		return winStreak;
	}

	public void setWinStreak(int winStreak) {
		this.winStreak = winStreak;
<<<<<<< HEAD
		GS.updateGroupWinStreak(this.name, this.winStreak);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
<<<<<<< HEAD
		GS.updateGroupWins(this.name, this.wins);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
<<<<<<< HEAD
		GS.updateGroupLosses(this.name, this.losses);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public void setWinToLoss(float winToLoss) {
		this.winToLoss = winToLoss;
<<<<<<< HEAD
		GS.updateGroupWinToLoss(this.name, this.winToLoss);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public void reasignAdmin(String name) {
		for (RegUser user : this.userList)
			if (user.getName() == name) {
				this.admin = user;
<<<<<<< HEAD
				GS.updateGroupAdmin(this.name, user);
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
				break;
			}
	}

	public void finishCombat(Combat combat) {
		// TODO fertig?
//		if (combat.getChallengerNames().isEmpty() && combat.getOpponentNames().isEmpty()) {
//			Functionals.getSystem().findGroup(combat.getChallenger()).getCurrentCombats().remove(combat);
//			for (RegUser user : Functionals.getSystem().findGroup(combat.getChallenger()).getUserList()) {
//				for (Badge badge : Functionals.getSystem().getBadgeList()) {
//					Functionals.awardBadge(badge, user);
//				}
//				Functionals.getSystem().giveXP(user, combat.getChallengerRight());
//				Functionals.levelUpUser(user);
//
//			}
//			for (Achievement achievement : Functionals.getSystem().getAchievementList()) {
//				if (achievement.conditionsTrue(Functionals.getSystem().findGroup(combat.getChallenger())))
//					Functionals.getSystem().findGroup(combat.getChallenger()).achievements.add(achievement);
//			}
//
//			Functionals.getSystem().findGroup(combat.getOpponent()).getCurrentCombats().remove(combat);
//
//			for (RegUser user : Functionals.getSystem().findGroup(combat.getOpponent()).getUserList()) {
//				for (Badge badge : Functionals.getSystem().getBadgeList()) {
//					Functionals.awardBadge(badge, user);
//				}
//				Functionals.getSystem().giveXP(user, combat.getOpponentRight());
//				Functionals.levelUpUser(user);
//			}
//			for (Achievement achievement : Functionals.getSystem().getAchievementList()) {
//				if (achievement.conditionsTrue(Functionals.getSystem().findGroup(combat.getOpponent())))
//					Functionals.getSystem().findGroup(combat.getOpponent()).achievements.add(achievement);
//
//			}
			HistoryElement element = new HistoryElement(combat);
<<<<<<< HEAD

			CS.deleteCombat(combat.getId());
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
			combat = null;
		//}
	}

	public void startCombat(Group opponent, Test test) {
		Combat combat = new Combat(this.name, opponent.name, test);
	}

	public float getWinToLoss() {
		return winToLoss;
	}

	public Set<Combat> getCurrentCombats() {
		return this.currentCombats;
	}

}
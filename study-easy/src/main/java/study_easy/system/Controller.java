package study_easy.system;

import java.util.ArrayList;
import java.util.List;

import study_easy.groupFunctions.Group;
import study_easy.service.AchievementServiceImpl;
import study_easy.service.AdminServiceImpl;
import study_easy.service.BadgeServiceImpl;
import study_easy.service.GroupServiceImpl;
import study_easy.service.RegUserServiceImpl;
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.Badge;
import study_easy.users.Admin;
import study_easy.users.RegUser;

public class Controller {

	private static Controller system;
	private List<RegUser> regUserlist = new ArrayList<RegUser>();
	private List<Admin> adminList = new ArrayList<Admin>();
	private List<Group> groupList = new ArrayList<Group>();
	private List<Badge> badgeList = new ArrayList<Badge>();
	private List<Achievement> achievementList = new ArrayList<Achievement>();

	public static Controller getSystem() {
		if (system == null) {
			system = new Controller();
			RegUserServiceImpl RUS = new RegUserServiceImpl();
			system.regUserlist = RUS.listRegUsers();	
			AdminServiceImpl AS = new AdminServiceImpl();
			system.adminList = AS.listAdmin();
			GroupServiceImpl GS = new GroupServiceImpl();
			system.groupList = GS.listGroup();
			BadgeServiceImpl BS = new BadgeServiceImpl();
			system.badgeList = BS.listBadge();
			AchievementServiceImpl AcS = new AchievementServiceImpl();
			system.achievementList = AcS.listAchievement();
			system.fillLeaderboard();
			return system;
		} else
			return system;
	}

	// lel
	private void fillLeaderboard() {
		for (Group group : groupList)
			Leaderboard.getLeaderboard().addGroup(group);
	}

	public List<Achievement> getAchievementList() {
		return this.achievementList;
	}

	public List<RegUser> getUserList() {
		return this.regUserlist;
	}

	public List<Admin> getAdminList() {
		return this.adminList;
	}

	public List<Badge> getBadgeList() {
		return this.badgeList;
	}

	public static void awardBadge(Badge badge, RegUser user) {
		if (badge.conditionsTrue(user) && !user.getEarnedBadges().contains(badge)) {
			user.getEarnedBadges().add(badge);
		}
	}

	public static void awardAchievement(Achievement achiev, Group group) {
		if (achiev.conditionsTrue(group) && !group.getAchievements().contains(achiev)) {
			group.getAchievements().add(achiev);
		}
	}

	public void giveXP(RegUser user, int numOfRight) {
		user.setXpPoints(user.getXpPoints() + (numOfRight * 10));
	}

	public Group findGroup(String group) {
		for (Group groupToFind : this.groupList) {
			if (groupToFind.getName().equals(group)) {
				return groupToFind;
			}
		}
		return null;
	}

	public static void levelUpUser(RegUser user) {
		int points = user.getXpPoints();
		switch (user.getLevel()) {
		case 0:
			if (points >= 500)
				user.setLevel(1);
		case 1:
			if (points >= 1000)
				user.setLevel(2);
		case 2:
			if (points >= 2000)
				user.setLevel(3);
		case 3:
			if (points >= 4000)
				user.setLevel(4);
		case 4:
			if (points >= 7500)
				user.setLevel(5);
		case 5:
			if (points >= 12000)
				user.setLevel(6);
		case 6:
			if (points >= 18000)
				user.setLevel(7);
		case 7:
			if (points >= 25000)
				user.setLevel(8);
		case 8:
			if (points >= 35000)
				user.setLevel(9);
		case 9:
			if (points >= 50000)
				user.setLevel(10);
		case 10:
			break;
		}

	}

	public static void recalcWinToLoss(Group group) {
		group.setWinToLoss(group.getWins() / group.getLosses());
	}
}
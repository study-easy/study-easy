package system;

import java.util.ArrayList;
import java.util.List;

import groupFunctions.Group;
import sharedAttributes.Badge;
import users.Admin;
import users.RegUser;

public class Controller {

	private static Controller system;
	private List<RegUser> regUserlist = new ArrayList<RegUser>();
	private List<Admin> adminList = new ArrayList<Admin>();
	private List<Group> groupList = new ArrayList<Group>();

	public static Controller getSystem() {
		if (system == null) {
			system = new Controller();
			//TODO laden der User, Admins und Gruppen aus hibernate
			system.fillLeaderboard();
			return system;
		} else
			return system;
	}

	//lel
	private void fillLeaderboard(){
		for(Group group : groupList)
			Leaderboard.getLeaderboard().addGroup(group);
		Leaderboard.getLeaderboard().sortBoard();
	}
	
	public List<RegUser> getUserList() {
		return this.regUserlist;
	}

	public List<Admin> getAdminList() {
		return this.adminList;
	}

	public static void awardBadge(Badge badge, RegUser user) {
		if (badge.conditionsTrue(user)) {
			user.getEarnedBadges().add(badge);
		}
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

	public static void recalcWinToLoss(Group group){
		group.setWinToLoss(group.getWins()/group.getLosses());
	}
}
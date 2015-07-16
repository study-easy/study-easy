package service;

import java.util.List;

import groupFunctions.Combat;
import groupFunctions.Group;
import sharedAttributes.Achievement;
import sharedAttributes.GroupPinn;
import users.RegUser;

public interface GroupService {
	public void addGroup(Group group);
	public List<Group> listGroup();
	public void updateGroupDescription(String name, String description);
	public void updateGroupAdmin(String name, RegUser admin);
	public void updateGroupUserList(String name, List<RegUser> list);
	public void updateGroupWins(String name, int wins);
	public void updateGroupLosses(String name, int losses);
	public void updateGroupWinToLoss(String name, float winToLoss);
	public void updateGroupCurrentCombats(String name, List<Combat> list);
	public void updateGroupAchievements(String name, List<Achievement> list);
	public void updateGroupPinnwall(String name, GroupPinn pinn);
	public void deleteGroup(String name);

}

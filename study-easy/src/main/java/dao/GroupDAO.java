package dao;

import java.util.ArrayList;
import java.util.List;

import groupFunctions.Combat;
import groupFunctions.Group;
import sharedAttributes.Achievement;
import sharedAttributes.GroupPinn;
import users.RegUser;

public interface GroupDAO {
	
	public void addGroup(Group group);
	public List<Group> listGroup();
	public void updateGroupDescription(String name, String description);
	public void updateGroupAdmin(String name, RegUser admin);
	public void updateGroupUserList(String name, ArrayList<RegUser> list);
	public void updateGroupWins(String name, int wins);
	public void updateGroupLosses(String name, int losses);
	public void updateGroupWinToLoss(String name, float winToLoss);
	public void updateGroupCurrentCombats(String name, ArrayList<Combat> list);
	public void updateGroupAchievements(String name, ArrayList<Achievement> list);
	public void updateGroupPinnwall(String name, GroupPinn pinn);
	public void updateGroupWinStreak(String name, int streak);
	public void deleteGroup(String name);

}

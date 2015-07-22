package study_easy.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Group;
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.GroupPinn;
import study_easy.users.RegUser;

public interface GroupService {
	
	public void addGroup(Group group);
	public List<Group> listGroup();
	public void updateGroupDescription(String name, String description);
	public void updateGroupAdmin(String name, RegUser admin);
	public void updateGroupUserList(String name, HashSet<RegUser> list);
	public void updateGroupWins(String name, int wins);
	public void updateGroupLosses(String name, int losses);
	public void updateGroupWinToLoss(String name, float winToLoss);
	public void updateGroupCurrentCombats(String name, Set<Combat> list);
	public void updateGroupAchievements(String name, HashSet<Achievement> list);
	public void updateGroupPinnwall(String name, GroupPinn pinn);
	public void updateGroupWinStreak(String name, int streak);
	public void deleteGroup(String name);

}

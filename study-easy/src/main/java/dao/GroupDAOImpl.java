package dao;

import java.util.List;

import groupFunctions.Combat;
import groupFunctions.Group;
import sharedAttributes.Achievement;
import sharedAttributes.GroupPinn;
import users.RegUser;

public class GroupDAOImpl implements GroupDAO{

	@Override
	public void addGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Group> listGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGroupDescription(String name, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupAdmin(String name, RegUser admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupUserList(String name, List<RegUser> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupWins(String name, int wins) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupLosses(String name, int losses) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupWinToLoss(String name, float winToLoss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupCurrentCombats(String name, List<Combat> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupAchievements(String name, List<Achievement> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupPinnwall(String name, GroupPinn pinn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroup(String name) {
		// TODO Auto-generated method stub
		
	}

}

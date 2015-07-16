package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.GroupDAOImpl;
import groupFunctions.Combat;
import groupFunctions.Group;
import sharedAttributes.Achievement;
import sharedAttributes.GroupPinn;
import users.RegUser;

@Service
public class GroupServiceImpl implements GroupService {

	GroupDAOImpl gdao = new GroupDAOImpl();
	
	@Override
	public void addGroup(Group group) {
		gdao.addGroup(group);
		
	}

	@Override
	public List<Group> listGroup() {
		return gdao.listGroup();
	}

	@Override
	public void updateGroupDescription(String name, String description) {
		gdao.updateGroupDescription(name, description);
		
	}

	@Override
	public void updateGroupAdmin(String name, RegUser admin) {
		gdao.updateGroupAdmin(name, admin);
		
	}

	@Override
	public void updateGroupUserList(String name, List<RegUser> list) {
		gdao.updateGroupUserList(name, list);
		
	}

	@Override
	public void updateGroupWins(String name, int wins) {
		gdao.updateGroupWins(name, wins);
		
	}

	@Override
	public void updateGroupLosses(String name, int losses) {
		gdao.updateGroupLosses(name, losses);
		
	}

	@Override
	public void updateGroupWinToLoss(String name, float winToLoss) {
		gdao.updateGroupWinToLoss(name, winToLoss);
		
	}

	@Override
	public void updateGroupCurrentCombats(String name, List<Combat> list) {
		gdao.updateGroupCurrentCombats(name, list);
		
	}

	@Override
	public void updateGroupAchievements(String name, List<Achievement> list) {
		gdao.updateGroupAchievements(name, list);
		
	}

	@Override
	public void updateGroupPinnwall(String name, GroupPinn pinn) {
		gdao.updateGroupPinnwall(name, pinn);
		
	}

	@Override
	public void deleteGroup(String name) {
		gdao.deleteGroup(name);
		
	}

}

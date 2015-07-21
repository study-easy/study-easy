package study_easy.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.GroupDAOImpl;
import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Group;
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.GroupPinn;
import study_easy.users.RegUser;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDAOImpl gdao;
	
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
	public void updateGroupUserList(String name, HashSet<RegUser> list) {
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
	public void updateGroupCurrentCombats(String name, Set<Combat> list) {
		gdao.updateGroupCurrentCombats(name, list);
		
	}

	@Override
	public void updateGroupAchievements(String name, HashSet<Achievement> list) {
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

	@Override
	public void updateGroupWinStreak(String name, int streak) {
		gdao.updateGroupWinStreak(name, streak);
	}

}

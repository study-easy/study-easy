package study_easy.service;

<<<<<<< HEAD
import java.util.HashSet;
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.GroupDAOImpl;
import study_easy.groupFunctions.Group;
import study_easy.system.Leaderboard;

@Service
@Transactional
public class GroupService {

	@Autowired
	private GroupDAOImpl gdao;
	
	public GroupService(){
		
	}
	
	public void addGroup(Group group) {
		gdao.addGroup(group);
		
	}

	public List<Group> listGroup() {
		return gdao.listGroup();
	}

	public void fillLeaderboard() {
		for (Group group : gdao.listGroup())
			Leaderboard.getLeaderboard().addGroup(group);
	}

	public void deleteGroup(String name) {
		gdao.deleteGroup(name);
		
	}
	
<<<<<<< HEAD
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
=======
	public void getGroup(String name){
		
	}
>>>>>>> origin/ConnorsVerzweiflungsBranch

}

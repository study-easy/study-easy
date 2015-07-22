package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.GroupDAOImpl;
import study_easy.groupFunctions.Group;
import study_easy.sharedAttributes.Achievement;
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

	public void deleteGroup(Group group) {
		gdao.deleteGroup(group);
		
	}
	
	public Group getGroup(String name){
		Group groupToFind = null;
		for(Group group : gdao.listGroup()){
			if(group.getName().equals(name)){
				groupToFind = group;
				break;
			}
		}
		return groupToFind;
	}
	
	public void updateGroup(Group group){
		gdao.updateGroup(group);
	}
	
	public void awardAchievement(Achievement achiev, Group group) {
		if (achiev.conditionsTrue(group) && !group.getAchievements().contains(achiev)) {
			group.getAchievements().add(achiev);
			this.gdao.updateGroup(group);
		}
	}
	
	public void recalcWinToLoss(Group group) {
		group.setWinToLoss(group.getWins() / group.getLosses());
		gdao.updateGroup(group);
	}

}

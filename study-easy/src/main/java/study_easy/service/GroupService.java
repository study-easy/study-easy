package study_easy.service;

import java.util.List;

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
	
	public void getGroup(String name){
		
	}

}

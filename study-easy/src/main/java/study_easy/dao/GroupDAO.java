package study_easy.dao;

import java.util.List;

import study_easy.groupFunctions.Group;

public interface GroupDAO {
	
	public void addGroup(Group group);
	public List<Group> listGroup();
	public void updateGroup(Group group);
	public Group getGroup(String name);
	public void deleteGroup(Group name);

}

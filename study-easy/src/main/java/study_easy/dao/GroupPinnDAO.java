package study_easy.dao;

import java.util.List;

import study_easy.sharedAttributes.GroupPinn;

public interface GroupPinnDAO {
	
	public void addGroupPinn(GroupPinn pinn);
	public List<GroupPinn> listGroupPinn();
	public void updateGroupPinn(GroupPinn pinn);
	public void deleteGroupPinn(GroupPinn owner);

}

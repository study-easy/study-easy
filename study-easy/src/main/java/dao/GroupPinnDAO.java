package dao;

import java.util.List;

import groupFunctions.Group;
import sharedAttributes.GroupPinn;
import sharedAttributes.HistoryElement;
import sharedAttributes.PinnwallElement;

public interface GroupPinnDAO {
	
	public void addGroupPinn(GroupPinn pinn);
	public List<GroupPinn> listGroupPinn();
	public void updateGroupPinnHistory(Group owner, List<HistoryElement> list);
	public void updateGroupPinnEntries(Group owner, List<PinnwallElement> list);
	public void updateGroupPinnBan(Group owner, boolean ban);
	public void deleteGroupPinn(Group owner);

}

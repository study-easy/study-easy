package service;

import java.util.List;

import sharedAttributes.GroupPinn;
import sharedAttributes.HistoryElement;
import sharedAttributes.PinnwallElement;

public interface GroupPinnService {
	public void addGroupPinn(GroupPinn pinn);
	public List<GroupPinn> listGroupPinn();
	public void updateGroupPinnHistory(String owner, List<HistoryElement> list);
	public void updateGroupPinnEntries(String owner, List<PinnwallElement> list);
	public void updateGroupPinnBan(String owner, boolean ban);
	public void deleteGroupPinn(String owner);

}

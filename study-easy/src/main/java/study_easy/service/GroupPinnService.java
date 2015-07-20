package study_easy.service;

import java.util.HashSet;
import java.util.List;

import study_easy.sharedAttributes.GroupPinn;
import study_easy.sharedAttributes.HistoryElement;
import study_easy.sharedAttributes.PinnwallElement;

public interface GroupPinnService {
	
	public void addGroupPinn(GroupPinn pinn);
	public List<GroupPinn> listGroupPinn();
	public void updateGroupPinnHistory(String owner, HistoryElement element);
	public void updateGroupPinnEntries(String owner, PinnwallElement element);
	public void updateGroupPinnBan(String owner, boolean ban);
	public void deleteGroupPinn(String owner);

}

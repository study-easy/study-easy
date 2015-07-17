package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.GroupPinnDAOImpl;
import sharedAttributes.GroupPinn;
import sharedAttributes.HistoryElement;
import sharedAttributes.PinnwallElement;

@Service
public class GroupPinnServiceImpl implements GroupPinnService{

	GroupPinnDAOImpl gpdao = new GroupPinnDAOImpl();
	
	@Override
	public void addGroupPinn(GroupPinn pinn) {
		gpdao.addGroupPinn(pinn);
		
	}

	@Override
	public List<GroupPinn> listGroupPinn() {
		return gpdao.listGroupPinn();
	}

	@Override
	public void updateGroupPinnHistory(String owner, List<HistoryElement> list) {
		gpdao.updateGroupPinnHistory(owner, list);
		
	}

	@Override
	public void updateGroupPinnEntries(String owner, List<PinnwallElement> list) {
		gpdao.updateGroupPinnEntries(owner, list);
		
	}

	@Override
	public void updateGroupPinnBan(String owner, boolean ban) {
		gpdao.updateGroupPinnBan(owner, ban);
		
	}

	@Override
	public void deleteGroupPinn(String owner) {
		gpdao.deleteGroupPinn(owner);
		
	}

}

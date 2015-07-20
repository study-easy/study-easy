package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.GroupPinnDAOImpl;
import study_easy.sharedAttributes.GroupPinn;
import study_easy.sharedAttributes.HistoryElement;
import study_easy.sharedAttributes.PinnwallElement;

@Service
public class GroupPinnServiceImpl implements GroupPinnService{

	@Autowired
	private GroupPinnDAOImpl gpdao;
	
	@Override
	public void addGroupPinn(GroupPinn pinn) {
		gpdao.addGroupPinn(pinn);
		
	}

	@Override
	public List<GroupPinn> listGroupPinn() {
		return gpdao.listGroupPinn();
	}

	@Override
	public void updateGroupPinnHistory(String owner, HistoryElement list) {
		gpdao.updateGroupPinnHistory(owner, list);
		
	}

	@Override
	public void updateGroupPinnEntries(String owner, PinnwallElement list) {
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

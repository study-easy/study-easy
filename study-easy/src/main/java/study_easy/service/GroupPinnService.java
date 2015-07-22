package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.GroupPinnDAOImpl;
import study_easy.sharedAttributes.GroupPinn;
import study_easy.sharedAttributes.HistoryElement;
import study_easy.sharedAttributes.PinnwallElement;

@Service
@Transactional
public class GroupPinnService{

	@Autowired
	private GroupPinnDAOImpl gpdao;
	
<<<<<<< HEAD
	public void addGroupPinn(GroupPinn pinn);
	public List<GroupPinn> listGroupPinn();
	public void updateGroupPinnHistory(String owner, HistoryElement list);
	public void updateGroupPinnEntries(String owner, PinnwallElement list);
	public void updateGroupPinnBan(String owner, boolean ban);
	public void deleteGroupPinn(String owner);
=======
	public void addGroupPinn(GroupPinn pinn) {
		gpdao.addGroupPinn(pinn);
		
	}

	public List<GroupPinn> listGroupPinn() {
		return gpdao.listGroupPinn();
	}

	public void updateGroupPinnHistory(String owner, List<HistoryElement> list) {
		gpdao.updateGroupPinnHistory(owner, list);
		
	}

	public void updateGroupPinnEntries(String owner, List<PinnwallElement> list) {
		gpdao.updateGroupPinnEntries(owner, list);
		
	}

	public void updateGroupPinnBan(String owner, boolean ban) {
		gpdao.updateGroupPinnBan(owner, ban);
		
	}

	public void deleteGroupPinn(String owner) {
		gpdao.deleteGroupPinn(owner);
		
	}
>>>>>>> origin/ConnorsVerzweiflungsBranch

}

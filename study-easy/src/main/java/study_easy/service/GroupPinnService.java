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
	
	public void addGroupPinn(GroupPinn pinn) {
		gpdao.addGroupPinn(pinn);
		
	}

	public List<GroupPinn> listGroupPinn() {
		return gpdao.listGroupPinn();
	}

	public void updateGroupPinn(GroupPinn pinn){
		//TODO
	}

	public void deleteGroupPinn(String owner) {
		gpdao.deleteGroupPinn(owner);
		
	}

}

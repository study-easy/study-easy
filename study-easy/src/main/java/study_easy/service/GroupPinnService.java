package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.GroupPinnDAOImpl;
import study_easy.sharedAttributes.GroupPinn;

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
		gpdao.updateGroupPinn(pinn);
	}

	public void deleteGroupPinn(GroupPinn owner) {
		gpdao.deleteGroupPinn(owner);
		
	}

}

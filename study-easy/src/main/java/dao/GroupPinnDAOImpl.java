package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import groupFunctions.Group;
import sharedAttributes.GroupPinn;
import sharedAttributes.HistoryElement;
import sharedAttributes.PinnwallElement;

@Repository
@Transactional
public class GroupPinnDAOImpl implements GroupPinnDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addGroupPinn(GroupPinn pinn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GroupPinn> listGroupPinn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGroupPinnHistory(Group owner, List<HistoryElement> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupPinnEntries(Group owner, List<PinnwallElement> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupPinnBan(Group owner, boolean ban) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroupPinn(Group owner) {
		// TODO Auto-generated method stub
		
	}

}

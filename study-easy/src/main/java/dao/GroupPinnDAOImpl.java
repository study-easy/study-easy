package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
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
		Session session = factory.getCurrentSession();
		session.save(pinn);
	}

	@Override
	public List<GroupPinn> listGroupPinn() {
		Session session = factory.getCurrentSession();
		List<GroupPinn> list = session.createQuery("from GroupPinn").list();
		return list;
	}

	@Override
	public void updateGroupPinnHistory(String owner, List<HistoryElement> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupPinnEntries(String owner, List<PinnwallElement> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupPinnBan(String owner, boolean ban) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroupPinn(String owner) {
		Session session = factory.getCurrentSession();
		GroupPinn pinn = (GroupPinn) session.load(GroupPinn.class, owner);
		if(pinn!=null)
			session.delete(pinn);
	}

}

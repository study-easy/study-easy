package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import groupFunctions.Combat;
import groupFunctions.Group;
import sharedAttributes.Achievement;
import sharedAttributes.GroupPinn;
import users.RegUser;

@Repository
@Transactional
public class GroupDAOImpl implements GroupDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addGroup(Group group) {
		Session session = factory.getCurrentSession();
		session.save(group);
	}

	@Override
	public List<Group> listGroup() {
		Session session = factory.getCurrentSession();
		List<Group> list = session.createQuery("from Group").list();
		return list;
	}

	@Override
	public void updateGroupDescription(String name, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupAdmin(String name, RegUser admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupUserList(String name, List<RegUser> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupWins(String name, int wins) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupLosses(String name, int losses) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupWinToLoss(String name, float winToLoss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupCurrentCombats(String name, List<Combat> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupAchievements(String name, List<Achievement> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroupPinnwall(String name, GroupPinn pinn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroup(String name) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null)
			session.delete(group);
	}

}

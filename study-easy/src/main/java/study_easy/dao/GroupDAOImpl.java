package study_easy.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Group;
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.GroupPinn;
import study_easy.users.RegUser;

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
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setDescription(description);
			session.update(group);
		}
	}

	@Override
	public void updateGroupAdmin(String name, RegUser admin) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setAdmin(admin);
			session.update(group);
		}
	}

	@Override
	public void updateGroupUserList(String name, HashSet<RegUser> list) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setUserList(list);
			session.update(group);
		}
	}

	@Override
	public void updateGroupWins(String name, int wins) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setWins(wins);
			session.update(group);
		}
	}

	@Override
	public void updateGroupLosses(String name, int losses) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setLosses(losses);
			session.update(group);
		}
	}

	@Override
	public void updateGroupWinToLoss(String name, float winToLoss) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setWinToLoss(winToLoss);
			session.update(group);
		}
	}

	@Override
	public void updateGroupCurrentCombats(String name, HashSet<Combat> list) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setCurrentCombats(list);
			session.update(group);
		}
	}

	@Override
	public void updateGroupAchievements(String name, HashSet<Achievement> list) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setAchievements(list);
			session.update(group);
		}
	}

	@Override
	public void updateGroupPinnwall(String name, GroupPinn pinn) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setPinnwall(pinn);
			session.update(group);
		}
	}

	@Override
	public void deleteGroup(String name) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null)
			session.delete(group);
	}

	@Override
	public void updateGroupWinStreak(String name, int streak) {
		Session session = factory.getCurrentSession();
		Group group = (Group) session.load(Group.class, name);
		if(group!=null){
			group.setWinStreak(streak);
			session.update(group);
		}
	}

}

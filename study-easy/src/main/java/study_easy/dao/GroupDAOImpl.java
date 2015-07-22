package study_easy.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.groupFunctions.Group;

@Repository
public class GroupDAOImpl implements GroupDAO {

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
<<<<<<< HEAD
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
	public void updateGroupCurrentCombats(String name, Set<Combat> list) {
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
=======
	public void deleteGroup(String name) {
>>>>>>> origin/ConnorsVerzweiflungsBranch
		Session session = factory.getCurrentSession();
		Group group = (Group) session.createCriteria(Group.class).add(Restrictions.eqOrIsNull("name", name));
		session.delete(group);
	}

	@Override
	public void updateGroup(Group group) {
		factory.getCurrentSession().update(group);
	}

	@Override
	public Group getGroup(String name) {
		return (Group) factory.getCurrentSession().createCriteria(Group.class)
				.add(Restrictions.eqOrIsNull("name", name));
	}

}

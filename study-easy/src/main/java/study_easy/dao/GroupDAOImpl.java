package study_easy.dao;

import java.util.List;

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
	public void deleteGroup(String name) {
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

package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public void deleteGroup(Group name) {
		factory.getCurrentSession().delete(name);
	}

	@Override
	public void updateGroup(Group group) {
		factory.getCurrentSession().update(group);
	}

}

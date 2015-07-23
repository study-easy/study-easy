package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.GroupPinn;

@Repository
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
		@SuppressWarnings("unchecked")
		List<GroupPinn> list = session.createQuery("from GroupPinn").list();
		return list;
	}

	@Override
	public void deleteGroupPinn(GroupPinn owner) {
		factory.getCurrentSession().delete(owner);
	}

	@Override
	public void updateGroupPinn(GroupPinn pinn) {
		factory.getCurrentSession().update(pinn);
		
	}

}

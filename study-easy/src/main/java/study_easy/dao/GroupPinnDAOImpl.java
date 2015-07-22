package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.GroupPinn;
import study_easy.sharedAttributes.HistoryElement;
import study_easy.sharedAttributes.PinnwallElement;

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
		List<GroupPinn> list = session.createQuery("from GroupPinn").list();
		return list;
	}

	@Override
	public void deleteGroupPinn(String owner) {
		Session session = factory.getCurrentSession();
		GroupPinn pinn = (GroupPinn) session.load(GroupPinn.class, owner);
		if(pinn!=null)
			session.delete(pinn);
	}

	@Override
	public void updateGroupPinn(GroupPinn pinn) {
		// TODO Auto-generated method stub
		
	}

}

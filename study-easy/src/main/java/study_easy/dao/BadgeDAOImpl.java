package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.Badge;

@Repository
public class BadgeDAOImpl implements BadgeDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addBadge(Badge badge) {
		Session session = factory.getCurrentSession();
		session.save(badge);
	}

	@Override
	public List<Badge> listBadge() {
		Session session = factory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Badge> list = session.createQuery("from Badge").list();
		return list;
	}

	@Override
	public void updateBadge(Badge bagde) {
		factory.getCurrentSession().update(bagde);
	}

	@Override
	public void deleteBadge(String name) {
		Session session = factory.getCurrentSession();
		Badge bagde = (Badge) session.load(Badge.class, name);
		if(bagde!=null)
			session.delete(bagde);
	}

}

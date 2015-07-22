package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.BadgeCondition;

@Repository
public class BadgeConditionDAOImpl implements BadgeConditionDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addBadgeCondition(BadgeCondition condition) {
		Session session = factory.getCurrentSession();
		session.save(condition);
	}

	@Override
	public List<BadgeCondition> listBadgeCondition() {
		Session session = factory.getCurrentSession();
		List<BadgeCondition> list = session.createQuery("from BadgeCondition").list();
		return list;
	}

	@Override
	public void updateBadgeCondition(BadgeCondition condition) {
		factory.getCurrentSession().update(condition);
	}


	@Override
	public void deleteBadgeCondition(BadgeCondition condition) {
		factory.getCurrentSession().delete(condition);
	}

}

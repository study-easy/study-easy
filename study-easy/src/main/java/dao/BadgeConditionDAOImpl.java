package dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sharedAttributes.BadgeCondition;
import sharedAttributes.ConditionTypes;

@Transactional
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
	public void updateBadgeConditionType(int id, ConditionTypes type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBadgeConditionName(int id, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBadgeConditionRequiredInt(int id, int integer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBadgeConditionRequiredString(int id, String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBadgeConditionRequiredDate(int id, Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBadgeCondition(int id) {
		// TODO Auto-generated method stub
		
	}

}

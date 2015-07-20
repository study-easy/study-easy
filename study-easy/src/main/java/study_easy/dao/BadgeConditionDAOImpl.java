package study_easy.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.Badge;
import study_easy.sharedAttributes.BadgeCondition;
import study_easy.sharedAttributes.ConditionTypes;

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
		Session session = factory.getCurrentSession();
		BadgeCondition condition = (BadgeCondition) session.load(BadgeCondition.class, id);
		if(condition!=null){
			condition.setConditionType(type);
			session.update(condition);
		}
	}

	@Override
	public void updateBadgeConditionName(int id, String name) {
		Session session = factory.getCurrentSession();
		BadgeCondition condition = (BadgeCondition) session.load(BadgeCondition.class, id);
		if(condition!=null){
			condition.setName(name);
			session.update(condition);
		}
	}

	@Override
	public void updateBadgeConditionRequiredInt(int id, int integer) {
		Session session = factory.getCurrentSession();
		BadgeCondition condition = (BadgeCondition) session.load(BadgeCondition.class, id);
		if(condition!=null){
			condition.setRequiredNumber(integer);
			session.update(condition);
		}
	}

	@Override
	public void updateBadgeConditionRequiredString(int id, String string) {
		Session session = factory.getCurrentSession();
		BadgeCondition condition = (BadgeCondition) session.load(BadgeCondition.class, id);
		if(condition!=null){
			condition.setRequiredString(string);
			session.update(condition);
		}
	}

	@Override
	public void updateBadgeConditionRequiredDate(int id, Date date) {
		Session session = factory.getCurrentSession();
		BadgeCondition condition = (BadgeCondition) session.load(BadgeCondition.class, id);
		if(condition!=null){
			condition.setRequiredDate(date);
			session.update(condition);
		}
	}

	@Override
	public void deleteBadgeCondition(int id) {
		Session session = factory.getCurrentSession();
		BadgeCondition condition = (BadgeCondition) session.load(BadgeCondition.class, id);
		if(condition!=null)
			session.delete(condition);
	}

}

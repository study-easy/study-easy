package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sharedAttributes.AchievementCondition;
import sharedAttributes.ConditionTypes;

@Repository
@Transactional
public class AchievementConditionDAOImpl implements AchievementConditionDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addAchievementCondition(AchievementCondition condition) {
		Session session = factory.getCurrentSession();
		session.save(condition);
	}

	@Override
	public List<AchievementCondition> listAchievementCondition() {
		Session session = factory.getCurrentSession();
		List<AchievementCondition> list = session.createQuery("from AchievementCondition").list();
		return list;
	}

	@Override
	public void updateAchievementConditionName(int id, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAchievementConditionType(int id, ConditionTypes type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAchievementConditionRequiredNumber(int id, int number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAchievementConditionRequiredString(int id, String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAchievementConditionRequiredTime(int id, float time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAchievementConditionXp(int id, int xp) {
		Session session = factory.getCurrentSession();
		AchievementCondition condition = (AchievementCondition) session.load(AchievementCondition.class, id);
		if(condition != null)
			session.update(condition);		
	}

	@Override
	public void deleteAchievementCondition(int id) {
		Session session = factory.getCurrentSession();
		AchievementCondition condition =(AchievementCondition) session.load(AchievementCondition.class, id);
		if(condition!=null)
			session.delete(condition);
	}

}

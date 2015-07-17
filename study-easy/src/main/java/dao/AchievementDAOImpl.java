package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sharedAttributes.Achievement;
import sharedAttributes.AchievementCondition;

@Repository
@Transactional
public class AchievementDAOImpl implements AchievementDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addAchievement(Achievement achievement) {
		Session session = factory.getCurrentSession();
		session.save(achievement);		
	}

	@Override
	public List<Achievement> listAchievement() {
		Session session = factory.getCurrentSession();
		List<Achievement> list = session.createQuery("from Achievement").list();
		return list;
	}

	@Override
	public void updateAchievementConditions(String name, List<AchievementCondition> list) {
		Session session = factory.getCurrentSession();
		Achievement achievement = (Achievement) session.load(Achievement.class, name);
		if(achievement!=null){
			achievement.setConditions(list);
			session.update(achievement);
		}		
	}

	@Override
	public void deleteAchievement(String name) {
		Session session = factory.getCurrentSession();
		Achievement achievement = (Achievement) session.load(Achievement.class, name);
		if(achievement!=null)
			session.delete(achievement);
	}

}

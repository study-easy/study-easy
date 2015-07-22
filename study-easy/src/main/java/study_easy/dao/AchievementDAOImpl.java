package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.AchievementCondition;

@Repository
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
	public void updateAchievement(Achievement achievement) {
		factory.getCurrentSession().update(achievement);;		
	}

	@Override
	public void deleteAchievement(Achievement achievement) {
		factory.getCurrentSession().delete(achievement);
	}
}

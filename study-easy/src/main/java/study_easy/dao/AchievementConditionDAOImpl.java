package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.AchievementCondition;

@Repository
public class AchievementConditionDAOImpl implements AchievementConditionDAO {

	@Autowired
	private SessionFactory factory;
	
	public AchievementConditionDAOImpl(){
	}

	@Override
	public void addAchievementCondition(AchievementCondition condition) {
		factory.getCurrentSession().save(condition);
	}

	@Override
	public List<AchievementCondition> listAchievementCondition() {
		Session session = factory.getCurrentSession();
		List<AchievementCondition> list = session.createQuery("from AchievementCondition").list();
		return list;
	}

	@Override
	public void updateAchievementCondition(AchievementCondition condition) {
		factory.getCurrentSession().update(condition);
	}

	@Override
	public void deleteAchievementCondition(int id) {
		Session session = factory.getCurrentSession();
		AchievementCondition condition = (AchievementCondition) session.load(AchievementCondition.class, id);
		if (condition != null)
			session.delete(condition);
	}


}

package study_easy.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.AchievementCondition;
import study_easy.sharedAttributes.ConditionTypes;

@Repository
public class AchievementConditionDAOImpl implements AchievementConditionDAO {

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
		Session session = factory.getCurrentSession();
		AchievementCondition condition = (AchievementCondition) session.load(AchievementCondition.class, id);
		if (condition != null) {
			condition.setName(name);
			session.update(condition);
		}
	}

	@Override
	public void updateAchievementConditionType(int id, ConditionTypes type) {
		Session session = factory.getCurrentSession();
		AchievementCondition condition = (AchievementCondition) session.load(AchievementCondition.class, id);
		if (condition != null) {
			condition.setConditionType(type);
			session.update(condition);
		}
	}

	@Override
	public void updateAchievementConditionRequiredNumber(int id, int number) {
		Session session = factory.getCurrentSession();
		AchievementCondition condition = (AchievementCondition) session.load(AchievementCondition.class, id);
		if (condition != null) {
			condition.setRequiredNumber(number);
			session.update(condition);
		}
	}

	@Override
	public void updateAchievementConditionRequiredString(int id, String string) {
		Session session = factory.getCurrentSession();
		AchievementCondition condition =(AchievementCondition) session.load(AchievementCondition.class, id);
		if(condition!=null){
			condition.setRequiredString(string);
			session.update(condition);
		}
	}

	@Override
	public void updateAchievementConditionRequiredTime(int id, float time) {
		Session session = factory.getCurrentSession();
		AchievementCondition condition =(AchievementCondition) session.load(AchievementCondition.class, id);
		if(condition!=null){
			condition.setRequiredTime(time);
			session.update(condition);
		}
	}

	@Override
	public void updateAchievementConditionXp(int id, int xp) {
		Session session = factory.getCurrentSession();
		AchievementCondition condition = (AchievementCondition) session.load(AchievementCondition.class, id);
		if (condition != null) {
			condition.setBonusXp(xp);
			session.update(condition);
		}
	}

	@Override
	public void deleteAchievementCondition(int id) {
		Session session = factory.getCurrentSession();
		AchievementCondition condition = (AchievementCondition) session.load(AchievementCondition.class, id);
		if (condition != null)
			session.delete(condition);
	}


}

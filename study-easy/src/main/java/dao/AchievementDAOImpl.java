package dao;

import java.util.List;

import javax.transaction.Transactional;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Achievement> listAchievement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAchievementConditions(String name, List<AchievementCondition> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAchievement(String name) {
		// TODO Auto-generated method stub
		
	}

}

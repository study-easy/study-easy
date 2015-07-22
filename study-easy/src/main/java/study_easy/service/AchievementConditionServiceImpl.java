package study_easy.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.AchievementConditionDAO;
import study_easy.dao.AchievementConditionDAOImpl;
import study_easy.sharedAttributes.AchievementCondition;


@Service
@Transactional
public class AchievementConditionServiceImpl implements AchievementConditionDAO{

	@Autowired
	private AchievementConditionDAOImpl achievementConditionDAOImpl;
	
	@Override
	public void addAchievementCondition(AchievementCondition condition) {
		achievementConditionDAOImpl.addAchievementCondition(condition);
		
	}

	@Override
	public List<AchievementCondition> listAchievementCondition() {
		return achievementConditionDAOImpl.listAchievementCondition();
	}

	@Override
	public void deleteAchievementCondition(int id) {
		achievementConditionDAOImpl.deleteAchievementCondition(id);
		
	}

	@Override
	public void updateAchievementCondition(AchievementCondition condition) {
		achievementConditionDAOImpl.updateAchievementCondition(condition);
		
	}

}

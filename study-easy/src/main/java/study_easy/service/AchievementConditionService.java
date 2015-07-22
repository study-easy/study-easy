package study_easy.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.AchievementConditionDAOImpl;
import study_easy.sharedAttributes.AchievementCondition;


@Service
@Transactional
public class AchievementConditionService{

	@Autowired
	private AchievementConditionDAOImpl achievementConditionDAOImpl;
	
	public void addAchievementCondition(AchievementCondition condition) {
		achievementConditionDAOImpl.addAchievementCondition(condition);
		
	}

	public List<AchievementCondition> listAchievementCondition() {
		return achievementConditionDAOImpl.listAchievementCondition();
	}

	public void deleteAchievementCondition(int id) {
		achievementConditionDAOImpl.deleteAchievementCondition(id);
		
	}

	public void updateAchievementCondition(AchievementCondition condition) {
		achievementConditionDAOImpl.updateAchievementCondition(condition);
		
	}

}

package study_easy.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.AchievementConditionDAO;
import study_easy.dao.AchievementConditionDAOImpl;
import study_easy.sharedAttributes.AchievementCondition;
import study_easy.sharedAttributes.ConditionTypes;


@Service
@Transactional
public class AchievementConditionServiceImpl implements AchievementConditionService{

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
	public void updateAchievementConditionName(int id, String name) {
		achievementConditionDAOImpl.updateAchievementConditionName(id, name);
		
	}

	@Override
	public void updateAchievementConditionType(int id, ConditionTypes type) {
		achievementConditionDAOImpl.updateAchievementConditionType(id, type);
		
	}

	@Override
	public void updateAchievementConditionRequiredNumber(int id, int number) {
		achievementConditionDAOImpl.updateAchievementConditionRequiredNumber(id, number);
		
	}

	@Override
	public void updateAchievementConditionRequiredString(int id, String string) {
		achievementConditionDAOImpl.updateAchievementConditionRequiredString(id, string);
		
	}

	@Override
	public void updateAchievementConditionRequiredTime(int id, float time) {
		achievementConditionDAOImpl.updateAchievementConditionRequiredTime(id, time);
		
	}

	@Override
	public void updateAchievementConditionXp(int id, int xp) {
		achievementConditionDAOImpl.updateAchievementConditionXp(id, xp);
		
	}

	@Override
	public void deleteAchievementCondition(int id) {
		achievementConditionDAOImpl.deleteAchievementCondition(id);
		
	}

}

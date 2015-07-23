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

	public void deleteAchievementCondition(AchievementCondition condition) {
		achievementConditionDAOImpl.deleteAchievementCondition(condition);
		
	}

	public void updateAchievementCondition(AchievementCondition condition) {
		achievementConditionDAOImpl.updateAchievementCondition(condition);
		
	}
	
	public AchievementCondition getThisAchievCondition(int id){
		AchievementCondition cond = null;
		for(AchievementCondition condition : this.listAchievementCondition()){
			if(condition.getId() == id)
				cond = condition;
		}
		return cond;
	}

}

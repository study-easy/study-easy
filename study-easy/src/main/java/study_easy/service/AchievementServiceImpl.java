package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.AchievementDAO;
import study_easy.dao.AchievementDAOImpl;
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.AchievementCondition;

@Service
@Transactional
public class AchievementServiceImpl implements AchievementService {

	@Autowired
	private AchievementDAOImpl achievementDAOImpl;
	
	@Override
	public void addAchievement(Achievement achievement) {
		achievementDAOImpl.addAchievement(achievement);
		
	}

	@Override
	public List<Achievement> listAchievement() {
		return achievementDAOImpl.listAchievement();
	}

	@Override
	public void updateAchievementConditions(String name, AchievementCondition condition) {
		achievementDAOImpl.updateAchievementConditions(name, condition);
		
	}

	@Override
	public void deleteAchievement(String name) {
		achievementDAOImpl.deleteAchievement(name);
		
	}

}

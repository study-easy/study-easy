package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.AchievementDAOImpl;
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.AchievementCondition;

@Service
public class AchievementServiceImpl implements AchievementService {

	@Autowired
	private AchievementDAOImpl adao;
	
	@Override
	public void addAchievement(Achievement achievement) {
		adao.addAchievement(achievement);
		
	}

	@Override
	public List<Achievement> listAchievement() {
		return adao.listAchievement();
	}

	@Override
	public void updateAchievementConditions(String name, AchievementCondition condition) {
		adao.updateAchievementConditions(name, condition);
		
	}

	@Override
	public void deleteAchievement(String name) {
		adao.deleteAchievement(name);
		
	}

}

package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.AchievementDAOImpl;
import sharedAttributes.Achievement;
import sharedAttributes.AchievementCondition;

@Service
public class AchievementServiceImpl implements AchievementService {

	private AchievementDAOImpl adao = new AchievementDAOImpl();
	
	@Override
	public void addAchievement(Achievement achievement) {
		adao.addAchievement(achievement);
		
	}

	@Override
	public List<Achievement> listAchievement() {
		return adao.listAchievement();
	}

	@Override
	public void updateAchievementConditions(String name, List<AchievementCondition> list) {
		adao.updateAchievementConditions(name, list);
		
	}

	@Override
	public void deleteAchievement(String name) {
		adao.deleteAchievement(name);
		
	}

}

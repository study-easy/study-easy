package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AchievementDAOImpl;
import sharedAttributes.Achievement;
import sharedAttributes.AchievementCondition;

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
	public void updateAchievementConditions(String name, List<AchievementCondition> list) {
		adao.updateAchievementConditions(name, list);
		
	}

	@Override
	public void deleteAchievement(String name) {
		adao.deleteAchievement(name);
		
	}

}
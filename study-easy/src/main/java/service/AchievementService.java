package service;

import java.util.List;

import sharedAttributes.Achievement;
import sharedAttributes.AchievementCondition;

public interface AchievementService {

	public void addAchievement(Achievement achievement);
	public List<Achievement> listAchievement();
	public void updateAchievementConditions(String name, List<AchievementCondition> list);
	public void deleteAchievement(String name);
}

package study_easy.service;

import java.util.List;

import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.AchievementCondition;

public interface AchievementService {

	public void addAchievement(Achievement achievement);
	public List<Achievement> listAchievement();
	public void updateAchievementConditions(String name, List<AchievementCondition> list);
	public void deleteAchievement(String name);
}

package study_easy.dao;

import java.util.List;
import java.util.Set;

import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.AchievementCondition;

public interface AchievementDAO {
	
	public void addAchievement(Achievement achievement);
	public List<Achievement> listAchievement();
	public void updateAchievementConditions(String name, AchievementCondition condition);
	public void deleteAchievement(String name);

}

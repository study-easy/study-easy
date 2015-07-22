package study_easy.dao;

import java.util.List;

import study_easy.sharedAttributes.AchievementCondition;

public interface AchievementConditionDAO {
	
	public void addAchievementCondition(AchievementCondition condition);
	public List<AchievementCondition> listAchievementCondition();
	public void updateAchievementCondition(AchievementCondition condition);
	public void deleteAchievementCondition(AchievementCondition condition);

}

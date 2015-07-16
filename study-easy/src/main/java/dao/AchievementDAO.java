package dao;

import java.util.List;

import sharedAttributes.Achievement;
import sharedAttributes.AchievementCondition;

public interface AchievementDAO {
	
	public void addAchievement(Achievement achievement);
	public List<Achievement> listAchievement();
	public void updateConditions(String name, List<AchievementCondition> list);

}

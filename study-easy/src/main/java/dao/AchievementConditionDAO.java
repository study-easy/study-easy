package dao;

import java.util.List;

import sharedAttributes.AchievementCondition;
import sharedAttributes.ConditionTypes;

public interface AchievementConditionDAO {
	
	public void addAchievementCondition(AchievementCondition condition);
	public List<AchievementCondition> listAchievementCondition();
	public void updateAchievementConditionName(int id, String name);
	public void updateAchievementConditionType(int id, ConditionTypes type);
	public void updateAchievementConditionRequiredNumber(int id, int number);
	public void updateAchievementConditionRequiredString(int id, String string);
	public void updateAchievementConditionRequiredTime(int id, float time);
	public void updateAchievementConditionXp(int id, int xp);

}

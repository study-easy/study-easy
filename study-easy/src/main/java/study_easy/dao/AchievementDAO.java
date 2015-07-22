package study_easy.dao;

import java.util.List;
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.AchievementCondition;

public interface AchievementDAO {
	
	public void addAchievement(Achievement achievement);
	public List<Achievement> listAchievement();
	public void updateAchievement(Achievement achievement);
	public void deleteAchievement(Achievement achievement);

}

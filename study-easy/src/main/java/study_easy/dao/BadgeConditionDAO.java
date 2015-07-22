package study_easy.dao;

import java.util.List;

import study_easy.sharedAttributes.BadgeCondition;

public interface BadgeConditionDAO {
	
	public void addBadgeCondition(BadgeCondition condition);
	public List<BadgeCondition> listBadgeCondition();
	public void updateBadgeCondition(BadgeCondition condition);
	public void deleteBadgeCondition(BadgeCondition condition);
	

}

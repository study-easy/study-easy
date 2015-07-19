package service;

import java.util.Date;
import java.util.List;

import sharedAttributes.BadgeCondition;
import sharedAttributes.ConditionTypes;

public interface BadgeConditionService {
	public void addBadgeCondition(BadgeCondition condition);
	public List<BadgeCondition> listBadgeCondition();
	public void updateBadgeConditionType(int id,ConditionTypes type);
	public void updateBadgeConditionName(int id, String name);
	public void updateBadgeConditionRequiredInt(int id, int integer);
	public void updateBadgeConditionRequiredString(int id, String string);
	public void updateBadgeConditionRequiredDate(int id, Date date);
	public void deleteBadgeCondition(int id);

}

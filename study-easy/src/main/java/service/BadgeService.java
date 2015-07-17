package service;

import java.util.List;

import sharedAttributes.Badge;
import sharedAttributes.BadgeCondition;

public interface BadgeService {

	public void addBadge(Badge badge);
	public List<Badge> listBadge();
	public void updateBadgeConditions(String name, List<BadgeCondition> list);
	public void deleteBadge(String name);
}

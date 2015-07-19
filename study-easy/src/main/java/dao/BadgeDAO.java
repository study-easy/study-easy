package dao;

import java.util.ArrayList;
import java.util.List;

import sharedAttributes.Badge;
import sharedAttributes.BadgeCondition;

public interface BadgeDAO {

	public void addBadge(Badge badge);
	public List<Badge> listBadge();
	public void updateBadgeConditions(String name, ArrayList<BadgeCondition> list);
	public void deleteBadge(String name);
}

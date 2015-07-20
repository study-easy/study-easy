package study_easy.service;

import java.util.ArrayList;
import java.util.List;

import study_easy.sharedAttributes.Badge;
import study_easy.sharedAttributes.BadgeCondition;

public interface BadgeService {

	public void addBadge(Badge badge);
	public List<Badge> listBadge();
	public void updateBadgeConditions(String name, ArrayList<BadgeCondition> list);
	public void deleteBadge(String name);
}

package study_easy.dao;

import java.util.List;

import study_easy.sharedAttributes.Badge;

public interface BadgeDAO {

	public void addBadge(Badge badge);
	public List<Badge> listBadge();
	public void updateBadge(Badge badge);
	public void deleteBadge(String name);
}

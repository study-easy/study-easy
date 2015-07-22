package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.BadgeDAOImpl;
import study_easy.sharedAttributes.Badge;
import study_easy.sharedAttributes.BadgeCondition;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService{

	@Autowired
	private BadgeDAOImpl bdao;
	
	@Override
	public void addBadge(Badge badge) {
		bdao.addBadge(badge);
		
	}

	@Override
	public List<Badge> listBadge() {
		return bdao.listBadge();
	}

	@Override
	public void updateBadgeConditions(String name, BadgeCondition condition) {
		bdao.updateBadgeConditions(name, condition);
		
	}

	@Override
	public void deleteBadge(String name) {
		bdao.deleteBadge(name);
		
	}

}

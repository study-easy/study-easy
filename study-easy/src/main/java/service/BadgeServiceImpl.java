package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BadgeDAOImpl;
import sharedAttributes.Badge;
import sharedAttributes.BadgeCondition;

@Service
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
	public void updateBadgeConditions(String name, ArrayList<BadgeCondition> arraylist) {
		bdao.updateBadgeConditions(name, arraylist);
		
	}

	@Override
	public void deleteBadge(String name) {
		bdao.deleteBadge(name);
		
	}

}

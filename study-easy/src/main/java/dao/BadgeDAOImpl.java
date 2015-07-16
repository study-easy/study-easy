package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sharedAttributes.Badge;
import sharedAttributes.BadgeCondition;

@Repository
@Transactional
public class BadgeDAOImpl implements BadgeDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addBadge(Badge badge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Badge> listBadge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBadgeConditions(String name, List<BadgeCondition> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBadge(String name) {
		// TODO Auto-generated method stub
		
	}

}

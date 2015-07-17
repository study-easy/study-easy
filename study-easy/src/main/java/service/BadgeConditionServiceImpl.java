package service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.BadgeConditionDAOImpl;
import sharedAttributes.BadgeCondition;
import sharedAttributes.ConditionTypes;

@Service
public class BadgeConditionServiceImpl implements BadgeConditionService{

	BadgeConditionDAOImpl bcdao = new BadgeConditionDAOImpl();
	
	@Override
	public void addBadgeCondition(BadgeCondition condition) {
		bcdao.addBadgeCondition(condition);
		
	}

	@Override
	public List<BadgeCondition> listBadgeCondition() {
		return bcdao.listBadgeCondition();
	}

	@Override
	public void updateBadgeConditionType(int id, ConditionTypes type) {
		bcdao.updateBadgeConditionType(id, type);
		
	}

	@Override
	public void updateBadgeConditionName(int id, String name) {
		bcdao.updateBadgeConditionName(id, name);
		
	}

	@Override
	public void updateBadgeConditionRequiredInt(int id, int integer) {
		bcdao.updateBadgeConditionRequiredInt(id, integer);
		
	}

	@Override
	public void updateBadgeConditionRequiredString(int id, String string) {
		bcdao.updateBadgeConditionRequiredString(id, string);
		
	}

	@Override
	public void updateBadgeConditionRequiredDate(int id, Date date) {
		bcdao.updateBadgeConditionRequiredDate(id, date);
		
	}

	@Override
	public void deleteBadgeCondition(int id) {
		bcdao.deleteBadgeCondition(id);
		
	}

}

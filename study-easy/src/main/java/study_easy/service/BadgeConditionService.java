package study_easy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.BadgeConditionDAOImpl;
import study_easy.sharedAttributes.BadgeCondition;
import study_easy.sharedAttributes.ConditionTypes;

@Service
@Transactional
public class BadgeConditionService{

	@Autowired
	private BadgeConditionDAOImpl bcdao;
	
	public void addBadgeCondition(BadgeCondition condition) {
		bcdao.addBadgeCondition(condition);
		
	}

	public List<BadgeCondition> listBadgeCondition() {
		return bcdao.listBadgeCondition();
	}

	public void updateBadgeConditionType(int id, ConditionTypes type) {
		bcdao.updateBadgeConditionType(id, type);
		
	}

	public void updateBadgeConditionName(int id, String name) {
		bcdao.updateBadgeConditionName(id, name);
		
	}

	public void updateBadgeConditionRequiredInt(int id, int integer) {
		bcdao.updateBadgeConditionRequiredInt(id, integer);
		
	}

	public void updateBadgeConditionRequiredString(int id, String string) {
		bcdao.updateBadgeConditionRequiredString(id, string);
		
	}

	public void updateBadgeConditionRequiredDate(int id, Date date) {
		bcdao.updateBadgeConditionRequiredDate(id, date);
		
	}

	public void deleteBadgeCondition(int id) {
		bcdao.deleteBadgeCondition(id);
		
	}

}

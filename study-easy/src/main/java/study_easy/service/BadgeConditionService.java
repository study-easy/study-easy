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
	
	public BadgeCondition getThisBadgeCondition(int id){
		BadgeCondition condition = null;
		for(BadgeCondition cond : this.bcdao.listBadgeCondition()){
			if(cond.getId() == id){
				condition = cond;
				break;
			}
		}
		return condition;
	}

	public void deleteBadgeCondition(BadgeCondition condition){
		bcdao.deleteBadgeCondition(condition);
	}
	
	public void updateBadgeCondition(BadgeCondition condition){
		bcdao.updateBadgeCondition(condition);
	}

}

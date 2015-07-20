package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.AchievementConditionDAOImpl;
import study_easy.sharedAttributes.AchievementCondition;
import study_easy.sharedAttributes.ConditionTypes;

@Service
public class AchievementConditionServiceImpl implements AchievementConditionService{

	@Autowired
	private AchievementConditionDAOImpl acdao;
	
	@Override
	public void addAchievementCondition(AchievementCondition condition) {
		acdao.addAchievementCondition(condition);
		
	}

	@Override
	public List<AchievementCondition> listAchievementCondition() {
		return acdao.listAchievementCondition();
	}

	@Override
	public void updateAchievementConditionName(int id, String name) {
		acdao.updateAchievementConditionName(id, name);
		
	}

	@Override
	public void updateAchievementConditionType(int id, ConditionTypes type) {
		acdao.updateAchievementConditionType(id, type);
		
	}

	@Override
	public void updateAchievementConditionRequiredNumber(int id, int number) {
		acdao.updateAchievementConditionRequiredNumber(id, number);
		
	}

	@Override
	public void updateAchievementConditionRequiredString(int id, String string) {
		acdao.updateAchievementConditionRequiredString(id, string);
		
	}

	@Override
	public void updateAchievementConditionRequiredTime(int id, float time) {
		acdao.updateAchievementConditionRequiredTime(id, time);
		
	}

	@Override
	public void updateAchievementConditionXp(int id, int xp) {
		acdao.updateAchievementConditionXp(id, xp);
		
	}

	@Override
	public void deleteAchievementCondition(int id) {
		acdao.deleteAchievementCondition(id);
		
	}

}

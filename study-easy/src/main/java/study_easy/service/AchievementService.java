package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.AchievementDAOImpl;
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.AchievementCondition;

@Service
@Transactional
public class AchievementService{

	@Autowired
	private AchievementDAOImpl achievementDAOImpl;
	
	public void addAchievement(Achievement achievement) {
		achievementDAOImpl.addAchievement(achievement);
		
	}

	public List<Achievement> listAchievement() {
		return achievementDAOImpl.listAchievement();
	}

	public void updateAchievement(Achievement achiev) {
		achievementDAOImpl.updateAchievement(achiev);
		
	}

	public void deleteAchievement(Achievement name) {
		achievementDAOImpl.deleteAchievement(name);
		
	}
	
	public Achievement getThisAchievement(int id){
		Achievement achiev = null;
		for(Achievement achie : this.listAchievement())
			if(achie.getAchievId() == id){
				achiev = achie;
				break;
			}
		return achiev;
	}

}

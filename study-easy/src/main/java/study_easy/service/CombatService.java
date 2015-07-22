package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.CombatDAOImpl;
import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Group;
import study_easy.groupFunctions.Test;
import study_easy.sharedAttributes.Achievement;
import study_easy.sharedAttributes.Badge;
import study_easy.sharedAttributes.HistoryElement;
import study_easy.users.RegUser;

@Service
@Transactional
public class CombatService{

	@Autowired
	private CombatDAOImpl cdao;
	@Autowired
	private GroupService gs;
	@Autowired
	private BadgeService bs;
	@Autowired
	private AchievementService as;
	@Autowired
	private RegUserService rus;
	

	public void startCombat(Group challenger, Group opponent, Test test) {
		Combat combat = new Combat(challenger.getName(), opponent.getName(), test);
		cdao.addCombat(combat);
	}

	public List<Combat> listCombat() {
		return cdao.listCombat();
	}

	public void updateCombat(Combat combat){
		
	}

	public void deleteCombat(Combat combat) {
		cdao.deleteCombat(combat);
		
	}
	
	public Combat getThisCombat(int id){
		Combat com = null;
		for(Combat combat : this.listCombat()){
			if(combat.getId() == id){
				com = combat;
				break;
			}
		}
		return com;
	}
	
	public void finishCombat(Combat combat) {
		// TODO fertig?
		if (combat.getChallengerNames().isEmpty() && combat.getOpponentNames().isEmpty()) {
			gs.getGroup(combat.getChallenger()).getCurrentCombats().remove(combat);
			for (RegUser user : gs.getGroup(combat.getChallenger()).getUserList()) {
				for (Badge badge : bs.listBadge()) {
					rus.awardBadge(badge, user);
				}
				rus.giveXP(user, combat.getChallengerRight());
				rus.levelUpUser(user);

			}
			for (Achievement achievement : as.listAchievement()) {
				if (achievement.conditionsTrue(gs.getGroup(combat.getChallenger())))
					gs.getGroup(combat.getChallenger()).getAchievements().add(achievement);
			}
			
			gs.getGroup(combat.getOpponent()).getCurrentCombats().remove(combat);
			for (RegUser user : gs.getGroup(combat.getOpponent()).getUserList()) {
				for (Badge badge : bs.listBadge()) {
					rus.awardBadge(badge, user);
				}
				rus.giveXP(user, combat.getOpponentRight());
				rus.levelUpUser(user);
			}
			for (Achievement achievement : as.listAchievement()) {
				if (achievement.conditionsTrue(gs.getGroup(combat.getOpponent())))
					gs.getGroup(combat.getOpponent()).getAchievements().add(achievement);

			}
			HistoryElement element = new HistoryElement(combat);
			combat = null;
		}
	}

}

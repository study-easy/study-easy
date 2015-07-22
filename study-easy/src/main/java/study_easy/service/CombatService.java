package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.CombatDAOImpl;
import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Test;

@Service
@Transactional
public class CombatService{

	@Autowired
	private CombatDAOImpl cdao;
	
	public void addCombat(Combat combat) {
		cdao.addCombat(combat);
		
	}

	public List<Combat> listCombat() {
		return cdao.listCombat();
	}

	public void updateCombatChallenger(int id, String challenger) {
		cdao.updateCombatChallenger(id, challenger);
		
	}

	public void updateCombatOpponent(int id, String opponent) {
		cdao.updateCombatOpponent(id, opponent);
		
	}

	public void updateCombatTest(int id, Test test) {
		cdao.updateCombatTest(id, test);
		
	}

	public void deleteCombat(int id) {
		cdao.deleteCombat(id);
		
	}

	public void updateChallangerRight(int id, int challengerRight) {
		cdao.updateChallangerRight(id, challengerRight);
		
	}

	public void updateOpponentRight(int id, int opponentRight) {
		cdao.updateOpponentRight(id, opponentRight);
		
	}

}

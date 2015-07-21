package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.CombatDAO;
import study_easy.dao.CombatDAOImpl;
import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Test;

@Service
@Transactional
public class CombatServiceImpl implements CombatService{

	@Autowired
	private CombatDAOImpl cdao;
	
	@Override
	public void addCombat(Combat combat) {
		cdao.addCombat(combat);
		
	}

	@Override
	public List<Combat> listCombat() {
		return cdao.listCombat();
	}

	@Override
	public void updateCombatChallenger(int id, String challenger) {
		cdao.updateCombatChallenger(id, challenger);
		
	}

	@Override
	public void updateCombatOpponent(int id, String opponent) {
		cdao.updateCombatOpponent(id, opponent);
		
	}

	@Override
	public void updateCombatTest(int id, Test test) {
		cdao.updateCombatTest(id, test);
		
	}

	@Override
	public void deleteCombat(int id) {
		cdao.deleteCombat(id);
		
	}

	@Override
	public void updateChallangerRight(int id, int challengerRight) {
		cdao.updateChallangerRight(id, challengerRight);
		
	}

	@Override
	public void updateOpponentRight(int id, int opponentRight) {
		cdao.updateOpponentRight(id, opponentRight);
		
	}

}

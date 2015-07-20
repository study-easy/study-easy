package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.CombatDAOImpl;
import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Group;
import study_easy.groupFunctions.Test;

@Service
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
	public void updateCombatChallenger(int id, Group challenger) {
		cdao.updateCombatChallenger(id, challenger);
		
	}

	@Override
	public void updateCombatOpponent(int id, Group opponent) {
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

}

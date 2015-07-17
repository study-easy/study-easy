package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.CombatDAOImpl;
import groupFunctions.Combat;
import groupFunctions.Group;
import groupFunctions.Test;

@Service
public class CombatServiceImpl implements CombatService{

	private CombatDAOImpl cdao = new CombatDAOImpl();
	
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
	public void updateCombatCorrector(int id, Group corrector) {
		cdao.updateCombatCorrector(id, corrector);
		
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

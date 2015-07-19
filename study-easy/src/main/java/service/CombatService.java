package service;

import java.util.List;

import groupFunctions.Combat;
import groupFunctions.Group;
import groupFunctions.Test;

public interface CombatService {

	public void addCombat(Combat combat);
	public List<Combat> listCombat();
	public void updateCombatChallenger(int id, Group challenger);
	public void updateCombatOpponent(int id, Group opponent);
	public void updateCombatTest(int id, Test test);
	public void deleteCombat(int id);
}

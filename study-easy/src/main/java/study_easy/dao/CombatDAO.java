package study_easy.dao;

import java.util.List;

import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Group;
import study_easy.groupFunctions.Test;

public interface CombatDAO {
	
	public void addCombat(Combat combat);
	public List<Combat> listCombat();
	public void updateCombatChallenger(int id, Group challenger);
	public void updateCombatOpponent(int id, Group opponent);
	public void updateCombatTest(int id, Test test);
	public void deleteCombat(int id);

}

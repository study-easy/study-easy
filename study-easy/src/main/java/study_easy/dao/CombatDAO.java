package study_easy.dao;

import java.util.List;

import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Test;

public interface CombatDAO {
	
	public void addCombat(Combat combat);
	public List<Combat> listCombat();
	public void updateCombatChallenger(int id, String challenger);
	public void updateCombatOpponent(int id, String opponent);
	public void updateCombatTest(int id, Test test);
	public void updateChallangerRight(int id, int challengerRight);
	public void updateOpponentRight(int id, int opponentRight);
	public void deleteCombat(int id);

}

package study_easy.dao;

import java.util.List;

import study_easy.groupFunctions.Combat;

public interface CombatDAO {
	
	public void addCombat(Combat combat);
	public List<Combat> listCombat();
	public void updateCombat(Combat combat);
	public void deleteCombat(Combat combat);

}

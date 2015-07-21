package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Test;

@Repository
public class CombatDAOImpl implements CombatDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addCombat(Combat combat) {
		Session session = factory.getCurrentSession();
		session.save(combat);		
	}

	@Override
	public List<Combat> listCombat() {
		Session session = factory.getCurrentSession();
		List<Combat> list = session.createQuery("from Combat").list();
		return list;
	}

	@Override
	public void updateCombatChallenger(int id, String challenger) {
		Session session = factory.getCurrentSession();
		Combat combat = (Combat) session.load(Combat.class, id);
		if(combat!=null){
			combat.setChallenger(challenger);
			session.update(combat);
		}
	}

	@Override
	public void updateCombatOpponent(int id, String opponent) {
		Session session = factory.getCurrentSession();
		Combat combat = (Combat) session.load(Combat.class, id);
		if(combat!=null){
			combat.setOpponent(opponent);
			session.update(combat);
		}
	}

	@Override
	public void updateCombatTest(int id, Test test) {
		Session session = factory.getCurrentSession();
		Combat combat = (Combat) session.load(Combat.class, id);
		if(combat!=null){
			combat.setTest(test);
			session.update(combat);
		}
	}

	@Override
	public void deleteCombat(int id) {
		Session session = factory.getCurrentSession();
		Combat combat = (Combat) session.load(Combat.class, id);
		if(combat!=null)
			session.delete(combat);
	}

	@Override
	public void updateChallangerRight(int id, int challengerRight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOpponentRight(int id, int opponentRight) {
		// TODO Auto-generated method stub
		
	}

}

package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import groupFunctions.Combat;
import groupFunctions.Group;
import groupFunctions.Test;

@Repository
@Transactional
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
	public void updateCombatChallenger(int id, Group challenger) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCombatOpponent(int id, Group opponent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCombatCorrector(int id, Group corrector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCombatTest(int id, Test test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCombat(int id) {
		Session session = factory.getCurrentSession();
		Combat combat = (Combat) session.load(Combat.class, id);
		if(combat!=null)
			session.delete(combat);
	}

}

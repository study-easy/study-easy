package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.groupFunctions.Combat;

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
	public void updateCombat(Combat combat) {
		factory.getCurrentSession().update(combat);
	}

	@Override
	public void deleteCombat(Combat combat) {
		factory.getCurrentSession().delete(combat);
	}


}

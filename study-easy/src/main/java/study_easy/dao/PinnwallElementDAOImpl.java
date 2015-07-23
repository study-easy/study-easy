package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.PinnwallElement;

@Repository
public class PinnwallElementDAOImpl implements PinnwallElementDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addPinnwallElement(PinnwallElement element) {
		Session session = factory.getCurrentSession();
		session.save(element);
	}

	@Override
	public List<PinnwallElement> listPinnwallElement() {
		Session session = factory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<PinnwallElement> list = session.createQuery("from PinnwallElement").list();
		return list;
	}

	@Override
	public void deletePinnwallElement(int id) {
		Session session = factory.getCurrentSession();
		session.delete(id);
	}

	@Override
	public void updatePinnwallElementContent(PinnwallElement element) {
		factory.getCurrentSession().update(element);
		
	}

}

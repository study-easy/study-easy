package study_easy.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.PinnwallElement;

@Repository
@Transactional
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
		List<PinnwallElement> list = session.createQuery("from PinnwallElement").list();
		return list;
	}

	@Override
	public void updatePinnwallElementContent(int id, String content) {
		Session session = factory.getCurrentSession();
		PinnwallElement pinnwallElement = (PinnwallElement) session.load(PinnwallElement.class, id);
		if(pinnwallElement!=null){
			pinnwallElement.setEntry(content);
			session.update(pinnwallElement);
		}
	}

	@Override
	public void updatePinnwallElementDate(int id, Date date) {
		Session session = factory.getCurrentSession();
		PinnwallElement pinnwallElement = (PinnwallElement) session.load(PinnwallElement.class, id);
		if(pinnwallElement!=null){
			pinnwallElement.setDate(date);
			session.update(pinnwallElement);
		}
		
	}

	@Override
	public void updatePinnwallElementComments(int id, PinnwallElement element) {
		Session session = factory.getCurrentSession();
		PinnwallElement pinnwallElement = (PinnwallElement) session.load(PinnwallElement.class, id);
		if(pinnwallElement!=null){
			pinnwallElement.setComments(element);
			session.update(pinnwallElement);
		}
		
	}

	@Override
	public void deletePinnwallElement(int id) {
		Session session = factory.getCurrentSession();
		session.delete(id);
	}

}

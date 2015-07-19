package dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sharedAttributes.PinnwallElement;

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
	public void updatePinnwallElementContent(String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePinnwallElementDate(Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePinnwallElementComments(List<PinnwallElement> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePinnwallElement() {
		Session session = factory.getCurrentSession();
		//TODO
		
	}

}

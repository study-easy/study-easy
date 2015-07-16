package dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PinnwallElement> listPinnwallElement() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

}

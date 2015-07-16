package dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sharedAttributes.HistoryElement;

@Repository
@Transactional
public class HistoryElementDAOImpl implements HistoryElementDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addHistoryElement(HistoryElement element) {
		Session session = factory.getCurrentSession();
		session.save(element);		
	}

	@Override
	public List<HistoryElement> listHistoryElement() {
		Session session = factory.getCurrentSession();
		List<HistoryElement> list = session.createQuery("from HistoryElement").list();
		return list;
	}

	@Override
	public void updateHistoryElementContent(String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistoryElementDate(Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHistoryElement() {
		Session session = factory.getCurrentSession();
		//HistoryElement element = session.load(HistoryElement.class)
	}

}

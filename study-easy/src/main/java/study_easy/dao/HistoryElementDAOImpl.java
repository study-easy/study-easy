package study_easy.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.HistoryElement;

@Repository
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
	public void updateHistoryElementContent(int id, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHistoryElementDate(int id, Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHistoryElement(int id) {
		Session session = factory.getCurrentSession();
		session.delete(id);
	}

}

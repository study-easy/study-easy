package study_easy.dao;

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
		@SuppressWarnings("unchecked")
		List<HistoryElement> list = session.createQuery("from HistoryElement").list();
		return list;
	}

	@Override
	public void deleteHistoryElement(int id) {
		Session session = factory.getCurrentSession();
		session.delete(id);
	}

	@Override
	public void updateHistoryElementContent(HistoryElement element) {
		factory.getCurrentSession().update(element);
	}

}

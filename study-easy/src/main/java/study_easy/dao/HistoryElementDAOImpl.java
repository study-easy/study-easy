package study_easy.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.groupFunctions.Combat;
import study_easy.sharedAttributes.HistoryElement;

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
	public void updateHistoryElementContent(int id, String content) {
		Session session = factory.getCurrentSession();
		HistoryElement historyElement = (HistoryElement) session.load(HistoryElement.class, id);
		if(historyElement!=null){
			historyElement.setDescription(content);
			session.update(historyElement);
		}
	}

	@Override
	public void updateHistoryElementDate(int id, Date date) {
		Session session = factory.getCurrentSession();
		HistoryElement historyElement = (HistoryElement) session.load(HistoryElement.class, id);
		if(historyElement!=null){
			historyElement.setDate(date);
			session.update(historyElement);
		}
		
	}

	@Override
	public void deleteHistoryElement(int id) {
		Session session = factory.getCurrentSession();
		session.delete(id);
	}

}

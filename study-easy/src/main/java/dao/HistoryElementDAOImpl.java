package dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HistoryElement> listHistoryElement() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

}

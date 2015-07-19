package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HistoryElementDAOImpl;
import sharedAttributes.HistoryElement;

@Service
public class HistoryElementServiceImpl implements HistoryElementService{

	@Autowired
	private HistoryElementDAOImpl hedao;
	
	@Override
	public void addHistoryElement(HistoryElement element) {
		hedao.addHistoryElement(element);
		
	}

	@Override
	public List<HistoryElement> listHistoryElement() {
		return hedao.listHistoryElement();
		
	}

	@Override
	public void updateHistoryElementContent(String content) {
		hedao.updateHistoryElementContent(content);
		
	}

	@Override
	public void updateHistoryElementDate(Date date) {
		hedao.updateHistoryElementDate(date);
		
	}

	@Override
	public void deleteHistoryElement() {
		hedao.deleteHistoryElement();
		
	}

}

package study_easy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.HistoryElementDAOImpl;
import study_easy.sharedAttributes.HistoryElement;

@Service
@Transactional
public class HistoryElementService{

	@Autowired
	private HistoryElementDAOImpl hedao;
	
	public void addHistoryElement(HistoryElement element) {
		hedao.addHistoryElement(element);
		
	}

	public List<HistoryElement> listHistoryElement() {
		return hedao.listHistoryElement();
		
	}

	public void updateHistoryElementContent(int id, String content) {
		hedao.updateHistoryElementContent(id, content);
		
	}

	public void updateHistoryElementDate(int id, Date date) {
		hedao.updateHistoryElementDate(id, date);
		
	}

	public void deleteHistoryElement(int id) {
		hedao.deleteHistoryElement(id);
		
	}

}

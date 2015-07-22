package study_easy.service;

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

	public void updateHistoryElement(HistoryElement element){
		//TODO
	}

	public void deleteHistoryElement(int id) {
		hedao.deleteHistoryElement(id);
		
	}

}

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
	public void updateHistoryElementContent(int id, String content) {
		hedao.updateHistoryElementContent(id, content);
		
	}

	@Override
	public void updateHistoryElementDate(int id, Date date) {
		hedao.updateHistoryElementDate(id, date);
		
	}

	@Override
	public void deleteHistoryElement(int id) {
		hedao.deleteHistoryElement(id);
		
	}

}

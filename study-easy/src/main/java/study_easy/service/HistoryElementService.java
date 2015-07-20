package study_easy.service;

import java.util.Date;
import java.util.List;

import study_easy.sharedAttributes.HistoryElement;

public interface HistoryElementService {
	
	public void addHistoryElement(HistoryElement element);
	public List<HistoryElement> listHistoryElement();
	public void updateHistoryElementContent(String content);
	public void updateHistoryElementDate(Date date);
	public void deleteHistoryElement();
	//TODO identifikation

}

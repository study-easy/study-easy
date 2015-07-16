package dao;

import java.util.Date;
import java.util.List;

import sharedAttributes.HistoryElement;

public interface HistoryElementDAO {
	
	public void addHistoryElement(HistoryElement element);
	public List<HistoryElement> listHistoryElement();
	public void updateHistoryElementContent(String content);
	public void updateHistoryElementDate(Date date);
	public void deleteHistoryElement();
	//TODO identifikation

}

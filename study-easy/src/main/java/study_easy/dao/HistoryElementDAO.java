package study_easy.dao;

import java.util.List;

import study_easy.sharedAttributes.HistoryElement;

public interface HistoryElementDAO {

	public void addHistoryElement(HistoryElement element);
	public List<HistoryElement> listHistoryElement();
	public void updateHistoryElementContent(HistoryElement element);
	public void deleteHistoryElement(HistoryElement id);

}

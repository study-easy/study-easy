package study_easy.dao;

import java.util.Date;
import java.util.List;

import study_easy.sharedAttributes.HistoryElement;

public interface HistoryElementDAO {

	public void addHistoryElement(HistoryElement element);

	public List<HistoryElement> listHistoryElement();

	public void updateHistoryElementContent(int id, String content);

	public void updateHistoryElementDate(int id, Date date);

	public void deleteHistoryElement(int id);

}

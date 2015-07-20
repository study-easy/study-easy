package study_easy.dao;

import java.util.Date;
import java.util.List;

import study_easy.sharedAttributes.PinnwallElement;

public interface PinnwallElementDAO {

	public void addPinnwallElement(PinnwallElement element);
	public List<PinnwallElement> listPinnwallElement();
	public void updatePinnwallElementContent(String content);
	public void updatePinnwallElementDate(Date date);
	public void updatePinnwallElementComments(List<PinnwallElement> list);
	public void deletePinnwallElement();
	//TODO identifikation der Pinnwallelemente �berlegen
}

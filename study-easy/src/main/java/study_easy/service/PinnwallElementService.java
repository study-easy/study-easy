package study_easy.service;

import java.util.Date;
import java.util.List;

import study_easy.sharedAttributes.PinnwallElement;

public interface PinnwallElementService {
	
	public void addPinnwallElement(PinnwallElement element);
	public List<PinnwallElement> listPinnwallElement();
	public void updatePinnwallElementContent(int id, String content);
	public void updatePinnwallElementDate(int id, Date date);
	public void updatePinnwallElementComments(int id, PinnwallElement list);
	public void deletePinnwallElement(int id);

	
}

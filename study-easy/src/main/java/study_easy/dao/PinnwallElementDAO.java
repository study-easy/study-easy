package study_easy.dao;

import java.util.List;

import study_easy.sharedAttributes.PinnwallElement;

public interface PinnwallElementDAO {

	public void addPinnwallElement(PinnwallElement element);
	public List<PinnwallElement> listPinnwallElement();
	public void updatePinnwallElementContent(PinnwallElement element);
	public void deletePinnwallElement(int id);
}

package study_easy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.PinnwallElementDAOImpl;
import study_easy.sharedAttributes.PinnwallElement;

@Service
@Transactional
public class PinnwallElementService{

	@Autowired
	private PinnwallElementDAOImpl pedao;
	
	public void addPinnwallElement(PinnwallElement element) {
		pedao.addPinnwallElement(element);
		
	}

	public List<PinnwallElement> listPinnwallElement() {
		return pedao.listPinnwallElement();
	}

	public void updatePinnwallElementContent(int id, String content) {
		pedao.updatePinnwallElementContent(id, content);
		
	}

	public void updatePinnwallElementDate(int id, Date date) {
		pedao.updatePinnwallElementDate(id, date);
		
	}

	public void updatePinnwallElementComments(int id, List<PinnwallElement> list) {
		pedao.updatePinnwallElementComments(id, list);
		
	}

	public void deletePinnwallElement(int id) {
		pedao.deletePinnwallElement(id);
		
	}

}

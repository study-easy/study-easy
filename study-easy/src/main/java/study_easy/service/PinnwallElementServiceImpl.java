package study_easy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.PinnwallElementDAOImpl;
import study_easy.sharedAttributes.PinnwallElement;

@Service
public class PinnwallElementServiceImpl implements PinnwallElementService{

	@Autowired
	private PinnwallElementDAOImpl pedao;
	
	@Override
	public void addPinnwallElement(PinnwallElement element) {
		pedao.addPinnwallElement(element);
		
	}

	@Override
	public List<PinnwallElement> listPinnwallElement() {
		return pedao.listPinnwallElement();
	}

	@Override
	public void updatePinnwallElementContent(int id, String content) {
		pedao.updatePinnwallElementContent(id, content);
		
	}

	@Override
	public void updatePinnwallElementDate(int id, Date date) {
		pedao.updatePinnwallElementDate(id, date);
		
	}

	@Override
	public void updatePinnwallElementComments(int id, PinnwallElement element) {
		pedao.updatePinnwallElementComments(id, element);
		
	}

	@Override
	public void deletePinnwallElement(int id) {
		pedao.deletePinnwallElement(id);
		
	}

}

package study_easy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.PinnwallElementDAO;
import study_easy.dao.PinnwallElementDAOImpl;
import study_easy.sharedAttributes.PinnwallElement;

@Service
@Transactional
public class PinnwallElementServiceImpl implements PinnwallElementDAO{

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
	public void updatePinnwallElementComments(int id, List<PinnwallElement> list) {
		pedao.updatePinnwallElementComments(id, list);
		
	}

	@Override
	public void deletePinnwallElement(int id) {
		pedao.deletePinnwallElement(id);
		
	}

}

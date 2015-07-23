package study_easy.service;

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

	public void updatePinnwallElement(PinnwallElement element){
		pedao.updatePinnwallElementContent(element);
	}

	public void deletePinnwallElement(int id) {
		pedao.deletePinnwallElement(id);
		
	} //TODO

}

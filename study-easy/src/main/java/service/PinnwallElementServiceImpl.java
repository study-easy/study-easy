package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PinnwallElementDAOImpl;
import sharedAttributes.PinnwallElement;

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
	public void updatePinnwallElementContent(String content) {
		pedao.updatePinnwallElementContent(content);
		
	}

	@Override
	public void updatePinnwallElementDate(Date date) {
		pedao.updatePinnwallElementDate(date);
		
	}

	@Override
	public void updatePinnwallElementComments(List<PinnwallElement> list) {
		pedao.updatePinnwallElementComments(list);
		
	}

	@Override
	public void deletePinnwallElement() {
		pedao.deletePinnwallElement();
		
	}

}

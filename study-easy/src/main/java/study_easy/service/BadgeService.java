package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.BadgeDAOImpl;
import study_easy.sharedAttributes.Badge;

@Service
@Transactional
public class BadgeService{

	@Autowired
	private BadgeDAOImpl bdao;
	
	public void addBadge(Badge badge) {
		bdao.addBadge(badge);
		
	}

	public List<Badge> listBadge() {
		return bdao.listBadge();
	}

	public void updateBadge(Badge badge) {
		bdao.updateBadge(badge);
		
	}

	public void deleteBadge(String name) {
		bdao.deleteBadge(name);
		
	}
	
	public Badge getThisBadge(String name){
		Badge bad = null;
		for(Badge badge : this.listBadge()){
			if(badge.getName().equals(name)){
				bad = badge;
				break;
			}
		}
		return bad;
	}

}

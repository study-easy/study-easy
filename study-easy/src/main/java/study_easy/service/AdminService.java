package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.AdminDAOImpl;
import study_easy.users.Admin;

@Service
@Transactional
public class AdminService{

	@Autowired
	private AdminDAOImpl addao;
	
	public void addAdmin(Admin admin) {
		addao.addAdmin(admin);
		
	}

	public List<Admin> listAdmin() {
		return addao.listAdmin();
	}

	public void updateAdmin(Admin admin){
		addao.updateAdmin(admin);
	}

	public void deleteAdmin(String name) {
		addao.deleteAdmin(name);
		
	}
	
	public Admin getThisAdmin(String name){
		Admin admin = null;
		for(Admin ad : this.listAdmin()){
			if(ad.getName().equals(name)){
				admin = ad;
			}
		}
		return admin;
	}
	
	

}

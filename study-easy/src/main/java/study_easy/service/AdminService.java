package study_easy.service;

import java.util.Date;
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

	public void updateAdminPassword(String name, String password) {
		addao.updateAdminPassword(name, password);
		
	}

	public void updateAdminEmail(String name, String email) {
		addao.updateAdminEmail(name, email);
		
	}

	public void updateAdminRegisteredSince(String name, Date date) {
		addao.updateAdminRegisteredSince(name, date);
		
	}

	public void deleteAdmin(String name) {
		addao.deleteAdmin(name);
		
	}
	
	

}

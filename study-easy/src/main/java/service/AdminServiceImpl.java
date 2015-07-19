package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminDAOImpl;
import users.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAOImpl addao;
	
	@Override
	public void addAdmin(Admin admin) {
		addao.addAdmin(admin);
		
	}

	@Override
	public List<Admin> listAdmin() {
		return addao.listAdmin();
	}

	@Override
	public void updateAdminPassword(String name, String password) {
		addao.updateAdminPassword(name, password);
		
	}

	@Override
	public void updateAdminEmail(String name, String email) {
		addao.updateAdminEmail(name, email);
		
	}

	@Override
	public void updateAdminRegisteredSince(String name, Date date) {
		addao.updateAdminRegisteredSince(name, date);
		
	}

	@Override
	public void deleteAdmin(String name) {
		addao.deleteAdmin(name);
		
	}
	
	

}

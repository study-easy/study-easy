package dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import users.Admin;

@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> listAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAdminPassword(String name, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAdminEmail(String name, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAdminRegisteredSince(String name, Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdmin(String name) {
		// TODO Auto-generated method stub
		
	}

}

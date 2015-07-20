package study_easy.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.users.Admin;

@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addAdmin(Admin admin) {
		Session session = factory.getCurrentSession();
		session.save(admin);		
	}

	@Override
	public List<Admin> listAdmin() {
		Session session = factory.getCurrentSession();
		List<Admin> list = session.createQuery("from Admin").list();
		return list;
	}

	@Override
	public void updateAdminPassword(String name, String password) {
		Session session = factory.getCurrentSession();
		Admin admin = (Admin) session.load(Admin.class, name);
		if(admin!=null){
			admin.setPassword(password);
			session.update(admin);
		}
	}

	@Override
	public void updateAdminEmail(String name, String email) {
		Session session = factory.getCurrentSession();
		Admin admin = (Admin) session.load(Admin.class, name);
		if(admin!=null){
			admin.setEmail(email);
			session.update(admin);
		}		
	}

	@Override
	public void updateAdminRegisteredSince(String name, Date date) {
		Session session = factory.getCurrentSession();
		Admin admin = (Admin) session.load(Admin.class, name);
		if(admin!=null){
			
		}
	}

	@Override
	public void deleteAdmin(String name) {
		Session session = factory.getCurrentSession();
		Admin admin = (Admin) session.load(Admin.class, name);
		if(admin!=null)
			session.delete(admin);
	}

}

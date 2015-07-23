package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.users.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {

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
		@SuppressWarnings("unchecked")
		List<Admin> list = session.createQuery("from Admin").list();
		return list;
	}

	@Override
	public void deleteAdmin(String name) {
		Session session = factory.getCurrentSession();
		Admin admin = (Admin) session.load(Admin.class, name);
		if (admin != null)
			session.delete(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		factory.getCurrentSession().update(admin);
	}

}

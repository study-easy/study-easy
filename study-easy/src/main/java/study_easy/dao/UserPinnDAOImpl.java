package study_easy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.UserPinn;

@Repository
public class UserPinnDAOImpl implements UserPinnDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addUserPinn(UserPinn pinn) {
		Session session = factory.getCurrentSession();
		session.save(pinn);
		
	}

	@Override
	public List<UserPinn> listUserPinn() {
		Session session = factory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserPinn> list = session.createQuery("from UserPinn").list();
		return list;
	}

	@Override
	public void updateUserPinn(UserPinn owner) {
		factory.getCurrentSession().update(owner);
	}

	@Override
	public void deleteUserPinn(String owner) {
		Session session = factory.getCurrentSession();
		UserPinn pinn = (UserPinn) session.load(UserPinn.class, owner);
		if(pinn!=null)
			session.delete(pinn);
	}
	

}

package dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sharedAttributes.PinnwallElement;
import sharedAttributes.UserPinn;
import users.RegUser;

@Repository
@Transactional
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
		List<UserPinn> list = session.createQuery("from UserPinn").list();
		return list;
	}

	@Override
	public void updateUserPinnEntries(RegUser owner, List<PinnwallElement> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserPinnBan(String owner, boolean ban) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserPinn(String owner) {
		// TODO Auto-generated method stub
		
	}

	

}

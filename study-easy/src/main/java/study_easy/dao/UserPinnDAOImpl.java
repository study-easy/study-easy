package study_easy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import study_easy.sharedAttributes.PinnwallElement;
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
	public void updateUserPinnEntries(String owner, ArrayList<PinnwallElement> list) {
		Session session = factory.getCurrentSession();
		UserPinn pinn = (UserPinn) session.load(UserPinn.class, owner);
		if(pinn!=null){
			//TODO
		}
	}

	@Override
	public void updateUserPinnBan(String owner, boolean ban) {
		Session session = factory.getCurrentSession();
		UserPinn pinn = (UserPinn) session.load(UserPinn.class, owner);
		if(pinn!=null){
			pinn.setBanned(ban);
			session.update(pinn);
		}
	}

	@Override
	public void deleteUserPinn(String owner) {
		Session session = factory.getCurrentSession();
		UserPinn pinn = (UserPinn) session.load(UserPinn.class, owner);
		if(pinn!=null)
			session.delete(pinn);
	}

	@Override
	public void updateUserPinnOwner(String owner) {
		// TODO Auto-generated method stub
		
	}

	

}

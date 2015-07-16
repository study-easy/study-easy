package dao;

import java.util.List;

import javax.transaction.Transactional;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserPinn> listUserPinn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserPinnEntries(RegUser owner, List<PinnwallElement> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserPinnBan(RegUser owner, boolean ban) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserPinn(RegUser owner) {
		// TODO Auto-generated method stub
		
	}

}

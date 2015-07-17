package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dao.UserPinnDAOImpl;
import sharedAttributes.PinnwallElement;
import sharedAttributes.UserPinn;

@Service
public class UserPinnServiceImpl implements UserPinnService{

	UserPinnDAOImpl updao = new UserPinnDAOImpl();
	
	@Override
	public void addUserPinn(UserPinn pinn) {
		updao.addUserPinn(pinn);
		
	}

	@Override
	public List<UserPinn> listUserPinn() {
		return updao.listUserPinn();
	}

	@Override
	public void updateUserPinnEntries(String owner, ArrayList<PinnwallElement> list) {
		updao.updateUserPinnEntries(owner, list);
		
	}

	@Override
	public void updateUserPinnBan(String owner, boolean ban) {
		updao.updateUserPinnBan(owner, ban);
		
	}

	@Override
	public void deleteUserPinn(String owner) {
		updao.deleteUserPinn(owner);
		
	}

}

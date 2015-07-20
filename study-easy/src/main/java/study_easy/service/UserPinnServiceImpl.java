package study_easy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study_easy.dao.UserPinnDAOImpl;
import study_easy.sharedAttributes.PinnwallElement;
import study_easy.sharedAttributes.UserPinn;

@Service
public class UserPinnServiceImpl implements UserPinnService{

	@Autowired
	private UserPinnDAOImpl updao;
	
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

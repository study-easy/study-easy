package study_easy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.UserPinnDAOImpl;
import study_easy.sharedAttributes.UserPinn;

@Service
@Transactional
public class UserPinnService{

	@Autowired
	private UserPinnDAOImpl updao;
	
	public void addUserPinn(UserPinn pinn) {
		updao.addUserPinn(pinn);
	}
	
	public  UserPinnService(){	
	}

	public List<UserPinn> listUserPinn() {
		return updao.listUserPinn();
	}

	public void updateUserPinn(String owner) {
		//TDOD
		
	}

	public void deleteUserPinn(String owner) {
		updao.deleteUserPinn(owner);
		
	}
	
	public void getThisPinn(String owner){
		
	}

}

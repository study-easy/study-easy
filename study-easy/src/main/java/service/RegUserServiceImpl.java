package service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.RegUserDAO;
import users.RegUser;

@Service
public class RegUserServiceImpl implements RegUserService {

	@Override
	@Transactional
	public void addRegUser(String name, String password, String email) {
		this.regUserDAO.addRegUser(name, password, email);
	}

	@Override
	@Transactional
	public List<RegUser> listRegUsers() {
		return this.regUserDAO.listRegUsers();
	}

	@Override
	@Transactional
	public void deleteRegUser(String Username) {
		this.regUserDAO.deleteRegUser(Username);
	}
	
	 private RegUserDAO regUserDAO;

	 public void setRegUserDAO(RegUserDAO regUserDAO) {
	  this.regUserDAO = regUserDAO;
	 }

	@Override
	public void updateRegUserXP(String Username, int xpPoints) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRegUserPassword(String Username, String Password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRegUserEMail(String Username, String eMail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRegUserRegisteredSince(String Username, Date Date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRegUserSchool(String Username, String School) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRegUserHobby(String Username, String Hobby) {
		// TODO Auto-generated method stub
		
	}
}

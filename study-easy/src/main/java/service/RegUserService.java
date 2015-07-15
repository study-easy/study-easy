package service;

import java.util.Date;
import java.util.List;

import users.RegUser;

public interface RegUserService {

	public void addRegUser(String name, String password, String email);
	public List<RegUser> listRegUsers();
	public void updateRegUserXP(String Username, int xpPoints);
	public void updateRegUserPassword(String Username, String Password);
	public void updateRegUserEMail(String Username, String eMail);
	public void updateRegUserRegisteredSince(String Username, Date Date);
	public void updateRegUserSchool(String Username, String School);
	public void updateRegUserHobby(String Username, String Hobby);
	public void deleteRegUser(String Username);
}

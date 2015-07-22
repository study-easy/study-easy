package study_easy.dao;

import java.util.List;

import study_easy.users.RegUser;

public interface RegUserDAO {
	
	public void addRegUser(RegUser user);
	public List<RegUser> listRegUsers();
	public void updateRegUser(RegUser user);
	public void deleteRegUser(String Username);

}

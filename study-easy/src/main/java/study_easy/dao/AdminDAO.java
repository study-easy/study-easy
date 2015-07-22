package study_easy.dao;

import java.util.List;

import study_easy.users.Admin;

public interface AdminDAO {
	
	public void addAdmin(Admin admin);
	public List<Admin> listAdmin();
	public void updateAdmin(Admin admin);
	public void deleteAdmin(String name);

}

package study_easy.service;

import java.util.Date;
import java.util.List;

import study_easy.users.Admin;

public interface AdminService {
	
	public void addAdmin(Admin admin);
	public List<Admin> listAdmin();
	public void updateAdminPassword(String name, String password);
	public void updateAdminEmail(String name, String email);
	public void updateAdminRegisteredSince(String name, Date date);
	public void deleteAdmin(String name);

}

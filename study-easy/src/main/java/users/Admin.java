package users;

import java.util.List;

import system.System;

public class Admin extends User {

	protected void deleteUser(String name) {
		List<RegUser> userlist = System.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.name == name)
				user = null;
		}
	}

	protected void banUser(String name) {
		List<RegUser> userlist = System.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.name == name && user.isBanned() == false)
				user.setBanned(true);
		}
	}

	protected void unBanUser(String name) {
		List<RegUser> userlist = System.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.name == name && user.isBanned() == true)
				user.setBanned(false);
		}
	}

	protected void createAdmin(String name, String password) {
		Admin newAdmin = new Admin();
		newAdmin.name = name;
		newAdmin.password = password;
		System.getSystem().getAdminList().add(newAdmin);
	}
}

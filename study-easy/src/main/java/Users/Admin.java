package Users;

import java.util.List;

import System.System;

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
			if (user.name == name && user.banned == false)
				user.banned = true;
		}
	}

	protected void unBanUser(String name) {
		List<RegUser> userlist = System.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.name == name && user.banned == true)
				user.banned = false;
		}
	}
	
	protected void createAdmin(String name, String password){
		Admin newAdmin = new Admin();
		newAdmin.name = name;
		newAdmin.password = password;
		System.getSystem().getAdminList().add(newAdmin);
	}
}

package users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import sharedAttributes.Pinnwall;
import system.System;

@Entity
public class Admin extends User {

	protected void deleteUser(String name) {
		List<RegUser> userlist = System.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.getName() == name)
				user = null;
		}
	}

	protected void banUser(String name) {
		List<RegUser> userlist = System.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.getName() == name && user.isBanned() == false)
				user.setBanned(true);
		}
	}

	protected void unBanUser(String name) {
		List<RegUser> userlist = System.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.getName() == name && user.isBanned() == true)
				user.setBanned(false);
		}
	}

	protected void createAdmin(String name, String password) {
		Admin newAdmin = new Admin();
		newAdmin.name = name;
		newAdmin.password = password;
		newAdmin.registeredSince = new Date();
		System.getSystem().getAdminList().add(newAdmin);
	}
	
	protected void banPinnwall(Pinnwall pinn){
		if(pinn.getBanned() == false)
			pinn.setBanned(true);		
	}
	
	protected void unBanPinnwall(Pinnwall pinn){
		if(pinn.getBanned())
			pinn.setBanned(false);
	}
	
	public static Admin createStandardAdmin(){
		Admin standard = new Admin();
		standard.name = "standard";
		standard.password = "pissOff";
		System.getSystem().getAdminList().add(standard);
		return standard;
	}
}

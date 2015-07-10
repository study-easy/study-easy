package users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import sharedAttributes.Pinnwall;
import system.Controller;

@Entity@Table(name = "Admin")
public class Admin extends User {

	protected void deleteUser(String name) {
		List<RegUser> userlist = Controller.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.getName() == name)
				user = null;
		}
	}

	protected void banUser(String name) {
		List<RegUser> userlist = Controller.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.getName() == name && user.isBanned() == false)
				user.setBanned(true);
		}
	}

	protected void unBanUser(String name) {
		List<RegUser> userlist = Controller.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.getName() == name && user.isBanned() == true)
				user.setBanned(false);
		}
	}

	protected boolean createAdmin(String name, String password) {
		Controller.getSystem();
		boolean nameOccupied = false;
		for (RegUser user : Controller.getSystem().getUserList()) {
			if (user.getName() == name)
				nameOccupied = true;
		}
		for (Admin admin : Controller.getSystem().getAdminList()) {
			if (admin.getName() == name)
				nameOccupied = true;
		}
		if (nameOccupied) {
			return false;
		} else {
			Admin newAdmin = new Admin();
			newAdmin.name = name;
			newAdmin.password = password;
			newAdmin.registeredSince = new Date();
			Controller.getSystem().getAdminList().add(newAdmin);
			return true;
		}
	}

	protected void banPinnwall(Pinnwall pinn) {
		if (pinn.getBanned() == false)
			pinn.setBanned(true);
	}

	protected void unBanPinnwall(Pinnwall pinn) {
		if (pinn.getBanned())
			pinn.setBanned(false);
	}

	public static Admin createStandardAdmin() {
		if (Controller.getSystem().getAdminList().isEmpty()) {
			Admin standard = new Admin();
			standard.name = "standard";
			standard.password = "pissOff";
			Controller.getSystem().getAdminList().add(standard);
			return standard;
		}else{
			return null;
		}
	}
}
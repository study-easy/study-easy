package study_easy.users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.AdminServiceImpl;
import study_easy.service.UserPinnServiceImpl;
import study_easy.sharedAttributes.UserPinn;
import study_easy.system.Controller;

@Entity
@Table(name = "Admin")
@Component
public class Admin extends User {
	
	@Autowired
	private static AdminServiceImpl AS;
	@Autowired
	private static UserPinnServiceImpl UPS;

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

	protected void createAdmin(String name, String password) {
		Admin newAdmin = new Admin();
		newAdmin.name = name;
		newAdmin.password = password;
		newAdmin.registeredSince = new Date();
		Controller.getSystem().getAdminList().add(newAdmin);
		AS.addAdmin(newAdmin);

	}

	protected void banUserPinnwall(UserPinn pinn) {
		if (pinn.getBanned() == false) {
			pinn.setBanned(true);
			UPS.updateUserPinnBan(pinn.getOwner(), pinn.getBanned());
		}
	}

	protected void unBanUserPinnwall(UserPinn pinn) {
		if (pinn.getBanned()){
			pinn.setBanned(false);
			UPS.updateUserPinnBan(pinn.getOwner(), pinn.getBanned());
		}
	}

	public static void createStandardAdmin() {
		if (Controller.getSystem().getAdminList().isEmpty()) {
			Admin standard = new Admin();
			standard.setName("standard");
			standard.setPassword("admin123");

			Controller.getSystem().getAdminList().add(standard);
			AS.addAdmin(standard);
		}
	}
}

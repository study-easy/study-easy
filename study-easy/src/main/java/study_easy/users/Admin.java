package study_easy.users;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import study_easy.service.AdminServiceImpl;
import study_easy.service.UserPinnServiceImpl;
import study_easy.sharedAttributes.UserPinn;
import study_easy.system.Functionals;

@Entity
@Table(name = "Admin")
public class Admin extends User {

	protected void deleteUser(String name) {
		List<RegUser> userlist = Functionals.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.getName() == name)
				user = null;
		}
	}

	protected void banUser(String name) {
		List<RegUser> userlist = Functionals.getSystem().getUserList();
		for (RegUser user : userlist) {
			if (user.getName() == name && user.isBanned() == false)
				user.setBanned(true);
		}
	}

	protected void unBanUser(String name) {
		List<RegUser> userlist = Functionals.getSystem().getUserList();
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
		Functionals.getSystem().getAdminList().add(newAdmin);
		AdminServiceImpl AS = new AdminServiceImpl();
		AS.addAdmin(newAdmin);

	}

	protected void banUserPinnwall(UserPinn pinn) {
		if (pinn.getBanned() == false) {
			pinn.setBanned(true);
			UserPinnServiceImpl UPS = new UserPinnServiceImpl();
			UPS.updateUserPinnBan(pinn.getOwner(), pinn.getBanned());
		}
	}

	protected void unBanUserPinnwall(UserPinn pinn) {
		if (pinn.getBanned()){
			pinn.setBanned(false);
			UserPinnServiceImpl UPS = new UserPinnServiceImpl();
			UPS.updateUserPinnBan(pinn.getOwner(), pinn.getBanned());
		}
	}

	public static void createStandardAdmin() {
		if (Functionals.getSystem().getAdminList().isEmpty()) {
			Admin standard = new Admin();
			standard.setName("standard");
			standard.setPassword("admin123");

			Functionals.getSystem().getAdminList().add(standard);
			AdminServiceImpl AS = new AdminServiceImpl();
			AS.addAdmin(standard);
		}
	}
}

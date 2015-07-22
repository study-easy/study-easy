package study_easy.users;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

import study_easy.sharedAttributes.UserPinn;

@Entity
@Table(name = "Admin")
public class Admin extends User {

	protected void deleteUser(RegUser user) {
		user = null;
	}

	protected void banUser(RegUser user) {
		if (user.isBanned() == false)
			user.setBanned(true);
	}

	protected void unBanUser(RegUser user) {
		if (user.isBanned() == true)
			user.setBanned(false);
	}

	protected Admin createAdmin(String name, String password) {
		Admin newAdmin = new Admin();
		newAdmin.name = name;
		newAdmin.password = password;
		newAdmin.registeredSince = new Date();
		return newAdmin;

	}

	protected void banUserPinnwall(UserPinn pinn) {
		if (pinn.getBanned() == false)
			pinn.setBanned(true);
	}

	protected void unBanUserPinnwall(UserPinn pinn) {
		if (pinn.getBanned())
			pinn.setBanned(false);
	}

	public static Admin createStandardAdmin(boolean isEmpty) {
		if (isEmpty) {
			Admin standard = new Admin();
			standard.setName("standard");
			standard.setPassword("admin123");
			return standard;
		} else
			return null;
	}
}

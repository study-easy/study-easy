package study_easy.users;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.AdminServiceImpl;
import study_easy.service.UserPinnServiceImpl;
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
import study_easy.sharedAttributes.UserPinn;

@Entity
@Table(name = "Admin")
@Component
public class Admin extends User {
	
	@Autowired
	private static AdminServiceImpl AS;
	@Autowired
	private static UserPinnServiceImpl UPS;

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
<<<<<<< HEAD
		Controller.getSystem().getAdminList().add(newAdmin);
		AS.addAdmin(newAdmin);
=======
		return newAdmin;
>>>>>>> origin/ConnorsVerzweiflungsBranch

	}

	protected void banUserPinnwall(UserPinn pinn) {
		if (pinn.getBanned() == false)
			pinn.setBanned(true);
<<<<<<< HEAD
			UPS.updateUserPinnBan(pinn.getOwner(), pinn.getBanned());
		}
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	protected void unBanUserPinnwall(UserPinn pinn) {
		if (pinn.getBanned())
			pinn.setBanned(false);
<<<<<<< HEAD
			UPS.updateUserPinnBan(pinn.getOwner(), pinn.getBanned());
		}
=======
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}

	public static Admin createStandardAdmin(boolean isEmpty) {
		if (isEmpty) {
			Admin standard = new Admin();
			standard.setName("standard");
			standard.setPassword("admin123");
<<<<<<< HEAD

			Controller.getSystem().getAdminList().add(standard);
			AS.addAdmin(standard);
		}
=======
			return standard;
		} else
			return null;
>>>>>>> origin/ConnorsVerzweiflungsBranch
	}
}

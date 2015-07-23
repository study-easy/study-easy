package study_easy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study_easy.dao.AdminDAOImpl;
import study_easy.dao.RegUserDAOImpl;
import study_easy.sharedAttributes.Badge;
import study_easy.sharedAttributes.UserPinn;
import study_easy.users.Admin;
import study_easy.users.RegUser;
import study_easy.users.User;

@Service
@Transactional
public class RegUserService {

	@Autowired
	private RegUserDAOImpl regUserDAO;
	@Autowired
	private AdminDAOImpl adminDAO;

	public RegUserService() {

	}

	public void addRegUser(RegUser user) {
		this.regUserDAO.addRegUser(user);
	}

	public List<RegUser> listRegUsers() {
		return this.regUserDAO.listRegUsers();
	}

	public void deleteRegUser(String Username) {
		this.regUserDAO.deleteRegUser(Username);
	}

	public void updateRegUser(RegUser user) {
		regUserDAO.updateRegUser(user);
	}

	public RegUser getThisUser(String name) {
		RegUser user = null;
		for (RegUser findUser : regUserDAO.listRegUsers())
			if (findUser.getName().equals(name)) {
				user = findUser;
				break;
			}
		return user;
	}

	public void levelUpUser(RegUser user) {
		int points = user.getXpPoints();
		switch (user.getLevel()) {
		case 0:
			if (points >= 500)
				user.setLevel(1);
		case 1:
			if (points >= 1000)
				user.setLevel(2);
		case 2:
			if (points >= 2000)
				user.setLevel(3);
		case 3:
			if (points >= 4000)
				user.setLevel(4);
		case 4:
			if (points >= 7500)
				user.setLevel(5);
		case 5:
			if (points >= 12000)
				user.setLevel(6);
		case 6:
			if (points >= 18000)
				user.setLevel(7);
		case 7:
			if (points >= 25000)
				user.setLevel(8);
		case 8:
			if (points >= 35000)
				user.setLevel(9);
		case 9:
			if (points >= 50000)
				user.setLevel(10);
		case 10:
			break;
		}
		//this.regUserDAO.

	}

	public boolean register(String password, String testPassword, String name, String sicherheit, String sicherheitAntw) {
		boolean nameOccupied = false;
		for (RegUser user : regUserDAO.listRegUsers()) {
			if (user.getName().equals(name))
				nameOccupied = true;
		}
		for(Admin admin : adminDAO.listAdmin()){
			if(admin.getName().equals(name))
				nameOccupied = true;
		}
		if (nameOccupied == true) {
			return false;
		} else if (password.equals(testPassword)) {
			RegUser regUser = new RegUser();
			regUser.setName(name);
			regUser.setPassword(password);
			regUser.setBanned(false);
			regUser.setRegisteredSince(new Date());
			regUser.setXpPoints(0);
			regUser.setLevel(0);
			regUser.setSicherheitsfrage(sicherheit);
			regUser.setSicherheitsfragecheck(sicherheitAntw);
			UserPinn pinn = new UserPinn();
			pinn.setBanned(false);
			//pinn.setOwner(regUser.getName());
			regUser.setPinn(pinn);
			regUserDAO.addRegUser(regUser);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean signIn(String password, String name) {
		String comparePassword = null;
		for (User user : regUserDAO.listRegUsers()) {
			if (user.getName().equals(name)) {
				comparePassword = user.getPassword();
			} else {
				for (User admin : adminDAO.listAdmin()) {
					if (admin.getName().equals(name)) {
						comparePassword = admin.getPassword();
					} else {
						return false;
					}
				}
			}
		}
		if ( comparePassword != null && comparePassword.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void giveXP(RegUser user, int numOfRight) {
		user.setXpPoints(user.getXpPoints() + (numOfRight * 10));
		regUserDAO.updateRegUser(user);
	}
	
	public void awardBadge(Badge badge, RegUser user) {
		if (badge.conditionsTrue(user) && !user.getEarnedBadges().contains(badge)) {
			user.getEarnedBadges().add(badge);
			this.regUserDAO.updateRegUser(user);
		}
	}

}

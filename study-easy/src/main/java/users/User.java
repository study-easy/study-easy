package users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import system.Controller;


public abstract class User {

	@Id
	@Column(name = "name")
	protected String name;
	@Column(name = "password")
	protected String password;
	@Column(name = "email")
	private String email;
	@Column(name = "registered Since")
	protected Date registeredSince;

	public static User signIn(String name, String password) {
		User signingIn = null;
		List<RegUser> regUserlist = Controller.getSystem().getUserList();
		List<Admin> adminlist = Controller.getSystem().getAdminList();
		String comparePassword = null;
		for (User user : regUserlist) {
			if (user.getName() == name) {
				comparePassword = user.password;
				signingIn = user;
				break;
				}
		}
		for (User admin : adminlist) {
			if (admin.getName() == name) {
				comparePassword = admin.password;
				signingIn = admin;
				break;
			} else {
				return null;
			}
		}
		if (comparePassword == password){
			return signingIn;
		} else {
			return null;
		}

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegisteredSince(Date registeredSince) {
		this.registeredSince = registeredSince;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}
	
	public Date getRegisteredSince() {
		return this.registeredSince;
	}

	public String getRegisteredSinceAsString() {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return format.format(this.registeredSince);
	}
	
}

package users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import system.Controller;

@Entity
public abstract class User {
	@NotNull
	@Size(min = 4)
	@Column(name = "password")
	protected String password;
	@Id
	@NotNull
	@Column(name = "name")
	protected String name;
	@NotNull
	@Column(name = "email")
	private String email;
	@Column(name = "registered_since")
	protected Date registeredSince;
	@Size(min = 4, max = 10)
	String passwordcheck;
	@AssertTrue
	Boolean checkbox;

	@NotNull
	String sicherheitsfrage;
	@NotNull
	String sicherheitsfragecheck;

	public static User signIn(String name, String password) {
		boolean found = false;
		User user = null;
		for (User reguser : Controller.getSystem().getUserList()) {
			if (reguser.getName() == name) {
				found = true;
				user = reguser;
			}
		}
		if (!found) {
			for (User admin : Controller.getSystem().getAdminList()) {
				if (admin.getName() == name) 
					user = admin;
			}
		}
		if (user.getPassword() == password)
			return user;
		else
			return null;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSicherheitsfrage() {
		return this.sicherheitsfrage;
	}

	public void setSicherheitsfrage(String sicherheitsfrage) {
		this.name = sicherheitsfrage;
	}

	public String getSicherheitsfragecheck() {
		return this.sicherheitsfragecheck;
	}

	public void setSicherheitsfragecheck(String sicherheitsfragecheck) {
		this.name = sicherheitsfragecheck;
	}

	public void setCheck(Boolean check) {
		this.checkbox = check;
	}

	public Boolean getCheck() {
		return this.checkbox;
	}

	public String getPasswordcheck() {
		return this.passwordcheck;
	}

	public void setPasswordcheck(String passwortcheck) {
		this.name = passwortcheck;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getRegisteredSince() {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return format.format(this.registeredSince);
	}

	public Date getRegisteredSinceDate() {
		return registeredSince;
	}

}

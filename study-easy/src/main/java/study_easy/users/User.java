package study_easy.users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study_easy.service.AdminServiceImpl;
import study_easy.service.RegUserServiceImpl;
import study_easy.system.Controller;

@MappedSuperclass
@Component
public abstract class User {
	@NotNull
	@Size(min = 4)
	@Column
	protected String password;
	@Id
	@NotNull
	@Column(name = "userName")
	protected String name;
	@NotNull
	@Column
	private String email;
	@Column
	protected Date registeredSince;
	@Size(min = 4, max = 10)
	String passwordcheck;
	@Transient
	@AssertTrue
	Boolean checkbox;

	@NotNull
	String sicherheitsfrage;
	@NotNull
	String sicherheitsfragecheck;
	
	@Autowired
	private static RegUserServiceImpl RUS;
	@Autowired
	private static AdminServiceImpl AS;

	public boolean signIn(String password, String name) {
		List<RegUser> regUserlist = Controller.getSystem().getUserList();
		List<Admin> adminlist = Controller.getSystem().getAdminList();
		String comparePassword = null;
		for (User user : regUserlist) {
			if (user.getName().equals(name)) {
				comparePassword = user.password;
			} else {
				for (User admin : adminlist) {
					if (admin.getName().equals(name)) {
						comparePassword = admin.password;
					} else {
						return false;
					}
				}
			}
		}
		if (comparePassword.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
		if (this.getClass() == RegUser.class) {
			RUS.updateRegUserPassword(this.name, this.password);
		} else if (this.getClass() == Admin.class) {
			AS.updateAdminPassword(this.name, this.password);
		}
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
		if (this.getClass() == RegUser.class) {
			RUS.updateRegUserEMail(this.name, this.email);
		} else if (this.getClass() == Admin.class) {
			AS.updateAdminEmail(this.name, this.email);
		}
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

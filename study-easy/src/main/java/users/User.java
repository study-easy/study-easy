package users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

<<<<<<< HEAD
import javax.persistence.*;

import system.Controller;

=======
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import system.Controller;
>>>>>>> origin/develop

public abstract class User {
<<<<<<< HEAD

	@Id
	@Column(name = "name")
	protected String name;
	@Column(name = "password")
	protected String password;
	@Column(name = "email")
=======
	@NotNull
	@Size(min=4)
	protected String password;
	@Id
	@NotNull
	protected String name;
	@NotNull
>>>>>>> origin/develop
	private String email;
	@Column(name = "registered Since")
	protected Date registeredSince;
	@Size(min=4, max=10)
	String passwordcheck;
	@AssertTrue
	Boolean checkbox;
	
	@NotNull
	String sicherheitsfrage;
	@NotNull
	String sicherheitsfragecheck;

	
	

<<<<<<< HEAD
	public static User signIn(String name, String password) {
		User signingIn = null;
=======
	public boolean signIn(String password, String name) {
>>>>>>> origin/develop
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

	public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.name = password;
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
	public void setName(String name){
		this.name = name;
	}
	
	public Date getRegisteredSince() {
		return this.registeredSince;
	}

	public String getRegisteredSinceAsString() {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return format.format(this.registeredSince);
	}
	
}

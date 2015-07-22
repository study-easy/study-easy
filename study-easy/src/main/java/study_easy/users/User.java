package study_easy.users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class User {
	@Size(min = 4)
	@Column
	protected String password;
	@Id
	@Column(name = "userName")
	protected String name;
	@Column
	private String email;
	@Column
	protected Date registeredSince;
	@Size(min = 4, max = 10)
	String passwordcheck;
	@Transient
	@AssertTrue
	Boolean checkbox;

	String sicherheitsfrage;
	String sicherheitsfragecheck;

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
	
	public void setRegisteredSince(Date date){
		this.registeredSince = date;
	}

}

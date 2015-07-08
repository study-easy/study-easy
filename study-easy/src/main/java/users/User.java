package users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import system.System;

@Entity
public abstract class User {

	protected String password;
	@Id
	protected String name;
	private String email;
	protected Date registeredSince;

	public static boolean signIn(String password, String name) {
		List<RegUser> regUserlist = System.getSystem().getUserList();
		List<Admin> adminlist = System.getSystem().getAdminList();
		String comparePassword = null;
		for (User user : regUserlist) {
			if (user.getName() == name) {
				comparePassword = user.password;
			} else {
				for(User admin : adminlist){
					if(admin.getName() == name){
						comparePassword = admin.password;
					}else{
						return false;
					}
				}
			}
		}
		if (comparePassword == password) {
			return true;
		} else {
			return false;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getRegisteredSince(){
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return format.format(this.registeredSince);
	}

}

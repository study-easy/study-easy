package users;

import java.util.List;

import system.System;

public abstract class User {

	String password;
	String name;
	String email;

	public boolean signIn(String password, String name) {
		List<RegUser> userlist = System.getSystem().getUserList();
		String comparePassword = null;
		for (User user : userlist) {
			if (user.name == name) {
				comparePassword = user.password;
			} else {
				return false;
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

}

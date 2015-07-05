package Users;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import System.System;

public class User {
	@NotNull
	@Size(min=4, max=10)
	String password;
	@NotNull
	String name;
	@NotNull
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
	
	public void setName(String name){
		this.name=name;
	}
	public String getPassword(){
		return this.name;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

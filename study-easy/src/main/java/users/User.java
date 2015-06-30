package users;

import java.util.List;


import system.System;


public abstract class User {

	String password;
	String name;
	String email;

	public boolean signIn(String password, String name) {
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

}

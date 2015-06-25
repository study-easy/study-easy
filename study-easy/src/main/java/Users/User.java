package Users;

import java.util.List;
import java.util.ArrayList;

import System.System;

public abstract class User {

	String password;
	String name;
	String email;

	public boolean signIn(String password, String name) {
		List<User> userlist = System.getSystem().getUserList();
		String comparePassword = null;
		for (User user : userlist) {
			if (user.name == name) {
				comparePassword = user.password;
			}else{
				return false;
			}
		}
		if (comparePassword == password) {
			return true;
		} else {
			return false;
		}
	}
	
}
